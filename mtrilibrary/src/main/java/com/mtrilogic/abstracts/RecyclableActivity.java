package com.mtrilogic.abstracts;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtrilogic.adapters.RecyclableAdapter;
import com.mtrilogic.classes.Base;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.interfaces.RecyclableAdapterListener;
import com.mtrilogic.interfaces.RecyclableItemListener;
import com.mtrilogic.items.DefaultRecyclable;

@SuppressWarnings({"unused"})
public abstract class RecyclableActivity extends BaseActivity implements RecyclableAdapterListener, RecyclableItemListener {
    protected Listable<Model> modelListable;
    protected RecyclableAdapter adapter;
    protected RecyclerView lvwItems;

    /*==============================================================================================
    PROTECTED OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            modelListable = new Listable<>(savedInstanceState);
        }else {
            modelListable = new Listable<>();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        modelListable.saveToData(outState);
        super.onSaveInstanceState(outState);
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public final Listable<Model> getModelListable() {
        return modelListable;
    }

    @Override
    public final RecyclableAdapter getRecyclableAdapter() {
        if (adapter == null){
            Base.makeLog("RecyclableActivity: RecyclableAdapter is null");
        }
        return adapter;
    }

    @Override
    public final RecyclerView getRecyclerView() {
        if (lvwItems == null){
            Base.makeLog("RecyclableActivity: RecyclerView is null");
        }
        return lvwItems;
    }

    @Override
    public Recyclable<? extends Model> getRecyclable(int viewType, LayoutInflater inflater, ViewGroup parent) {
        return new DefaultRecyclable(inflater, parent, this);
    }

    @Override
    public boolean onRecyclableLongClick(View itemView, Model model, int position) {
        return false;
    }

    @Override
    public void onRecyclableClick(View itemView, Model model, int position) {

    }

    /*==============================================================================================
    PROTECTED METHOD
    ==============================================================================================*/

    /**
     * Inicializa el RecyclerView y el RecyclableAdapter
     * ATENCIÓN!!!: Este método debe llamarse dentro de onCreateView
     * @param lvwItems the recyclerView view.
     * @param manager the layout manager (LinearLayoutManager or GridLayoutManager)
     */
    protected final void initRecyclerViewAdapter(RecyclerView lvwItems, RecyclerView.LayoutManager manager){
        adapter = new RecyclableAdapter(getLayoutInflater(), this);
        lvwItems.setAdapter(adapter);
        lvwItems.setLayoutManager(manager);
        this.lvwItems = lvwItems;
    }
}
