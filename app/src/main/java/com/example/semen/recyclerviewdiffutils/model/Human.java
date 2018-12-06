package com.example.semen.recyclerviewdiffutils.model;

import android.support.annotation.NonNull;

import java.util.Objects;

public class Human implements Comparable {
    private final int id;
    private final String name;
    private final int age;

    public Human(int id, String name, int age) {
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

    @Override
    public int compareTo(@NonNull Object o) {
        Human compare = (Human) o;

        if (compare.id == this.id && compare.name.equals(this.name) && compare.age == (this.age)) {
            return 0;
        }
        return 1;
    }
}
