package com.example.semen.recyclerviewdiffutils.model;

import java.util.ArrayList;
import java.util.List;

public class HumanManager {

    public static List<Human> getHumanListOne() {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human(1, "Ivan", 19));
        humanList.add(new Human(2, "Dima", 20));
        humanList.add(new Human(3, "Petr", 21));

        return humanList;
    }

    public static List<Human> getHumanListTwo() {
        List<Human> humanList = new ArrayList<>();
        //change
        humanList.add(new Human(19, "Ivan", 19));
        humanList.add(new Human(2, "Dima", 20));
        humanList.add(new Human(3, "Petr", 21));
        humanList.add(new Human(4, "Marina", 25));
        humanList.add(new Human(5, "Donald", 33));

        return humanList;
    }

    public static List<Human> getHumanListThree() {
        List<Human> humanList = new ArrayList<>();

        //change
        humanList.add(new Human(1, "Ivan", 19));
        humanList.add(new Human(2, "Dima", 20));
        //change
        humanList.add(new Human(3, "Petro", 21));
        humanList.add(new Human(4, "Alex", 22));
        //delete one

        return humanList;
    }
}
