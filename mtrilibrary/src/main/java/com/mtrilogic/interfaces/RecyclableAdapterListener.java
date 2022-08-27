package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.Modelable;
import com.mtrilogic.abstracts.Recyclable;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface RecyclableAdapterListener extends OnMakeToastListener{
    @NonNull
    Recyclable<? extends Modelable> getRecyclable(int viewType, @NonNull LayoutInflater inflater, @NonNull ViewGroup parent);

    @NonNull
    Listable<Modelable> getModelableListable();
}