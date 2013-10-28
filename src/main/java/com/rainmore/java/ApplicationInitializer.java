package com.rainmore.java;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

public class ApplicationInitializer {
    private final PersistService persistService;

    @Inject
    ApplicationInitializer(PersistService persistenceService) {
        // start JPA
        persistService = persistenceService;
        persistService.start();
    }


    public void stop() {
        persistService.stop();
    }
}
