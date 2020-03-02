package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.Recyclable;

@SuppressWarnings("unused")
public interface RecyclableListener extends OnMakeToastListener{

    // ================< PUBLIC ABSTRACT METHODS >==================================================

    @NonNull Recyclable getRecyclable(int viewType, @NonNull LayoutInflater inflater, @NonNull ViewGroup parent);
}
