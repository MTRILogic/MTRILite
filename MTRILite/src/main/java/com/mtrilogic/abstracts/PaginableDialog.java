package com.mtrilogic.abstracts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtrilogic.adapters.PaginableAdapter;
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

    public PaginableDialog(@NonNull Context context, @NonNull Listable<Page> pageListable, @NonNull OnTaskCompleteListener<M> listener) {
        super(context, listener);
        this.pageListable = pageListable;
    }

    protected PaginableDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener, @NonNull Listable<Page> pageListable, @NonNull OnTaskCompleteListener<M> listener) {
        super(context, cancelable, cancelListener, listener);
        this.pageListable = pageListable;
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @NonNull
    @Override
    public final Listable<Page> getPageListable() {
        return pageListable;
    }

    @NonNull
    @Override
    public final PaginableAdapter getPaginableAdapter() {
        return adapter;
    }

    @NonNull
    @Override
    public final ViewPager getViewPager() {
        return pager;
    }

    @NonNull
    @Override
    public Paginable<? extends Page> getPaginable(int viewType, @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new DefaultPaginable(inflater, parent, this);
    }

    @Override
    public boolean onPaginableLongClick(@NonNull View itemView, @NonNull Page page, int position) {
        return false;
    }

    @Override
    public void onPaginableClick(@NonNull View itemView, @NonNull Page page, int position) {

    }

     /*==============================================================================================
    PROTECTED METHOD
    ==============================================================================================*/

    /**
     * Inicializa el ViewPager y el PaginableAdapter
     * ATENCIÓN!!!: Este método debe llamarse dentro de onCreateView
     * @param pager el ViewPager.
     */
    protected final void initViewPagerAdapter(@NonNull ViewPager pager){
        adapter = new PaginableAdapter(getLayoutInflater(), this);
        pager.setAdapter(adapter);
        this.pager = pager;
    }
}
