package com.example.semen.recyclerviewdiffutils.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.example.semen.recyclerviewdiffutils.model.Human;

import java.util.List;

public class HumanListDiffUtilCallback extends DiffUtil.Callback {
    List<Human> newList;
    List<Human> oldList;

    public HumanListDiffUtilCallback(List<Human> newList, List<Human> oldList) {
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

        return oldHuman.equals(newHuman);
    }
}
