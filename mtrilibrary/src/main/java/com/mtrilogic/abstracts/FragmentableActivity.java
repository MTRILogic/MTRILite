package com.mtrilogic.abstracts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.mtrilogic.adapters.FragmentableAdapter;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.fragments.DefaultBaseFragment;
import com.mtrilogic.interfaces.FragmentableAdapterListener;
import com.mtrilogic.interfaces.FragmentableItemListener;

@SuppressWarnings("unused")
public abstract class FragmentableActivity extends BaseActivity implements FragmentableAdapterListener, FragmentableItemListener {
    protected Listable<Page> pageListable;
    protected FragmentableAdapter adapter;
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
    public final FragmentableAdapter getFragmentableAdapter() {
        return adapter;
    }

    @Override
    public final ViewPager getViewPager() {
        return pager;
    }

    @Override
    public Fragment getFragment(Page page, int position) {
        return BaseFragment.getInstance(new DefaultBaseFragment(), page, position);
    }

    @Override
    public void onPositionChanged(int position) {

    }

    /*==============================================================================================
    PROTECTED METHOD
    ==============================================================================================*/

    /**
     * Inicializa el ViewPager y el PaginableAdapter
     * ATENCIÓN!!!: Este método debe llamarse dentro de onCreateView
     * @param pager el ViewPager.
     */
    public final void initViewPagerAdapter(ViewPager pager){
        adapter = new FragmentableAdapter(getSupportFragmentManager(), this);
        pager.setAdapter(adapter);
        this.pager = pager;
    }
}
