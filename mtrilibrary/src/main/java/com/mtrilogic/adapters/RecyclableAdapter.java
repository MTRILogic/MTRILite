package com.mtrilogic.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.Modelable;
import com.mtrilogic.abstracts.Recyclable;
import com.mtrilogic.interfaces.RecyclableAdapterListener;

import java.util.ArrayList;

@SuppressWarnings({"unused"})
public final class RecyclableAdapter extends RecyclerView.Adapter<Recyclable<? extends Modelable>>{
    private final RecyclableAdapterListener listener;
    private final LayoutInflater inflater;

// ++++++++++++++++| PUBLIC CONSTRUCTORS |++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public RecyclableAdapter(@NonNull LayoutInflater inflater, @NonNull RecyclableAdapterListener listener){
        this.inflater = inflater;
        this.listener = listener;
        setHasStableIds(true);
    }

// ++++++++++++++++| PUBLIC OVERRIDE METHODS |++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @NonNull
    @Override
    public Recyclable<? extends Modelable> onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        Recyclable<? extends Modelable> recyclable = listener.getRecyclable(viewType, inflater, parent);
        recyclable.onBindItemView();
        return recyclable;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclable holder, int position){
        Modelable modelable = getModelable(position);
        holder.bindModel(modelable, position);
    }

    @Override
    public int getItemCount(){
        return getModelableList().size();
    }

    @Override
    public int getItemViewType(int position){
        return getModelable(position).getViewType();
    }

    @Override
    public long getItemId(int position){
        return getModelable(position).getItemId();
    }

    /*==============================================================================================
    PRIVATE METHODS
    ==============================================================================================*/

    private ArrayList<Modelable> getModelableList(){
        return listener.getModelableListable().getList();
    }

    private Modelable getModelable(int position){
        return getModelableList().get(position);
    }
}
