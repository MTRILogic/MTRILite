package com.mtrilogic.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.Modelable;
import com.mtrilogic.abstracts.Recyclable;
import com.mtrilogic.classes.Base;
import com.mtrilogic.interfaces.RecyclableListener;

import java.util.ArrayList;

@SuppressWarnings({"unused"})
public class RecyclableAdapter extends RecyclerView.Adapter<Recyclable>{

    private LayoutInflater inflater;
    private RecyclableListener listener;
    private ArrayList<Modelable> modelableList;

    // ================< PUBLIC CONSTRUCTORS >======================================================

    public RecyclableAdapter(@NonNull Context context, @NonNull RecyclableListener listener,
                             @NonNull ArrayList<Modelable> modelableList){
        inflater = LayoutInflater.from(context);
        this.modelableList = modelableList;
        this.listener = listener;
        setHasStableIds(true);
    }

    // ================< PUBLIC METHODS >===========================================================

    public final int getModelablePosition(@NonNull Modelable modelable){
        return modelableList.indexOf(modelable);
    }

    public final Modelable[] getModelableArray(){
        return modelableList.toArray(new Modelable[getItemCount()]);
    }

    public final ArrayList<Modelable> getModelableList(){
        return modelableList;
    }

    public final void setModelableList(@NonNull ArrayList<Modelable> modelableList){
        this.modelableList = modelableList;
    }

    public final boolean addModelableList(@NonNull ArrayList<Modelable> modelableList){
        return this.modelableList.addAll(modelableList);
    }

    public final boolean insertModelableList(int position, @NonNull ArrayList<Modelable> modelableList){
        return isValidPosition(position) && this.modelableList.addAll(position, modelableList);
    }

    public final boolean removeModelableList(@NonNull ArrayList<Modelable> modelableList){
        return this.modelableList.removeAll(modelableList);
    }

    public final boolean retainModelableList(@NonNull ArrayList<Modelable> modelableList){
        return this.modelableList.retainAll(modelableList);
    }

    public final Modelable getModelable(int position){
        return isValidPosition(position) ? getItem(position) : null;
    }

    public final Modelable setModelable(int position, @NonNull Modelable modelable){
        return isValidPosition(position) ? modelableList.set(position,modelable) : null;
    }

    public final boolean addModelable(@NonNull Modelable modelable){
        return modelableList.add(modelable);
    }

    public final void insertModelable(int position, @NonNull Modelable modelable){
        if(isValidPosition(position)){
            modelableList.add(position, modelable);
        }
    }

    public final boolean removeModelable(@NonNull Modelable modelable){
        return modelableList.remove(modelable);
    }

    public final void clearModelableList(){
        modelableList.clear();
    }

    // ================< PUBLIC OVERRIDE METHODS >==================================================

    @NonNull
    @Override
    public Recyclable onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return listener.getRecyclable(viewType, inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclable holder, int position){
        Modelable modelable = getItem(position);
        holder.bindModel(modelable, position);
    }

    @Override
    public int getItemCount(){
        return modelableList.size();
    }

    @Override
    public int getItemViewType(int position){
        return getItem(position).getViewType();
    }

    @Override
    public long getItemId(int position){
        return getItem(position).getItemId();
    }

    // ================< PRIVATE METHODS >==========================================================

    private boolean isValidPosition(int position){
        return position > Base.INVALID_POSITION && position < getItemCount();
    }

    @NonNull
    private Modelable getItem(int position){
        return modelableList.get(position);
    }
}
