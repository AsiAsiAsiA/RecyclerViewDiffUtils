package com.example.semen.recyclerviewdiffutils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HumanAdapter extends RecyclerView.Adapter<HumanAdapter.HumanViewHolder> {
    private final List<Human> humans;

    public HumanAdapter(List<Human> humans) {
        this.humans = humans;
    }

    //Устанавлиет новый список и обновляет RecyclerView
    public void setHumans(List<Human> contacts) {
        this.humans.clear();
        this.humans.addAll(contacts);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HumanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.human_adapter_item, viewGroup, false);
        return new HumanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HumanViewHolder humanViewHolder, final int position) {
        humanViewHolder.bind(humans.get(position));
    }

    @Override
    public int getItemCount() {
        return humans.size();
    }

    class HumanViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final TextView id;
        final TextView age;
        final Context context;

        HumanViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            id = itemView.findViewById(R.id.id);
            age = itemView.findViewById(R.id.age);
            context = name.getContext();
            itemView.setTag(itemView);
        }

        void bind(final Human human) {
            name.setText(human.getName());
            id.setText("ID: " + String.valueOf(human.getId()));
            age.setText("Age: " + String.valueOf(human.getAge()));
        }
    }
}
