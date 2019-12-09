package com.mtrilogic.abstracts;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mtrilogic.adapters.RecyclableAdapter;
import com.mtrilogic.interfaces.RecyclableAdapterListener;
import com.mtrilogic.interfaces.RecyclableListener;
import com.mtrilogic.mtrilibrary.R;

import java.util.ArrayList;

@SuppressWarnings({"unused"})
public abstract class RecyclableFragment<P extends ListablePage> extends Fragmentable<P>
        implements RecyclableListener, RecyclableAdapterListener {
    protected RecyclableAdapter adapter;
    protected RecyclerView lvwItems;

    protected abstract void onRecyclableCreated();

// ****************| PROTECTED METHODS |************************************************************

    protected void initRecyclable(View view, RecyclerView.LayoutManager layoutManager){
        ArrayList<Modelable> modelables = page.getModelableList();
        adapter = new RecyclableAdapter(this, modelables);
        lvwItems = (RecyclerView) view.findViewById(R.id.lvw_items);
        lvwItems.setLayoutManager(layoutManager);
        lvwItems.setAdapter(adapter);
        onRecyclableCreated();
    }

// ++++++++++++++++| PUBLIC OVERRIDE METHODS |++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Override
    protected void onNewPosition() {

    }

    @Override
    public RecyclerView getRecyclerView() {
        return lvwItems;
    }

    @Override
    public RecyclableAdapter getRecyclableAdapter(){
        return adapter;
    }
}
