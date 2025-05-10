package com.wiley.beginningspring.ch7.service;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Bonjour depuis Spring (XML) !");
    }
}
