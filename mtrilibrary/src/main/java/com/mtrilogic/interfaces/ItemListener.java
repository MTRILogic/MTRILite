package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;

import com.mtrilogic.abstracts.Modelable;

public interface ItemListener extends OnMakeToastListener {
    boolean onItemLongClick(@NonNull Modelable modelable, int position);
    void onItemClick(@NonNull Modelable modelable,  int position);
}
