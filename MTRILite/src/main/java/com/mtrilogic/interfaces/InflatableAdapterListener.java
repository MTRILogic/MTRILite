package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.Inflatable;
import com.mtrilogic.abstracts.Model;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface InflatableAdapterListener extends AdapterListener, OnMakeToastListener {
    @NonNull
    Inflatable<? extends Model> getInflatable(int viewType, @NonNull LayoutInflater inflater, @NonNull ViewGroup parent);

    @NonNull
    Listable<Model> getModelListable();
}
