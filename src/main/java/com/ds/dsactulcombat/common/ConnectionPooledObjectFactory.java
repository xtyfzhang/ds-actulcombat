package com.ds.dsactulcombat.common;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.sql.*;
import java.util.NoSuchElementException;

public class ConnectionPooledObjectFactory implements PooledObjectFactory<BaseConnection> {

    private ObjectPool<BaseConnection> objectPool;

    public ObjectPool<BaseConnection> getObjectPool() {
        return objectPool;
    }

    public void setObjectPool(ObjectPool<BaseConnection> objectPool) {
        this.objectPool = objectPool;
    }


    @Override
    public PooledObject<BaseConnection> makeObject() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://106.13.226.223:3306/user?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true",
                "root",
                "L8fRd2*i(dE6"
        );
        BaseConnection baseConnection = new BaseConnection();
        baseConnection.setConnection(connection);
        baseConnection.setObjectPool(objectPool);
        return new DefaultPooledObject<>(baseConnection);
    }

    @Override
    public void destroyObject(PooledObject<BaseConnection> p) throws Exception {

        p.getObject().close();
    }

    @Override
    public boolean validateObject(PooledObject<BaseConnection> p) {
        Connection connection = p.getObject();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT 1");
            ResultSet resultSet = statement.executeQuery();
            int i = resultSet.getInt(1);
            return i == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void activateObject(PooledObject<BaseConnection> p) throws Exception {

        // 镜像额外的配置
    }

    @Override
    public void passivateObject(PooledObject<BaseConnection> p) throws Exception {

        BaseConnection baseConnection = p.getObject();

        Statement statement = baseConnection.getStatement();
        if (statement != null) {
            statement.close();
        }
    }
}
