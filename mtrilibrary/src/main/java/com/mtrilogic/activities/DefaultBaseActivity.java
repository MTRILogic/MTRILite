package com.mtrilogic.activities;

import android.os.Bundle;

import com.mtrilogic.abstracts.BaseActivity;
import com.mtrilogic.mtrilibrary.R;

@SuppressWarnings("unused")
public class DefaultBaseActivity extends BaseActivity {
    public static final int richard = 7;

    /*==============================================================================================
    PROTECTED OVERRIDE METHOD
    ==============================================================================================*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
    }
}
