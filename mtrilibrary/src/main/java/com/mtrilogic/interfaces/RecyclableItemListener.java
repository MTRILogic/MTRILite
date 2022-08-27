package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.mtrilogic.abstracts.Modelable;
import com.mtrilogic.adapters.RecyclableAdapter;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface RecyclableItemListener extends RecyclableListener, ItemListener{
    @NonNull
    Listable<Modelable> getModelableListable();

    @NonNull
    RecyclableAdapter getRecyclableAdapter();

    @NonNull
    RecyclerView getRecyclerView();
}
