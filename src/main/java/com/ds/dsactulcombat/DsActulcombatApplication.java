package com.ds.dsactulcombat;

import com.ds.dsactulcombat.common.BaseDataSource;
import com.ds.dsactulcombat.monitoring.DataSourceEnpoint;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.ds.dsactulcombat.examples.mapper")
public class DsActulcombatApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsActulcombatApplication.class, args);
    }

   @Bean
    @Primary
    public BaseDataSource dataSource(){
        return new BaseDataSource();
    }

    @Bean
    public DataSourceEnpoint dataSourceEnpoint(){

        return new DataSourceEnpoint(this.dataSource());
    }
}
