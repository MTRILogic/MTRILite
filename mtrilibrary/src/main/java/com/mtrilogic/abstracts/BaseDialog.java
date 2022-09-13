package com.mtrilogic.abstracts;

import android.app.Dialog;
import android.content.Context;

import com.mtrilogic.interfaces.Dialogable;
import com.mtrilogic.interfaces.OnTaskCompleteListener;

@SuppressWarnings("unused")
public abstract class BaseDialog<M extends Model> extends Dialog implements Dialogable {
    protected final OnTaskCompleteListener<M> listener;

    /*==============================================================================================
    PUBLIC CONSTRUCTORS
    ==============================================================================================*/

    public BaseDialog(Context context, OnTaskCompleteListener<M> listener) {
        super(context);
        this.listener = listener;
    }

    protected BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener, OnTaskCompleteListener<M> listener) {
        super(context, cancelable, cancelListener);
        this.listener = listener;
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHOD
    ==============================================================================================*/

    @Override
    public final void onMakeToast(String line) {
        makeToast(line);
    }

    /*==============================================================================================
    PROTECTED METHOD
    ==============================================================================================*/

    protected final void makeToast(String line){
        listener.onMakeToast(line);
    }
}
