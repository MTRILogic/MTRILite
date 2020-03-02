package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;

import com.mtrilogic.abstracts.Fragmentable;
import com.mtrilogic.abstracts.Paginable;

@SuppressWarnings("unused")
public interface FragmentableListener extends OnMakeToastListener{

    // ================< PUBLIC ABSTRACT METHODS >==================================================

    Fragmentable getFragmentable(@NonNull Paginable paginable, int position);
    void onPositionChanged(int position);
}
