package com.mtrilogic.interfaces;

import android.support.v4.app.Fragment;

import com.mtrilogic.abstracts.Page;
import com.mtrilogic.classes.Listable;

@SuppressWarnings({"unused", "EmptyMethod"})
public interface FragmentableAdapterListener extends AdapterListener, OnMakeToastListener{
    Fragment getFragment(Page page, int position);

    Listable<Page> getPageListable();

    void onPositionChanged(int position);
}
