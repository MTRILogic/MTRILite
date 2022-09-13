package com.mtrilogic.interfaces;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.Page;
import com.mtrilogic.abstracts.Paginable;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface PaginableAdapterListener extends AdapterListener, OnMakeToastListener {
    Paginable<? extends Page> getPaginable(int viewType, LayoutInflater inflater, ViewGroup parent);

    Listable<Page> getPageListable();
}
