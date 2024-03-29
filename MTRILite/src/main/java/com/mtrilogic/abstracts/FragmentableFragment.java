package com.mtrilogic.abstracts;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.mtrilogic.adapters.FragmentableAdapter;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.fragments.DefaultBaseFragment;
import com.mtrilogic.interfaces.FragmentableAdapterListener;
import com.mtrilogic.interfaces.FragmentableItemListener;

@SuppressWarnings("unused")
public abstract class FragmentableFragment<P extends ListablePage<Page>> extends BaseFragment<P> implements FragmentableAdapterListener, FragmentableItemListener {
    protected FragmentableAdapter adapter;

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @NonNull
    @Override
    public final Listable<Page> getPageListable() {
        return page.getListable();
    }

    @NonNull
    @Override
    public final FragmentableAdapter getFragmentableAdapter() {
        return adapter;
    }

    @NonNull
    @Override
    public Fragment getFragment(@NonNull Page page, int position) {
        return BaseFragment.getInstance(new DefaultBaseFragment(), page, position);
    }

    @Override
    public void onPositionChanged(int position) {

    }

    @Override
    public void onNewTagName(@NonNull String oldTag, @NonNull String newTag) {
        if (oldTag.equals(page.getTagName())){
            page.setTagName(newTag);
        }
    }

    /*==============================================================================================
    PROTECTED METHOD
    ==============================================================================================*/

    /**
     * Inicializa el PaginableAdapter
     * ATENCIÓN!!!: Este método debe llamarse dentro de onCreateView
     * @param pager el ViewPager.
     */
    protected final void initPaginableAdapter(@NonNull ViewPager pager){
        adapter = new FragmentableAdapter(getChildFragmentManager(), this);
        pager.setAdapter(adapter);
    }
}
