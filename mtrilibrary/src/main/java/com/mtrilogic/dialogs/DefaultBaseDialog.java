package com.mtrilogic.dialogs;

import android.content.Context;
import android.os.Bundle;

import com.mtrilogic.abstracts.BaseDialog;
import com.mtrilogic.interfaces.OnTaskCompleteListener;
import com.mtrilogic.models.DefaultModel;
import com.mtrilogic.mtrilibrary.R;

@SuppressWarnings("unused")
public class DefaultBaseDialog extends BaseDialog<DefaultModel> {

    /*==============================================================================================
    PUBLIC CONSTRUCTORS
    ==============================================================================================*/

    public DefaultBaseDialog(Context context, OnTaskCompleteListener<DefaultModel> listener) {
        super(context, listener);
    }

    protected DefaultBaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener, OnTaskCompleteListener<DefaultModel> listener) {
        super(context, cancelable, cancelListener, listener);
    }

    /*==============================================================================================
    PROTECTED OVERRIDE METHOD
    ==============================================================================================*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_default);
    }
}
