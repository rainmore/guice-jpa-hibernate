package com.rainmore.java.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "parent_id")
    private Person parent;

    @OneToMany(mappedBy="parent")
    private Set<Person> children = new HashSet<Person>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }

    public Set<Person> getChildren() {
        return children;
    }

    public void setChildren(Set<Person> children) {
        this.children = children;
    }

    public String toString() {
        return String.format("id: %d, name: %s", this.getId(), this.getName());
    }
}
