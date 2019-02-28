package com.mtrilogic.abstracts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mtrilogic.interfaces.Bindable;
import com.mtrilogic.interfaces.RecyclableAdapterListener;

public abstract class Recyclable extends RecyclerView.ViewHolder implements Bindable{
    private RecyclableAdapterListener listener;
    private Context context;

    public abstract Recyclable getRecyclableHolder(ViewGroup parent);

    protected Recyclable(@NonNull View view, Context context, RecyclableAdapterListener listener){
        super(view);
        this.context = context;
        this.listener = listener;
    }

    @SuppressWarnings("unused")
    protected RecyclableAdapterListener getListener(){
        return listener;
    }

    @SuppressWarnings("unused")
    protected Context getContext(){
        return context;
    }
}