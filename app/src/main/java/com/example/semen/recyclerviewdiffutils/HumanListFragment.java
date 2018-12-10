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

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.semen.recyclerviewdiffutils.adapter.HumanAdapter;
import com.example.semen.recyclerviewdiffutils.adapter.HumanListItemDecorator;
import com.example.semen.recyclerviewdiffutils.model.Human;
import com.example.semen.recyclerviewdiffutils.model.HumanManager;
import com.example.semen.recyclerviewdiffutils.view.HumanListFragmentView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HumanListFragment extends MvpAppCompatFragment implements HumanListFragmentView {
    private HumanAdapter humanAdapter;
    private List<Human> humans;
    private SearchView searchView;
    private String searchString;

    private static final String SEARCH_KEY = "search_key";

    @InjectPresenter
    HumanListFragmentPresenter presenter;

    public static HumanListFragment newInstance() {
        return new HumanListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_human_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        humans = HumanManager.getHumanListOne();
        Button btnGo = view.findViewById(R.id.btnGoToCanvas);
        Button btnBack = view.findViewById(R.id.btnBack);

        initRecyclerView(view);

        btnGo.setOnClickListener((v) -> humanAdapter.setHumans(HumanManager.getHumanListTwo()));
        btnBack.setOnClickListener((v) -> humanAdapter.setHumans(HumanManager.getHumanListThree()));

        if (savedInstanceState != null) {
            searchString = savedInstanceState.getString(SEARCH_KEY);
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.menuSearch);
        searchView = (SearchView) searchItem.getActionView();

        if (searchString != null) {
            searchView.setIconified(false);
            searchView.setQuery(searchString, true);
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //реагирует на отправление текста
            @Override
            public boolean onQueryTextSubmit(String newText) {
                Log.i("onQueryTextSubmit", newText);
                presenter.search(humans, newText);
                return true;
            }

            //реагирует на изменение текста(на каждую букву)
            @Override
            public boolean onQueryTextChange(String query) {
                Log.i("onQueryTextChange", query);
                presenter.search(humans, query);
                return true;
            }
        });
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        humanAdapter = new HumanAdapter(humans);
        recyclerView.setAdapter(humanAdapter);

        recyclerView.addItemDecoration(new HumanListItemDecorator(30));
    }

    @Override
    public void updateList(List<Human> newList) {
        humanAdapter.setHumans(newList);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SEARCH_KEY, searchView.getQuery().toString());
    }
}
