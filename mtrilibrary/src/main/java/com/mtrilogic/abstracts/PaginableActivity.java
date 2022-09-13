package com.mtrilogic.abstracts;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtrilogic.adapters.PaginableAdapter;
import com.mtrilogic.classes.Base;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.interfaces.PaginableAdapterListener;
import com.mtrilogic.interfaces.PaginableItemListener;
import com.mtrilogic.items.DefaultPaginable;

@SuppressWarnings("unused")
public abstract class PaginableActivity extends BaseActivity implements PaginableAdapterListener, PaginableItemListener {
    protected Listable<Page> pageListable;
    protected PaginableAdapter adapter;
    protected ViewPager pager;

    /*==============================================================================================
    PROTECTED OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            pageListable = new Listable<>(savedInstanceState);
        }else {
            pageListable = new Listable<>();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        pageListable.saveToData(outState);
        super.onSaveInstanceState(outState);
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public final Listable<Page> getPageListable() {
        return pageListable;
    }

    @Override
    public final PaginableAdapter getPaginableAdapter() {
        if (adapter == null){
            Base.makeLog("PaginableActivity: PaginableAdapter is null");
        }
        return adapter;
    }

    @Override
    public final ViewPager getViewPager() {
        if (pager == null){
            Base.makeLog("PaginableActivity: ViewPager is null");
        }
        return pager;
    }

    @Override
    public Paginable<? extends Page> getPaginable(int viewType, LayoutInflater inflater, ViewGroup parent) {
        return new DefaultPaginable(inflater, parent, this);
    }

    @Override
    public boolean onPaginableLongClick(View itemView, Page page, int position) {
        return false;
    }

    @Override
    public void onPaginableClick(View itemView, Page page, int position) {

    }

    /*==============================================================================================
    PROTECTED METHOD
    ==============================================================================================*/

    /**
     * Inicializa el ViewPager y el PaginableAdapter
     * ATENCIÓN!!!: Este método debe llamarse dentro de onCreateView
     * @param pager el ViewPager.
     */
    protected final void initViewPagerAdapter(ViewPager pager){
        adapter = new PaginableAdapter(getLayoutInflater(), this);
        pager.setAdapter(adapter);
        this.pager = pager;
    }
}
