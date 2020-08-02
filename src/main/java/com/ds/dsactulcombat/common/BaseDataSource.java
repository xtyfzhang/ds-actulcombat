package com.ds.dsactulcombat.common;

import org.apache.commons.pool2.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class BaseDataSource implements DataSource {

    private GenericObjectPool<BaseConnection> pool;



    public GenericObjectPool<BaseConnection> getPool() {
        return pool;
    }

    public void setPool(GenericObjectPool<BaseConnection> pool) {
        this.pool = pool;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    public BaseDataSource() {
        ConnectionPooledObjectFactory factory = new ConnectionPooledObjectFactory();
        this.pool = new GenericObjectPool<>(factory);
        factory.setObjectPool(pool);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
