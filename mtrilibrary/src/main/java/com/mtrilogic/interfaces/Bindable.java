package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;

import com.mtrilogic.abstracts.Modelable;

@SuppressWarnings("unused")
public interface Bindable<M extends Modelable> {
    M getModelFromModelable(@NonNull Modelable modelable);

    void onBindItemView();

    void onBindModel();
}
