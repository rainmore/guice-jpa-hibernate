package com.rainmore.java.services;

import com.rainmore.java.model.Person;
import org.hibernate.SQLQuery;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonService {
    private EntityManager em;

    public PersonService(EntityManager em) {
        this.em = em;
    }

    public Person create(String name) {
        Person Person = new Person(name);
        em.persist(Person);

        return Person;
    }

    public Person changeName(Long id, String name) {
        Person person = em.find(Person.class, id);

        if (person != null) {
            person.setName(name);
            em.persist(person);
        }

        return person;
    }

    public void remove(Long id) {
        Person Person = em.find(Person.class, id);

        if (Person != null) {
            em.remove(Person);
        }
    }

    public Person findById(long id) {
        return em.find(Person.class, id);
    }

    public List<Person> findAll() {
        TypedQuery<Person> query = em.createQuery("SELECT a FROM Person a", Person.class);
        return query.getResultList();
    }

    public Set<Person> findChildren(Person person) {
        String sql = "SELECT a FROM Person a WHERE parent_id = :parent_id";
        TypedQuery<Person> query = em.createQuery(sql, Person.class).setParameter("parent_id", person.getId());

        Set<Person>  set = new HashSet<Person>();

        for(Person p : query.getResultList()) {
            set.add(p);
        }
        person.setChildren(set);
        return set;
    }
}
