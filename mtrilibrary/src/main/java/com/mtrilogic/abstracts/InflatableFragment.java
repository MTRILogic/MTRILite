package com.mtrilogic.abstracts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mtrilogic.adapters.InflatableAdapter;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.interfaces.InflatableAdapterListener;
import com.mtrilogic.interfaces.InflatableItemListener;
import com.mtrilogic.items.DefaultInflatable;

@SuppressWarnings("unused")
public abstract class InflatableFragment<P extends ListablePage<Model>> extends BaseFragment<P> implements InflatableAdapterListener, InflatableItemListener {
    protected InflatableAdapter adapter;
    protected ListView lvwItems;

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public final Listable<Model> getModelListable() {
        return page.getListable();
    }

    @Override
    public final InflatableAdapter getInflatableAdapter() {
        return adapter;
    }

    @Override
    public final ListView getListView() {
        return lvwItems;
    }

    @Override
    public Inflatable<? extends Model> getInflatable(int viewType, LayoutInflater inflater, ViewGroup parent) {
        return new DefaultInflatable(inflater, parent, this);
    }

    @Override
    public boolean onItemLongClick(View itemView, Model model, int position) {
        return false;
    }

    @Override
    public void onItemClick(View itemView, Model model, int position) {

    }

    /*==============================================================================================
    PROTECTED METHOD
    ==============================================================================================*/

    /**
     * Inicializa el Listview y el InflatableAdapter
     * ATENCIÓN!!!: Este método debe llamarse dentro de onCreateView
     * @param lvwItems el ListView.
     * @param typeCount el número de items diferentes.
     */
    protected final void initListViewAdapter(ListView lvwItems, int typeCount){
        adapter = new InflatableAdapter(getLayoutInflater(), typeCount, this);
        lvwItems.setAdapter(adapter);
        this.lvwItems = lvwItems;
    }
}
