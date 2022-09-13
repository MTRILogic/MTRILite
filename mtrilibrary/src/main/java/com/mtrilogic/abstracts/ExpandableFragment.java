package com.mtrilogic.abstracts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.mtrilogic.adapters.ExpandableAdapter;
import com.mtrilogic.classes.Base;
import com.mtrilogic.classes.Mappable;
import com.mtrilogic.interfaces.ExpandableAdapterListener;
import com.mtrilogic.interfaces.ExpandableItemListener;
import com.mtrilogic.items.DefaultExpandableChild;
import com.mtrilogic.items.DefaultExpandableGroup;

@SuppressWarnings("unused")
public abstract class ExpandableFragment<P extends MappablePage<Model>> extends BaseFragment<P> implements ExpandableAdapterListener, ExpandableItemListener {
    protected ExpandableAdapter adapter;
    protected ExpandableListView lvwItems;

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Base.restoreTopIndex(lvwItems, getArguments());
    }

    @Override
    public void onDestroyView() {
        Base.saveTopIndex(lvwItems, getArguments());
        super.onDestroyView();
    }

    @Override
    public final Mappable<Model> getModelMappable() {
        return page.getMappable();
    }

    @Override
    public final ExpandableAdapter getExpandableAdapter() {
        return adapter;
    }

    @Override
    public final ExpandableListView getExpandableListView() {
        return lvwItems;
    }

    @Override
    public ExpandableGroup<? extends Model> getExpandableGroup(int viewType, LayoutInflater inflater, ViewGroup parent) {
        return new DefaultExpandableGroup(inflater, parent, this);
    }

    @Override
    public ExpandableChild<? extends Model> getExpandableChild(int viewType, LayoutInflater inflater, ViewGroup parent) {
        return new DefaultExpandableChild(inflater, parent, this);
    }

    @Override
    public boolean onExpandableChildLongClick(View itemView, Model model, int groupPosition, int childPosition, boolean lastChild) {
        return false;
    }

    @Override
    public boolean onExpandableGroupLongClick(View itemView, Model model, int groupPosition, boolean expanded) {
        return false;
    }

    @Override
    public void onExpandableChildClick(View itemView, Model model, int groupPosition, int childPosition, boolean lastChild) {

    }

    @Override
    public void onExpandableGroupClick(View itemView, Model model, int groupPosition, boolean expanded) {

    }

    /*==============================================================================================
    PROTECTED METHOD
    ==============================================================================================*/

    /**
     * Inicializa el ExpandableView y el ExpandableAdapter
     * ATENCIÓN!!!: Este método debe llamarse dentro de <b>onCreateViewFragment()</b>.
     * @param lvwItems el ExpandableView
     * @param groupTypeCount número de tipos para grupos diferentes (por default = 1)
     * @param childTypeCount número de tipos para hijos diferentes (por default = 1)
     */
    protected final void initExpandableListViewAdapter(ExpandableListView lvwItems, int groupTypeCount, int childTypeCount){
        adapter = new ExpandableAdapter(getLayoutInflater(), groupTypeCount, childTypeCount, this);
        lvwItems.setAdapter(adapter);
        this.lvwItems = lvwItems;
    }
}
