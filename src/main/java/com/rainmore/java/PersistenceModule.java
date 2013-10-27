package com.rainmore.java;


import com.google.inject.AbstractModule;

public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OtherExample.class);
    }

}
