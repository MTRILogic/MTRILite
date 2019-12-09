package com.mtrilogic.interfaces;

import android.support.v7.widget.RecyclerView;

import com.mtrilogic.adapters.RecyclableAdapter;

@SuppressWarnings("unused")
public interface RecyclableAdapterListener extends OnItemLongClickListener{
    RecyclableAdapter getRecyclableAdapter();
    RecyclerView getRecyclerView();
}
