package com.mtrilogic.interfaces;

import android.widget.ListView;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.InflatableAdapter;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface InflatableItemListener extends ItemListener, InflatableListener{
    Listable<Model> getModelListable();

    InflatableAdapter getInflatableAdapter();

    ListView getListView();
}
