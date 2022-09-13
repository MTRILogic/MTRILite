package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;

import com.mtrilogic.abstracts.Model;

@SuppressWarnings("unused")
public interface OnIterationListener<M extends Model> {
    void onIteration(@NonNull M item);
}
