package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.Inflatable;

@SuppressWarnings("unused")
public interface InflatableListener extends OnMakeToastListener{

    // ================< PUBLIC ABSTRACT METHODS >==================================================

    @NonNull Inflatable getInflatable(int viewType, @NonNull LayoutInflater inflater, @NonNull ViewGroup parent);
}
