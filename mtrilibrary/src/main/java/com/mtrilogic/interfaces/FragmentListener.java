package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;

import com.mtrilogic.abstracts.Paginable;
import com.mtrilogic.adapters.FragmentableAdapter;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface FragmentListener extends OnMakeToastListener{
    @NonNull Listable<Paginable> getPaginableListable();
    @NonNull FragmentableAdapter getFragmentableAdapter();
    @NonNull ViewPager getViewPager();
}
