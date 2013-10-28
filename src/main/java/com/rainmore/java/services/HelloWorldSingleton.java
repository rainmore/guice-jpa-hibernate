package com.rainmore.java.services;


import javax.inject.Singleton;

@Singleton
public class HelloWorldSingleton {
    public String say() {
        return this.getClass().toString();
    }
}
