package com.rainmore.java;


import com.rainmore.java.dao.PersonDao;
import com.rainmore.java.model.Person;
import com.rainmore.java.services.PersonServiceImpl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OtherExample {

    private static final Logger logger = Logger.getLogger(OtherExample.class
            .getName());

    private final EntityManager em;

    private PersonServiceImpl service;

    @Inject
    public OtherExample(EntityManager em, PersonServiceImpl service) {
        this.em = em;
        this.service = service;
    }

    public void run() {

        System.out.println("--- Create and persist artist ---");
        em.getTransaction().begin();
        Person person = service.create("Franz Ferdinand");
        Person person2 = service.create("Franz Ferdinand");
        person2.setParent(person);
        em.getTransaction().commit();
        System.out.println(String.format("Persisted: %s\n", person));

        Long id = person.getId();

        System.out.println("--- Find artist ---");
        person = service.findById(id);
        System.out.println(String.format("Found: %s\n", person));

        System.out.println("--- Find all artists ---");
        List<Person> people = service.findAll();
        for (Person foundPerson : people) {
            System.out.println(String.format("Found: %s\n", foundPerson));
            System.out.println(String.format("Found: %s\n", foundPerson.getParent()));

            Set<Person> children = service.findChildren(foundPerson);

            System.out.println(String.format("Found: %s\n", children.size()));
        }

        System.out.println("--- Update artist ---");
        em.getTransaction().begin();
        person = service.changeName(1L, "Indie Rock");
        em.getTransaction().commit();
        System.out.println(String.format("Updated: %s\n", person));

        System.out.println("--- Remove artist ---");
        em.getTransaction().begin();
        service.remove(2L);
        service.remove(1L);
        em.getTransaction().commit();
        person = service.findById(1L);
        System.out.println(String.format("Found: %s\n", person));

    }

}
