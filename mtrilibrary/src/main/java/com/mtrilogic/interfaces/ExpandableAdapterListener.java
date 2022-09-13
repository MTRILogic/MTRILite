package com.mtrilogic.interfaces;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.ExpandableChild;
import com.mtrilogic.abstracts.ExpandableGroup;
import com.mtrilogic.abstracts.Model;
import com.mtrilogic.classes.Mappable;

@SuppressWarnings("unused")
public interface ExpandableAdapterListener extends AdapterListener, OnMakeToastListener {
    ExpandableGroup<? extends Model> getExpandableGroup(int viewType, LayoutInflater inflater, ViewGroup parent);

    ExpandableChild<? extends Model> getExpandableChild(int viewType, LayoutInflater inflater, ViewGroup parent);

    Mappable<Model> getModelMappable();
}
