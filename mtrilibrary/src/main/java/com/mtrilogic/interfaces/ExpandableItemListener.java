package com.mtrilogic.interfaces;

import android.widget.ExpandableListView;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ExpandableAdapter;
import com.mtrilogic.classes.Mappable;

@SuppressWarnings("unused")
public interface ExpandableItemListener extends ItemListener, ExpandableListener{
    Mappable<Model> getModelMappable();

    ExpandableAdapter getExpandableAdapter();

    ExpandableListView getExpandableListView();
}
