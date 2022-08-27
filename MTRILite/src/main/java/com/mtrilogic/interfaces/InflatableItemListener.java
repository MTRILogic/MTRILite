package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.widget.ListView;

import com.mtrilogic.abstracts.Modelable;
import com.mtrilogic.adapters.InflatableAdapter;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface InflatableItemListener extends InflatableListener, ItemListener {
    @NonNull
    Listable<Modelable> getModelableListable();

    @NonNull
    InflatableAdapter getInflatableAdapter();

    @NonNull
    ListView getListView();
}
