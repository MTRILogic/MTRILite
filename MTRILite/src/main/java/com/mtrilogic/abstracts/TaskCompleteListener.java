package com.mtrilogic.abstracts;

import android.support.annotation.NonNull;

import com.mtrilogic.interfaces.OnTaskCompleteListener;

@SuppressWarnings("unused")
public abstract class TaskCompleteListener<M extends Model> implements OnTaskCompleteListener<M> {
    @Override
    public void onTaskComplete(@NonNull M model, int result) {

    }

    @Override
    public void onTaskError(@NonNull String msg) {

    }

    @Override
    public void onMakeToast(String line) {

    }
}
