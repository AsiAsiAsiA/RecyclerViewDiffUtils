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
    private List<Human> humans;

    public HumanAdapter(List<Human> humans) {
        this.humans = humans;
    }

    //Устанавлиет новый список и обновляет RecyclerView
    public void setHumans(List<Human> humans) {
        final HumanListDiffUtilCallback diffUtilCallback = new HumanListDiffUtilCallback(humans, this.humans);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);
        diffResult.dispatchUpdatesTo(this);
        this.humans = humans;
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

            id.setText(context.getString(R.string.view_holder_text,
                    context.getString(R.string.id),
                    String.valueOf(human.getId())));

            age.setText(context.getString(R.string.view_holder_text,
                    context.getString(R.string.age),
                    String.valueOf(human.getAge())));
        }
    }
}
