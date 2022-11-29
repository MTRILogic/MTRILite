package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;

import com.mtrilogic.abstracts.Model;

@SuppressWarnings({"unused", "EmptyMethod"})
public interface OnTaskCompleteListener<M extends Model> {
    void onTaskComplete(@NonNull M model, int result);

    void onTaskError(@NonNull String msg);
}
