package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.widget.AbsListView;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.InflatableAdapter;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface InflatableItemListener extends ItemListener, InflatableListener{
    @NonNull
    Listable<Model> getModelListable();

    @NonNull
    InflatableAdapter getInflatableAdapter();

    @NonNull
    AbsListView getListView();
}
