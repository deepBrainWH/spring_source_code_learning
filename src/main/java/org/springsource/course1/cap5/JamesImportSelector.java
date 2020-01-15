package org.springsource.course1.cap5;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Date: 1/14/20
 * Author: wangheng
 * Description: @ImportSelector使用.
 **/
public class JamesImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"org.springsource.course1.cap5.Tiger",
                "org.springsource.course1.cap5.Fish"};
    }
}
