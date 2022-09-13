package com.mtrilogic.interfaces;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.Inflatable;
import com.mtrilogic.abstracts.Model;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface InflatableAdapterListener extends AdapterListener, OnMakeToastListener {
    Inflatable<? extends Model> getInflatable(int viewType, LayoutInflater inflater, ViewGroup parent);

    Listable<Model> getModelListable();
}
