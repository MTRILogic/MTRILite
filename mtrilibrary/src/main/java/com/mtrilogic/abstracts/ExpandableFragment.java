package com.mtrilogic.abstracts;

import android.view.View;

import com.mtrilogic.adapters.ExpandableAdapter;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.classes.Mapable;
import com.mtrilogic.interfaces.ExpandableAdapterListener;
import com.mtrilogic.interfaces.ExpandableListener;
import com.mtrilogic.mtrilibrary.R;
import com.mtrilogic.views.ExpandableView;

@SuppressWarnings("unused")
public abstract class ExpandableFragment<P extends MapablePage> extends Fragmentable<P> implements
        ExpandableListener, ExpandableAdapterListener {
    protected ExpandableAdapter adapter;
    protected ExpandableView lvwItems;

    protected abstract void onExpandableCreated();

// ****************| PROTECTED METHODS |************************************************************

    protected void initExpandable(View view, int groupTypeCount, int childTypeCount){
        Listable<Modelable> groupListable = page.getGroupListable();
        Mapable<Modelable> childMapable = page.getChildMapable();
        adapter = new ExpandableAdapter(this, groupListable, childMapable,
                groupTypeCount, childTypeCount);
        lvwItems = (ExpandableView) view.findViewById(R.id.lvw_items);
        lvwItems.setAdapter(adapter);
        onExpandableCreated();
    }

// ****************| PUBLIC OVERRIDE METHODS |******************************************************

    @Override
    protected void onNewPosition() {

    }

    @Override
    public ExpandableView getExpandableView() {
        return lvwItems;
    }

    @Override
    public ExpandableAdapter getExpandableAdapter(){
        return adapter;
    }
}
