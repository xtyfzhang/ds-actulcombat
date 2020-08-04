package com.ds.dsactulcombat.examples.controller;


import com.ds.dsactulcombat.examples.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/examples")
public class ExamplesController {

    @Autowired
    DemoMapper demoMapper;

    @RequestMapping("/getInt")
    public String getInt(){

        /*try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select 1 from dual");
            resultSet.next();
            System.out.println("查询信息" + resultSet.getInt(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
        return demoMapper.getDemoInfo();
    }
}
