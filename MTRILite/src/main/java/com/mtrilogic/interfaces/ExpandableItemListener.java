package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.widget.ExpandableListView;

import com.mtrilogic.abstracts.Modelable;
import com.mtrilogic.adapters.ExpandableAdapter;
import com.mtrilogic.classes.Mapable;

@SuppressWarnings("unused")
public interface ExpandableItemListener extends ExpandableListener, ItemListener{
    @NonNull
    Mapable<Modelable> getModelableMapable();

    @NonNull
    ExpandableAdapter getExpandableAdapter();

    @NonNull
    ExpandableListView getExpandableListView();
}