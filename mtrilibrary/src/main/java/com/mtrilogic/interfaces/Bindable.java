package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Modelable;

@SuppressWarnings("unused")
public interface Bindable{
    void onBindHolder(Modelable modelable);
    int getLayoutResource();
}
