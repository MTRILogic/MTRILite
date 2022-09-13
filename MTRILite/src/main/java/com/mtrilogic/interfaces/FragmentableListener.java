package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;

@SuppressWarnings("unused")
public interface FragmentableListener extends OnMakeToastListener{
    void onNewTagName(@NonNull String oldTag, @NonNull String newTag);
}
