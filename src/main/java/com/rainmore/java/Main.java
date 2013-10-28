package com.rainmore.java;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.rainmore.java.model.Person;
import com.rainmore.java.services.HelloWorld;
import com.rainmore.java.services.HelloWorldSingleton;
import com.rainmore.java.services.PersonService;
import com.rainmore.java.services.PersonServiceImpl;
import org.hibernate.collection.internal.PersistentBag;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static final void main(String... args) {
        Injector injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule("JpaBasicsTutorial"));
        ApplicationInitializer app = injector.getInstance(ApplicationInitializer.class);

//        injector.getInstance(OtherExample.class).run();

        HelloWorld h1 = injector.getInstance(HelloWorld.class);
        HelloWorld h2 = injector.getInstance(HelloWorld.class);

        System.out.println(h1.toString());
        System.out.println(h2.toString());

        HelloWorldSingleton hs1 = injector.getInstance(HelloWorldSingleton.class);
        HelloWorldSingleton hs2 = injector.getInstance(HelloWorldSingleton.class);

        System.out.println(hs1.toString());
        System.out.println(hs2.toString());

        PersonService p1 = injector.getInstance(PersonService.class);
        PersonService p2 = injector.getInstance(PersonService.class);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        app.stop();

    }

}
