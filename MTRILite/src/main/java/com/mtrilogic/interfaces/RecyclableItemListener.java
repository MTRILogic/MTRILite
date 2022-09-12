package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.RecyclableAdapter;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface RecyclableItemListener extends ItemListener, RecyclableListener{
    @NonNull
    Listable<Model> getModelListable();

    @NonNull
    RecyclableAdapter getRecyclableAdapter();

    @NonNull
    RecyclerView getRecyclerView();
}
