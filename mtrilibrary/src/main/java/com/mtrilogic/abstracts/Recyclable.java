package com.mtrilogic.abstracts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.interfaces.RecyclableAdapterListener;

@SuppressWarnings("unused")
public abstract class Recyclable extends RecyclerView.ViewHolder{
    protected final RecyclableAdapterListener listener;

// ++++++++++++++++| PUBLIC ABSTRACT METHODS |++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public abstract void onBindHolder(Modelable modelable, int position);

// ++++++++++++++++| PUBLIC CONSTRUCTORS |++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public Recyclable(Context context, int resource, ViewGroup parent,
                      RecyclableAdapterListener listener){
        super(LayoutInflater.from(context).inflate(resource, parent, false));
        this.listener = listener;
    }

// ++++++++++++++++| PROTECTED METHODS |++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    protected Context getContext(){
        return itemView.getContext();
    }
}
