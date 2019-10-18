package com.mtrilogic.abstracts.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mtrilogic.abstracts.Fragmentable;
import com.mtrilogic.abstracts.Modelable;
import com.mtrilogic.abstracts.pages.ListablePage;
import com.mtrilogic.adapters.RecyclableAdapter;
import com.mtrilogic.interfaces.RecyclableAdapterListener;
import com.mtrilogic.interfaces.RecyclableListener;
import com.mtrilogic.mtrilibrary.R;

import java.util.ArrayList;

@SuppressWarnings("unused")
public abstract class RecyclableFragment<P extends ListablePage> extends Fragmentable<P> implements RecyclableListener, RecyclableAdapterListener {
    private static final String TAG = "RecyclableFragmentTAG";
    private RecyclableAdapter adapter;

// ****************| PROTECTED METHODS |************************************************************

    protected void init(View view, P page){
        ArrayList<Modelable> modelables = page.getModelableList();
        adapter = new RecyclableAdapter(this, modelables);
        RecyclerView lvwItems = (RecyclerView) view.findViewById(R.id.lvw_items);
        lvwItems.setLayoutManager(new LinearLayoutManager(getContext()));
        lvwItems.setAdapter(adapter);
    }

// ++++++++++++++++| PUBLIC OVERRIDE METHODS |++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Override
    public RecyclableAdapter getRecyclableAdapter(){
        return adapter;
    }
}
