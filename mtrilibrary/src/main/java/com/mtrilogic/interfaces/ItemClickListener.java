package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.view.View;

import com.mtrilogic.abstracts.Modelable;

public interface ItemClickListener {
    boolean onItemLongClick(@NonNull View itemView, @NonNull Modelable modelable, int position);

    void onItemClick(@NonNull View itemView, @NonNull Modelable modelable,  int position);
}
