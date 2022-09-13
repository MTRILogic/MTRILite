package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;

@SuppressWarnings("unused")
public interface OnIterationListener<M extends Model> {
    void onIteration(M item);
}
