package com.example.semen.recyclerviewdiffutils.model;

import java.util.ArrayList;
import java.util.List;

public class HumanManager {

    public static List<Human> getHumanListOne() {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human(1, "Ivan", 19));
        humanList.add(new Human(2, "John", 20));
        humanList.add(new Human(3, "Isaac", 21));
        humanList.add(new Human(4, "LeBron", 22));
        humanList.add(new Human(5, "Kobe", 23));
        humanList.add(new Human(6, "Albert", 24));
        humanList.add(new Human(7, "Donald", 25));
        humanList.add(new Human(8, "Vladimir", 26));
        humanList.add(new Human(9, "Petr", 27));
        humanList.add(new Human(10, "Dick", 28));
        humanList.add(new Human(11, "Franklin", 29));

        return humanList;
    }

    public static List<Human> getHumanListTwo() {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human(19, "Ivan", 19));
        humanList.add(new Human(2, "Dima", 20));
        humanList.add(new Human(3, "Petr", 21));

        return humanList;
    }

    public static List<Human> getHumanListThree() {
        List<Human> humanList = new ArrayList<>();

        humanList.add(new Human(1, "Ivan", 19));
        humanList.add(new Human(2, "John", 20));
        humanList.add(new Human(3, "Isaac", 21));
        humanList.add(new Human(4, "LeBron", 22));
        humanList.add(new Human(5, "Kobe", 23));


        return humanList;
    }
}
