package com.example.semen.recyclerviewdiffutils;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.example.semen.recyclerviewdiffutils.adapter.HumanAdapter;
import com.example.semen.recyclerviewdiffutils.adapter.HumanListItemDecorator;
import com.example.semen.recyclerviewdiffutils.model.Human;
import com.example.semen.recyclerviewdiffutils.model.HumanManager;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HumanListFragment extends Fragment {
    private HumanAdapter humanAdapter;
    private List<Human> humans;
    private SearchView searchView;
    private SearchView.OnQueryTextListener queryTextListener;

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
        setHasOptionsMenu(true);

        humans = HumanManager.getHumanListOne();
        Button btnGo = view.findViewById(R.id.btnGoToCanvas);
        Button btnBack = view.findViewById(R.id.btnBack);

        intiRecyclerView(view);

        btnGo.setOnClickListener((v) -> humanAdapter.setHumans(HumanManager.getHumanListTwo()));
        btnBack.setOnClickListener((v) -> humanAdapter.setHumans(HumanManager.getHumanListThree()));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.menuSearch);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //реагирует на отправление текста
            @Override
            public boolean onQueryTextSubmit(String newText) {
                Log.i("onQueryTextSubmit", newText);
                return true;
            }

            //реагирует на изменение текста(на каждую букву)
            @Override
            public boolean onQueryTextChange(String query) {
                Log.i("onQueryTextChange", query);
                String userInput = query.toLowerCase();
                List<Human> newList = new ArrayList<>();

                for (Human human : humans) {
                    if (human.getName().toLowerCase().contains(userInput)) {
                        newList.add(human);
                    }
                }

                humanAdapter.setHumans(newList);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSearch:
                // Not implemented here
                return false;
            default:
                break;
        }
        searchView.setOnQueryTextListener(queryTextListener);
        return super.onOptionsItemSelected(item);
    }

    private void intiRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        humanAdapter = new HumanAdapter(humans);
        recyclerView.setAdapter(humanAdapter);

        recyclerView.addItemDecoration(new HumanListItemDecorator(30));
    }
}
