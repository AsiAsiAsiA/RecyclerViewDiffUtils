package com.example.semen.recyclerviewdiffutils;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.semen.recyclerviewdiffutils.adapter.HumanAdapter;
import com.example.semen.recyclerviewdiffutils.adapter.HumanListItemDecorator;
import com.example.semen.recyclerviewdiffutils.model.Human;
import com.example.semen.recyclerviewdiffutils.model.HumanManager;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HumanListFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView tvTitle;
    private HumanAdapter humanAdapter;
    private List<Human> newHumans;
    private Button btnGo;
    private Button btnBack;

    public static Fragment newInstance() {
        return new HumanListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_human_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newHumans = HumanManager.getHumanListOne();
        btnGo = view.findViewById(R.id.btnGoToCanvas);
        btnBack = view.findViewById(R.id.btnBack);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setTextColor(Color.GREEN);

        intiRecyclerView(view);

        //TODO: Crash if delete Elements
        btnGo.setOnClickListener((v) -> humanAdapter.setHumans(HumanManager.getHumanListTwo()));
        btnBack.setOnClickListener((v) -> humanAdapter.setHumans(HumanManager.getHumanListThree()));
    }

    private void intiRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        humanAdapter = new HumanAdapter(newHumans);
        recyclerView.setAdapter(humanAdapter);

        recyclerView.addItemDecoration(new HumanListItemDecorator(30));
    }
}
