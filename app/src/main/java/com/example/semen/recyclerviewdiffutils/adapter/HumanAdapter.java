package com.example.semen.recyclerviewdiffutils.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.semen.recyclerviewdiffutils.R;
import com.example.semen.recyclerviewdiffutils.model.Human;

import java.util.List;

public class HumanAdapter extends RecyclerView.Adapter<HumanAdapter.HumanViewHolder> {
    private final List<Human> humans;

    public HumanAdapter(List<Human> humans) {
        this.humans = humans;
    }

    //Устанавлиет новый список и обновляет RecyclerView
    public void setHumans(List<Human> humans) {
//        this.humans.clear();
//        this.humans.addAll(contacts);
//        notifyDataSetChanged();
        final HumanListDiffUtilCallback diffUtilCallback = new HumanListDiffUtilCallback(this.humans,humans);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);
        diffResult.dispatchUpdatesTo(this);


        this.humans.clear();
        this.humans.addAll(humans);

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

//    @Override
//    public void onBindViewHolder(@NonNull HumanViewHolder holder, int position, @NonNull List<Object> payloads) {
//        if (payloads.isEmpty()) {
//            super.onBindViewHolder(holder, position, payloads);
//        } else {
//            Bundle o = (Bundle) payloads.get(0);
//            for (String key : o.keySet()) {
//                if (key.equals("name") || key.equals("age")) {
//                    holder.id.setText(String.valueOf(humans.get(position).getId()));
//                    holder.id.setTextColor(Color.GREEN);
//                    holder.name.setText(humans.get(position).getName());
//                    holder.age.setText(String.valueOf(humans.get(position).getAge()));
//                }
//            }
//        }
//    }

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
