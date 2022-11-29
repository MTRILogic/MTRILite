package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;

import com.mtrilogic.abstracts.Page;

@SuppressWarnings("unused")
public interface Fragmentable extends OnMakeToastListener {
    void setPosition(int position);

    int getPosition();

    @NonNull
    Page getPage();
}
