package com.mtrilogic.abstracts;

import com.mtrilogic.interfaces.OnTaskCompleteListener;

@SuppressWarnings("unused")
public abstract class TaskCompleteListener<M extends Model> implements OnTaskCompleteListener<M> {
    @Override
    public void onTaskComplete(M model, int result) {

    }

    @Override
    public void onTaskError(String msg) {

    }

    @Override
    public void onMakeToast(String line) {

    }
}
