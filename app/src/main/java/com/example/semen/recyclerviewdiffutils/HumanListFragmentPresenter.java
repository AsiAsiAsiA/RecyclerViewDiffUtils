package com.example.semen.recyclerviewdiffutils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.semen.recyclerviewdiffutils.model.Human;
import com.example.semen.recyclerviewdiffutils.view.HumanListFragmentView;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class HumanListFragmentPresenter extends MvpPresenter<HumanListFragmentView> {
    public void search(List<Human> humans, String query) {
        String userInput = query.toLowerCase();
        //положить строку в bundle

        List<Human> newList = new ArrayList<>();

        for (Human human : humans) {
            if (human.getName().toLowerCase().contains(userInput)) {
                newList.add(human);
            }
        }
        getViewState().updateList(newList);
    }
}
