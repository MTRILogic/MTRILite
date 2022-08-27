package com.mtrilogic.abstracts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mtrilogic.interfaces.Bindable;
import com.mtrilogic.interfaces.RecyclableItemListener;

@SuppressWarnings({"unused"})
public abstract class Recyclable<M extends Modelable> extends RecyclerView.ViewHolder implements Bindable<M>, View.OnLongClickListener, View.OnClickListener {
    protected final RecyclableItemListener listener;

    protected int position;
    protected M model;

    /*==============================================================================================
    PUBLIC CONSTRUCTOR
    ==============================================================================================*/

    public Recyclable(@NonNull View itemView, @NonNull RecyclableItemListener listener){
        super(itemView);
        this.listener = listener;
    }

    /*==============================================================================================
    PUBLIC METHODS
    ==============================================================================================*/

    public final void bindItemView(){
        itemView.setOnLongClickListener(this);
        itemView.setOnClickListener(this);
        onBindItemView();
    }

    public final void bindModel(@NonNull Modelable modelable, int position){
        model = getModelFromModelable(modelable);
        this.position = position;
        if (model != null) {
            onBindModel();
        }
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public void onClick(View v) {
        listener.onItemClick(itemView, model, position);
    }

    @Override
    public boolean onLongClick(View v) {
        return listener.onItemLongClick(itemView, model, position);
    }

    /*==============================================================================================
    PROTECTED METHODS
    ==============================================================================================*/

    protected boolean autoDelete(){
        return listener.getModelableListable().delete(model);
    }

    protected void notifyChanged(int position){
        listener.getRecyclableAdapter().notifyItemChanged(position);
    }

    protected void notifyDelete(int position){
        listener.getRecyclableAdapter().notifyItemRemoved(position);
    }

    protected void notifyInsert(int position){
        listener.getRecyclableAdapter().notifyItemInserted(position);
    }

    protected void makeToast(String line){
        listener.onMakeToast(line);
    }
}
