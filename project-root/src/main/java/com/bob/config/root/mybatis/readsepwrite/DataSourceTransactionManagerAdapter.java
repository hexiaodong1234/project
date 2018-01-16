package com.bob.config.root.mybatis.readsepwrite;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 数据源事务管理器拓展
 *
 * @author Administrator
 * @create 2018-01-16 19:33
 */
public class DataSourceTransactionManagerAdapter extends DataSourceTransactionManager {

    private SqlSessionFactory readSqlSessionFactory;

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {

        if (definition.isReadOnly()) {

        }else{

        }
        //TransactionSynchronizationManager.bindResource();
        super.doBegin(transaction, definition);
    }
}
