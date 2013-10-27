package com.rainmore.java;


import com.rainmore.java.dao.PersonDao;
import com.rainmore.java.model.Person;

import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OtherExample {

    private static final Logger logger = Logger.getLogger(OtherExample.class
            .getName());

    private final PersonDao personDao;

    @Inject
    public OtherExample(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void run() {
        // persist another person
        Person p = new Person();
        p.setName("Person X");
        personDao.create(p);

        logger.log(Level.INFO, "Querying DB for person with name Person 1..");
        // retrieve one person from the persisted people
        Person retrieved = personDao.getByName("Person 1");

        logger.log(Level.INFO, "Retrieved " + retrieved.getName());
    }

}
