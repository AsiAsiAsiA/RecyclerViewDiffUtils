package com.example.semen.recyclerviewdiffutils.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.semen.recyclerviewdiffutils.model.Human;

import java.util.List;

public interface HumanListFragmentView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void updateList(List<Human> newList);
}
