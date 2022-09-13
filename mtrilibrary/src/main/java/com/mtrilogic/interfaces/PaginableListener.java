package com.mtrilogic.interfaces;

import android.view.View;

import com.mtrilogic.abstracts.Page;

@SuppressWarnings({"unused", "EmptyMethod", "SameReturnValue"})
public interface PaginableListener extends OnMakeToastListener {
    boolean onPaginableLongClick(View itemView, Page page, int position);

    void onPaginableClick(View itemView, Page page, int position);
}
