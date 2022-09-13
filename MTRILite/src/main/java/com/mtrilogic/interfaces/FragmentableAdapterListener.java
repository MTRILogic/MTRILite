package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mtrilogic.abstracts.Page;
import com.mtrilogic.classes.Listable;

@SuppressWarnings({"unused", "EmptyMethod"})
public interface FragmentableAdapterListener extends AdapterListener, OnMakeToastListener{
    @NonNull
    Fragment getFragment(@NonNull Page page, int position);

    @NonNull
    Listable<Page> getPageListable();

    void onPositionChanged(int position);
}
