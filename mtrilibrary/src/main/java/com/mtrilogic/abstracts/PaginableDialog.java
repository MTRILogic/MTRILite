package com.mtrilogic.abstracts;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtrilogic.adapters.PaginableAdapter;
import com.mtrilogic.classes.Base;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.interfaces.OnTaskCompleteListener;
import com.mtrilogic.interfaces.PaginableAdapterListener;
import com.mtrilogic.interfaces.PaginableItemListener;
import com.mtrilogic.items.DefaultPaginable;

@SuppressWarnings("unused")
public abstract class PaginableDialog<M extends Model> extends BaseDialog<M> implements PaginableAdapterListener, PaginableItemListener {
    protected final Listable<Page> pageListable;
    protected PaginableAdapter adapter;
    protected ViewPager pager;

    /*==============================================================================================
    PUBLIC CONSTRUCTORS
    ==============================================================================================*/

    public PaginableDialog(Context context, Listable<Page> pageListable, OnTaskCompleteListener<M> listener) {
        super(context, listener);
        this.pageListable = pageListable;
    }

    protected PaginableDialog(Context context, boolean cancelable, OnCancelListener cancelListener, Listable<Page> pageListable, OnTaskCompleteListener<M> listener) {
        super(context, cancelable, cancelListener, listener);
        this.pageListable = pageListable;
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
            Base.makeLog("PaginableDialog: PaginableAdapter is null");
        }
        return adapter;
    }

    @Override
    public final ViewPager getViewPager() {
        if (pager == null){
            Base.makeLog("PaginableDialog: ViewPager is null");
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
