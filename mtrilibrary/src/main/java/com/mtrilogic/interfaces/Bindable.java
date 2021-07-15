package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;

import com.mtrilogic.abstracts.Modelable;

public interface Bindable<M extends Modelable> {
    @NonNull M getModelFromModelable(@NonNull Modelable modelable);
    void onBindItemView();
    void onBindModel();
}
