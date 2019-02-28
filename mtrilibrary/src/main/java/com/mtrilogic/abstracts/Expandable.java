package com.mtrilogic.abstracts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mtrilogic.interfaces.Bindable;
import com.mtrilogic.interfaces.ExpandableAdapterListener;

public abstract class Expandable implements Bindable{
    private boolean expanded, lastChild;
    private ExpandableAdapterListener listener;
    private Context context;

    public abstract View getExpandableView(ViewGroup parent);

    protected Expandable(Context context, ExpandableAdapterListener listener){
        this.context = context;
        this.listener = listener;
    }

    public void setExpanded(boolean expanded){
        this.expanded = expanded;
    }

    public void setLastChild(boolean lastChild){
        this.lastChild = lastChild;
    }

    @SuppressWarnings("unused")
    protected boolean isExpanded(){
        return expanded;
    }

    @SuppressWarnings("unused")
    protected boolean isLastChild(){
        return lastChild;
    }

    @SuppressWarnings("unused")
    protected ExpandableAdapterListener getListener(){
        return listener;
    }

    @SuppressWarnings("unused")
    protected Context getContext(){
        return context;
    }
}