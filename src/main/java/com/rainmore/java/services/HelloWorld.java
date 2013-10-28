package com.rainmore.java.services;


import javax.inject.Singleton;

@Singleton
public class HelloWorld {

    public String say() {
        return this.getClass().toString();
    }
}
