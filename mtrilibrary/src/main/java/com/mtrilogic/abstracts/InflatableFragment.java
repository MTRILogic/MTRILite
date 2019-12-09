package com.mtrilogic.abstracts;

import android.view.View;

import com.mtrilogic.adapters.InflatableAdapter;
import com.mtrilogic.interfaces.InflatableAdapterListener;
import com.mtrilogic.interfaces.InflatableListener;
import com.mtrilogic.mtrilibrary.R;
import com.mtrilogic.views.InflatableView;

import java.util.ArrayList;

@SuppressWarnings("unused")
public abstract class InflatableFragment<P extends ListablePage> extends Fragmentable<P> implements InflatableListener, InflatableAdapterListener {
    protected InflatableAdapter adapter;
    protected InflatableView lvwItems;

    protected abstract void onInflatableCreated();

// ****************| PROTECTED METHODS |************************************************************

    protected void initInflatable(View view, int typeCount){
        ArrayList<Modelable> modelableList = page.getModelableList();
        adapter = new InflatableAdapter(this, modelableList, typeCount);
        lvwItems = (InflatableView) view.findViewById(R.id.lvw_items);
        lvwItems.setAdapter(adapter);
        onInflatableCreated();
    }

// ****************| PUBLIC OVERRIDE METHODS |******************************************************

    @Override
    protected void onNewPosition() {

    }

    @Override
    public InflatableView getInflatableView() {
        return lvwItems;
    }

    @Override
    public InflatableAdapter getInflatableAdapter(){
        return adapter;
    }
}
