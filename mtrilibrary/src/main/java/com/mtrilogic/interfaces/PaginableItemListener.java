package com.mtrilogic.interfaces;

import android.support.v4.view.ViewPager;

import com.mtrilogic.abstracts.Page;
import com.mtrilogic.adapters.PaginableAdapter;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface PaginableItemListener extends ItemListener, PaginableListener{
    Listable<Page> getPageListable();

    PaginableAdapter getPaginableAdapter();

    ViewPager getViewPager();
}
