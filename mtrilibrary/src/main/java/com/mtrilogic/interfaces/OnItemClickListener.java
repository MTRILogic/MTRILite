package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.view.View;

import com.mtrilogic.abstracts.Modelable;

@SuppressWarnings("unused")
public interface OnItemClickListener extends OnMakeToastListener {

    // ================< PUBLIC ABSTRACT METHODS >==================================================

    void onItemClick(@NonNull View view, @NonNull Modelable modelable, int position);
}
