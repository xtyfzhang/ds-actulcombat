package com.ds.dsactulcombat.monitoring;

import com.ds.dsactulcombat.common.BaseDataSource;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Endpoint(id="datasource")
public class DataSourceEnpoint {


    private BaseDataSource dataSource;

    public DataSourceEnpoint(BaseDataSource dataSource){

        this.dataSource = dataSource;
    }

    @ReadOperation
    public Map<String,Object> pool(){

        GenericObjectPool pool = dataSource.getPool();

        Map<String,Object> map = new HashMap<>();
        map.put("numActive",pool.getNumActive());
        map.put("numIdle",pool.getNumIdle());
        map.put("createdCount",pool.getCreatedCount());
        return map;
    }
}
