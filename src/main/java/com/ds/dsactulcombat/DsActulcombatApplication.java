package com.ds.dsactulcombat;

import com.ds.dsactulcombat.common.BaseDataSource;
import com.ds.dsactulcombat.monitoring.DataSourceEnpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class DsActulcombatApplication {

    @Autowired
    private BaseDataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DsActulcombatApplication.class, args);
    }

    @Bean
    public DataSourceEnpoint dataSourceEnpoint(){

        return new DataSourceEnpoint(this.dataSource);
    }
}
