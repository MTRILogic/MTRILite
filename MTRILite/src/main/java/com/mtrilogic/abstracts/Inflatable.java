package com.mtrilogic.abstracts;

import android.support.annotation.NonNull;
import android.view.View;

import com.mtrilogic.interfaces.Bindable;
import com.mtrilogic.interfaces.InflatableItemListener;

@SuppressWarnings("unused")
public abstract class Inflatable<M extends Modelable> implements Bindable<M>, View.OnClickListener, View.OnLongClickListener {
    protected final InflatableItemListener listener;
    protected final View itemView;

    protected int position;
    protected M model;

    /*==============================================================================================
    PUBLIC CONSTRUCTOR
    ==============================================================================================*/

    public Inflatable(@NonNull View itemView, @NonNull InflatableItemListener listener){
        this.itemView = itemView;
        this.listener = listener;
    }

    /*==============================================================================================
    PUBLIC METHODS
    ==============================================================================================*/

    public View getItemView() {
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        onBindItemView();
        return itemView;
    }

    public void bindModelable(@NonNull Modelable modelable, int position){
        model = getModelFromModelable(modelable);
        this.position = position;
        if (model != null){
            onBindModel();
        }
    }

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

    protected void notifyChanged(){
        listener.getInflatableAdapter().notifyDataSetChanged();
    }

    protected void makeToast(String line){
        listener.onMakeToast(line);
    }
}
