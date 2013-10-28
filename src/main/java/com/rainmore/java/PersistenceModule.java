package com.rainmore.java;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.rainmore.java.services.HelloWorld;
import com.rainmore.java.services.HelloWorldSingleton;
import com.rainmore.java.services.PersonService;
import com.rainmore.java.services.PersonServiceImpl;

public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OtherExample.class);

        bind(PersonService.class).to(PersonServiceImpl.class);
        bind(HelloWorldSingleton.class);

    }

    @Provides
    HelloWorld provideHelloWorld() {
        return new HelloWorld();
    }

}
