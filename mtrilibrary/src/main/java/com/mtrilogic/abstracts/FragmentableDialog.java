package com.mtrilogic.abstracts;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.mtrilogic.adapters.FragmentableAdapter;
import com.mtrilogic.classes.Base;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.fragments.DefaultBaseFragment;
import com.mtrilogic.interfaces.FragmentableAdapterListener;
import com.mtrilogic.interfaces.FragmentableItemListener;
import com.mtrilogic.interfaces.OnTaskCompleteListener;

@SuppressWarnings("unused")
public abstract class FragmentableDialog<M extends Model> extends BaseDialog<M> implements FragmentableAdapterListener, FragmentableItemListener {
    protected final Listable<Page> pageListable;
    protected FragmentableAdapter adapter;
    protected ViewPager pager;
    protected String tagName;

    /*==============================================================================================
    PUBLIC CONSTRUCTORS
    ==============================================================================================*/

    public FragmentableDialog(Context context, Listable<Page> pageListable, OnTaskCompleteListener<M> listener) {
        super(context, listener);
        this.pageListable = pageListable;
    }

    protected FragmentableDialog(Context context, boolean cancelable, OnCancelListener cancelListener, Listable<Page> pageListable, OnTaskCompleteListener<M> listener) {
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
    public final FragmentableAdapter getFragmentableAdapter() {
        if (adapter == null){
            Base.makeLog("FragmentableDialog: FragmentableAdapter is null");
        }
        return adapter;
    }

    @Override
    public final ViewPager getViewPager() {
        if (pager == null){
            Base.makeLog("FragmentableDialog: ViewPager is null");
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
        if (oldTag.equals(tagName)){
            tagName = newTag;
        }
    }

    /*==============================================================================================
    PROTECTED METHOD
    ==============================================================================================*/

    /**
     * Inicializa el ViewPager y el PaginableAdapter
     * ATENCIÓN!!!: Este método debe llamarse dentro de onCreateView
     * @param manager el fragment manager.
     * @param pager el ViewPager.
     */
    protected final void initViewPagerAdapter(FragmentManager manager, ViewPager pager){
        adapter = new FragmentableAdapter(manager, this);
        pager.setAdapter(adapter);
        this.pager = pager;
    }
}
