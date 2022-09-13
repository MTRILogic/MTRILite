package com.mtrilogic.interfaces;

import android.support.v7.widget.RecyclerView;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.RecyclableAdapter;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface RecyclableItemListener extends ItemListener, RecyclableListener{
    Listable<Model> getModelListable();

    RecyclableAdapter getRecyclableAdapter();

    RecyclerView getRecyclerView();
}
