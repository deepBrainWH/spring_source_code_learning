package com.myspring.tansaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

//编程事务，（需要手动begin，手动回滚，手动commit)
@Component
public class TransactionUtils {

    private final DataSourceTransactionManager transactionManager;

    public TransactionUtils(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public TransactionStatus begin(){
        return transactionManager.getTransaction(new DefaultTransactionAttribute());
    }

    public void commit(TransactionStatus status){
        transactionManager.commit(status);
    }

    public void rollback(TransactionStatus status){
        transactionManager.rollback(status);
    }

}
