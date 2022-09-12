package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.view.View;

import com.mtrilogic.abstracts.Model;

@SuppressWarnings({"unused", "EmptyMethod", "SameReturnValue"})
public interface InflatableListener extends OnMakeToastListener {
    boolean onItemLongClick(@NonNull View itemView, @NonNull Model model, int position);

    void onItemClick(@NonNull View itemView, @NonNull Model model, int position);
}
