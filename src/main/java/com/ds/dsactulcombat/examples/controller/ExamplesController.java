package com.ds.dsactulcombat.examples.controller;


import com.ds.dsactulcombat.examples.mapper.ExamplesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples")
public class ExamplesController {

    @Autowired
    ExamplesMapper examplesMapper;

    @RequestMapping("/getInt")
    public int getInt(){

        return examplesMapper.getInt();
    }
}
