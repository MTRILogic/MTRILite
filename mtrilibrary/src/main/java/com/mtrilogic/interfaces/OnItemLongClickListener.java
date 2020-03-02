package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.view.View;

import com.mtrilogic.abstracts.Modelable;

@SuppressWarnings("unused")
public interface OnItemLongClickListener extends OnItemClickListener {

    // ================< PUBLIC ABSTRACT METHODS >==================================================

    boolean onItemLongClick(@NonNull View view, @NonNull Modelable modelable, int position);
}
