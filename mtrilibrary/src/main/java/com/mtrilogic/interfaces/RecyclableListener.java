package com.mtrilogic.interfaces;

import android.view.View;

import com.mtrilogic.abstracts.Model;

@SuppressWarnings("unused")
public interface RecyclableListener extends OnMakeToastListener {
    boolean onRecyclableLongClick(View itemView, Model model, int position);

    void onRecyclableClick(View itemView, Model model, int position);
}
