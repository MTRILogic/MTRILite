package com.mtrilogic.abstracts;

import android.view.View;

import com.mtrilogic.interfaces.ExpandableItemListener;
import com.mtrilogic.interfaces.ModelBindable;

@SuppressWarnings("unused")
public abstract class Expandable<M extends Model> implements ModelBindable {
    protected final ExpandableItemListener listener;
    protected final View itemView;

    private final Class<M> clazz;

    protected int groupPosition;
    protected M model;

    /*==============================================================================================
    PROTECTED CONSTRUCTOR
    ==============================================================================================*/

    protected Expandable(Class<M> clazz, View itemView, ExpandableItemListener listener){
        this.itemView = itemView;
        this.listener = listener;
        this.clazz = clazz;
    }

    /*==============================================================================================
    PUBLIC METHODS
    ==============================================================================================*/

    public View getItemView(){
        onBindItemView();
        return itemView;
    }

    public void bindModel(Model model, int groupPosition){
        this.model = clazz.cast(model);
        this.groupPosition = groupPosition;
        onBindModel();
    }

    /*==============================================================================================
    PROTECTED METHODS
    ==============================================================================================*/

    protected final void notifyChanged(){
        listener.getExpandableAdapter().notifyDataSetChanged();
    }

    protected final void makeToast(String line){
        listener.onMakeToast(line);
    }
}
