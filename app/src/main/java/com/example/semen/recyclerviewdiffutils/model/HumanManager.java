package com.example.semen.recyclerviewdiffutils.model;

import com.example.semen.recyclerviewdiffutils.model.Human;

import java.util.ArrayList;
import java.util.List;

public class HumanManager {

    //Maybe Excepton static field
    public static List<Human> getHumanListOne() {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human(1, "Ivan", 19));
        humanList.add(new Human(2, "Dima", 20));

        return humanList;
    }

    public static List<Human> getHumanListTwo() {
        List<Human> newHumans = new ArrayList<>();
        //change
        newHumans.add(new Human(19, "Ivan", 19));
        newHumans.add(new Human(2, "Dima", 20));
        newHumans.add(new Human(3, "Petr", 21));

        return newHumans;
    }

    public static List<Human> getHumanListThree() {
        List<Human> newHumans = new ArrayList<>();

        //change
        newHumans.add(new Human(1, "Ivan", 19));
        newHumans.add(new Human(2, "Dima", 20));
        //change
        newHumans.add(new Human(3, "Petro", 21));
        newHumans.add(new Human(4, "Alex", 22));
        //delete one

        return newHumans;
    }
}
