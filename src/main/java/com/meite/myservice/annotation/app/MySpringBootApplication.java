package com.meite.myservice.annotation.app;


import com.meite.myservice.annotation.annotation.MyAutowrite;
import com.meite.myservice.annotation.annotation.MyService;
import com.meite.myservice.annotation.context.BeanNotFoundException;
import com.meite.myservice.annotation.context.MySpringBootException;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class MySpringBootApplication {

    private static Set<String> allClassName = new LinkedHashSet<>(16);
    private static Map<String, Class<?>> serviceBean = new ConcurrentHashMap<>(16);
    private static String classLoaderPath;
    private static MySpringBootApplication context;
    private static Logger logger = Logger.getRootLogger();

    private static String specyPackage;

    public MySpringBootApplication(){
    }

    public MySpringBootApplication(String packageName){
        specyPackage = packageName;
    }

    public static void run(Class<?> clazz) throws MySpringBootException {
        logger.info("load package name;");
        classLoaderPath = Objects.requireNonNull(clazz.getClassLoader().getResource("./")).getPath();
        logger.info("load project class loader path;");
        if(context == null)context = new MySpringBootApplication();
        if(specyPackage != null) scanPackage(specyPackage);
        else{
            String rootPackage = clazz.getPackage().getName();
            scanPackage(rootPackage);
        }
        try {
            loadAllClass();
        } catch (ClassNotFoundException e) {
            throw new MySpringBootException();
        }
    }

    private static void scanPackage(String packageName){
        String replace = packageName.replace(".", "/");
        File file = new File(classLoaderPath + replace);

        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.getName().matches("\\w+"))return true;
                if(pathname.getName().matches("\\w+\\$\\w+\\.class"))return false;
                return pathname.getName().endsWith(".class");
            }
        });
        assert files != null;
        for(File f: files){
            if(f.isDirectory()){
                scanPackage(packageName + "." + f.getName());
            }else {
                allClassName.add(packageName + "." + f.getName().replace(".class", ""));
            }
        }
    }

    private static void loadAllClass() throws ClassNotFoundException {
        for(String className: allClassName){
            Class<?> forName = Class.forName(className);
            MyService annotation = forName.getAnnotation(MyService.class);
            if(annotation != null){
                String name;
                if(annotation.name().equals("")){
                    name = forName.getSimpleName().substring(0, 1).toLowerCase() + forName.getSimpleName().substring(1);
                }else {
                    name = annotation.name();
                }
                serviceBean.put(name, forName);
            }
        }
    }

    public Object getBean(String beanName) throws IllegalAccessException, InstantiationException {
        Class<?> s = serviceBean.get(beanName);
        if(s == null)throw new BeanNotFoundException();
        else {
            Object res = s.newInstance();
            scanFields(s, res);
            return res;
        }
    }

    public Object getBeanByType(Class<?> beanType) throws IllegalAccessException, InstantiationException {
        for(Map.Entry<String, Class<?>> entry: serviceBean.entrySet()){
            if (entry.getValue().equals(beanType)){
                Class<?> classInfo = entry.getValue();
                Object o = classInfo.newInstance();
                scanFields(classInfo, o);
                return o;
            }
        }
        return null;
    }

    private void scanFields(Class<?> classInfo, Object instance) throws
            InstantiationException, IllegalAccessException {
        Field[] fields = classInfo.getDeclaredFields();
        for(Field field: fields){
            MyAutowrite annotation = field.getAnnotation(MyAutowrite.class);
            if(annotation != null){
                Class<?> declaringClass = field.getType();
                Object beanByType = getBeanByType(declaringClass);
                field.setAccessible(true);
                field.set(instance, beanByType);
            }
        }
    }

}
