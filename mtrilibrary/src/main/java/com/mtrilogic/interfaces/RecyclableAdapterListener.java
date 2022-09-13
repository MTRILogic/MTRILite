package com.mtrilogic.interfaces;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.abstracts.Recyclable;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface RecyclableAdapterListener extends AdapterListener, OnMakeToastListener {
    Recyclable<? extends Model> getRecyclable(int viewType, LayoutInflater inflater, ViewGroup parent);

    Listable<Model> getModelListable();
}
