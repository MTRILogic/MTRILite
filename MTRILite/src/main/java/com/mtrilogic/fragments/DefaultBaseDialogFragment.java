package com.mtrilogic.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mtrilogic.abstracts.BaseDialogFragment;
import com.mtrilogic.mtrilibrary.R;
import com.mtrilogic.pages.DefaultPage;

public class DefaultBaseDialogFragment extends BaseDialogFragment<DefaultPage> {
    private TextView lblTitle;

    /*==============================================================================================
    PUBLIC OVERRIDE METHOD
    ==============================================================================================*/

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_default, container, false);
        lblTitle = (TextView) view.findViewById(R.id.lblTitle);
        onNewPosition();
        return view;
    }

    /*==============================================================================================
    PROTECTED OVERRIDE METHOD
    ==============================================================================================*/

    @Override
    protected void onNewPosition() {
        lblTitle.setText(getString(R.string.default_fragment, page.getItemId(), position));
    }
}
