package com.mtrilogic.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mtrilogic.abstracts.BaseActivity;
import com.mtrilogic.mtrilite.R;

@SuppressWarnings("unused")
public class DefaultBaseActivity extends BaseActivity {

    /*==============================================================================================
    PROTECTED OVERRIDE METHOD
    ==============================================================================================*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
    }
}
