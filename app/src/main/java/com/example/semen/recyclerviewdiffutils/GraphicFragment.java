package com.example.semen.recyclerviewdiffutils;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GraphicFragment extends Fragment {
    ImageView imageView;

    public static Fragment newInstance() {
        return new GraphicFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return new DrawView(getActivity());
    }
}
