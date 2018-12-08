package com.example.semen.recyclerviewdiffutils.model;

import java.util.Objects;

public class Human {
    private final int id;
    private final String name;
    private final int age;

    Human(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id == human.id &&
                age == human.age &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age);
    }
}
