package com.example.semen.recyclerviewdiffutils.adapter;

import android.support.v7.util.DiffUtil;

import com.example.semen.recyclerviewdiffutils.model.Human;

import java.util.List;

class HumanListDiffUtilCallback extends DiffUtil.Callback {
    private final List<Human> newList;
    private final List<Human> oldList;

    HumanListDiffUtilCallback(List<Human> newList, List<Human> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).getId() == oldList.get(oldItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final Human newHuman = newList.get(newItemPosition);
        final Human oldHuman = oldList.get(oldItemPosition);

        return newHuman.equals(oldHuman);
    }
}
