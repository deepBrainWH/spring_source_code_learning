package com.myspring.service.imp;

import com.myspring.dao.UserDao;
import com.myspring.service.UserService;
import com.myspring.tansaction.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

@Service("userServiceImp")
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    private final TransactionUtils transactionUtils;

    public UserServiceImp(UserDao userDao, TransactionUtils transactionUtils) {
        this.userDao = userDao;
        this.transactionUtils = transactionUtils;
    }

    @Override
    public void add() {
        TransactionStatus status = null;
        try {
            status = transactionUtils.begin();
            userDao.add("hello", "world");
            System.out.println("-=============================");
            int a = 1/0;
            userDao.add("world", "hello");
            if (status != null)
                transactionUtils.commit(status);
        } catch (Exception e) {
            e.getMessage();
            if (status != null)
                transactionUtils.rollback(status);
        }
    }

    @Override
    public void anno_transactionAdd() {
        userDao.add("hello", "world");
        System.out.println("-=============================");
        int a = 1/0;
        userDao.add("world", "hello");
    }
}
