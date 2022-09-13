package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;

@SuppressWarnings({"unused", "EmptyMethod"})
public interface OnTaskCompleteListener<M extends Model> extends OnMakeToastListener{
    void onTaskComplete(M model, int result);
    void onTaskError(String msg);
}
