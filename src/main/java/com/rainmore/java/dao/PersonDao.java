package com.rainmore.java.dao;

import com.rainmore.java.model.Person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PersonDao extends AbstractDao<Person> {

    public PersonDao() {
        super(Person.class);
    }

    public Person getByName(String name) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> person = cq.from(Person.class);

        Predicate cond1 = cb.equal(person.get(entityClass.getName()), name);
        cq.where(cond1);

        return getEntityManager().createQuery(cq).getSingleResult();
    }

}
