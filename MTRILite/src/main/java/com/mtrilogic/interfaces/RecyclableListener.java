package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.view.View;

import com.mtrilogic.abstracts.Model;

@SuppressWarnings("unused")
public interface RecyclableListener extends OnMakeToastListener {
    boolean onRecyclableLongClick(@NonNull View itemView, @NonNull Model model, int position);

    void onRecyclableClick(@NonNull View itemView, @NonNull Model model, int position);
}
