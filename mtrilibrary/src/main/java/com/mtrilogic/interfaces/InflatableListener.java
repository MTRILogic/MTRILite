package com.mtrilogic.interfaces;

import android.view.View;

import com.mtrilogic.abstracts.Model;

@SuppressWarnings({"unused", "EmptyMethod", "SameReturnValue"})
public interface InflatableListener extends OnMakeToastListener {
    boolean onItemLongClick(View itemView, Model model, int position);

    void onItemClick(View itemView, Model model, int position);
}
