package com.example.semen.recyclerviewdiffutils;

import java.util.ArrayList;
import java.util.List;

public class HumanManager {
    public static List<Human> humanList;

    static {
        humanList = new ArrayList<>();
        humanList.add(new Human(1, "Ivan", 19));
        humanList.add(new Human(2, "Dima", 20));
        humanList.add(new Human(3, "Petr", 21));
        humanList.add(new Human(4, "Alex", 22));
        humanList.add(new Human(5, "John", 23));
        humanList.add(new Human(6, "Raj", 24));
        humanList.add(new Human(7, "Leonard", 25));
        humanList.add(new Human(8, "Sheldon", 26));
        humanList.add(new Human(9, "Penny", 27));
        humanList.add(new Human(10, "Amy", 28));
        humanList.add(new Human(11, "Howard", 29));
        humanList.add(new Human(11, "Kostya", 30));
        humanList.add(new Human(11, "Nikolay", 31));
        humanList.add(new Human(11, "Kobe", 32));
        humanList.add(new Human(11, "LeBron", 33));
        humanList.add(new Human(11, "Lionel", 34));
        humanList.add(new Human(11, "Cristiano", 35));
        humanList.add(new Human(11, "Luka", 36));
    }

    //Maybe Excepton static field
    public static List<Human> getHumanList() {
        return humanList;
    }
}
