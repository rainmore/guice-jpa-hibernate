package com.rainmore.java.services;

import com.rainmore.java.model.Person;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class PersonService {

    @Inject
    private EntityManager em;

    @Transactional
    public Person create(String name) {
        Person Person = new Person(name);
        em.persist(Person);

        return Person;
    }

    @Transactional
    public Person changeName(Long id, String name) {
        Person person = em.find(Person.class, id);

        if (person != null) {
            person.setName(name);
            em.persist(person);
        }

        return person;
    }

    @Transactional
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
