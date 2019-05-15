package com.myspring.tansaction;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

//编程事务，（需要手动begin，手动回滚，手动commit)
@Component
@Scope("prototype")//设置成原型模式，解决线程安全
public class TransactionUtils {

    private final DataSourceTransactionManager transactionManager;

    public TransactionUtils(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    private TransactionStatus status = null;

    public TransactionStatus begin() {
        status = transactionManager.getTransaction(new DefaultTransactionAttribute());
        return status;
    }

    public void commit(TransactionStatus status) {
        transactionManager.commit(status);
    }

    public void rollback() {
        if (this.status != null)
            transactionManager.rollback(status);
    }

}
