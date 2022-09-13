package com.mtrilogic.abstracts;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.mtrilogic.adapters.FragmentableAdapter;
import com.mtrilogic.classes.Base;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.fragments.DefaultBaseFragment;
import com.mtrilogic.interfaces.FragmentableAdapterListener;
import com.mtrilogic.interfaces.FragmentableItemListener;

@SuppressWarnings("unused")
public abstract class FragmentableDialogFragment<P extends ListablePage<Page>> extends BaseDialogFragment<P> implements FragmentableAdapterListener, FragmentableItemListener {
    protected FragmentableAdapter adapter;
    protected ViewPager pager;

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public final Listable<Page> getPageListable() {
        if (page == null){
            Base.makeLog("FragmentableDialogFragment: Page is null");
        }
        return page.getListable();
    }

    @Override
    public final FragmentableAdapter getFragmentableAdapter() {
        if (adapter == null){
            Base.makeLog("FragmentableDialogFragment: Adapter is null");
        }
        return adapter;
    }

    @Override
    public final ViewPager getViewPager() {
        if (pager == null){
            Base.makeLog("FragmentableDialogFragment: ViewPager is null");
        }
        return pager;
    }

    @Override
    public Fragment getFragment(Page page, int position) {
        return BaseFragment.getInstance(new DefaultBaseFragment(), page, position);
    }

    @Override
    public void onPositionChanged(int position) {
        Base.makeLog("FragmentableDialog: Position = " + position);
    }

    @Override
    public void onNewTagName(String oldTag, String newTag) {
        if (oldTag.equals(page.getTagName())){
            page.setTagName(newTag);
        }
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
        adapter = new FragmentableAdapter(getChildFragmentManager(), this);
        pager.setAdapter(adapter);
        this.pager = pager;
    }
}
