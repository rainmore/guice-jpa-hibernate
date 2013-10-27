package com.rainmore.java;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

public class ApplicationInitializer {
    @Inject
    ApplicationInitializer(PersistService persistenceService) {
        // start JPA
        persistenceService.start();
    }

}
