package com.liu.service.impl;

import com.liu.annotation.Service;

import java.util.Map;

@Service
public class MyServiceImpl implements MyService{

    @Override
    public int insert(Map map) {
        System.out.println("MyServiceImpl:" + "insert");
        return 0;
    }

    @Override
    public int delete(Map map) {
        System.out.println("MyServiceImpl:" + "delete");
        return 0;
    }

    @Override
    public int update(Map map) {
        System.out.println("MyServiceImpl:" + "update");
        return 0;
    }

    @Override
    public int select(Map map) {
        System.out.println("MyServiceImpl:" + "select");
        return 0;
    }
}
