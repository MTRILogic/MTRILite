package com.mtrilogic.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mtrilogic.abstracts.BaseDialog;
import com.mtrilogic.interfaces.OnTaskCompleteListener;
import com.mtrilogic.models.DefaultModel;
import com.mtrilogic.mtrilibrary.R;

@SuppressWarnings("unused")
public class DefaultBaseDialog extends BaseDialog<DefaultModel> {

    /*==============================================================================================
    PUBLIC CONSTRUCTORS
    ==============================================================================================*/

    public DefaultBaseDialog(@NonNull Context context, @NonNull OnTaskCompleteListener<DefaultModel> listener) {
        super(context, listener);
    }

    protected DefaultBaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener, @NonNull OnTaskCompleteListener<DefaultModel> listener) {
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
