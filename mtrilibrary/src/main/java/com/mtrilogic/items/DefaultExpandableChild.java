package com.mtrilogic.items;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mtrilogic.abstracts.ExpandableChild;
import com.mtrilogic.interfaces.ExpandableItemListener;
import com.mtrilogic.models.DefaultModel;
import com.mtrilogic.mtrilibrary.R;

@SuppressWarnings("unused")
public class DefaultExpandableChild extends ExpandableChild<DefaultModel> {
    private TextView lblTitle;

    /*==============================================================================================
    PUBLIC CONSTRUCTOR
    ==============================================================================================*/

    public DefaultExpandableChild(LayoutInflater inflater, ViewGroup parent, ExpandableItemListener listener) {
        super(DefaultModel.class, inflater.inflate(R.layout.item_default, parent, false), listener);
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public void onBindItemView() {
        lblTitle = (TextView) itemView.findViewById(R.id.lblTitle);
    }

    @Override
    public void onBindModel() {
        lblTitle.setText(itemView.getContext().getString(R.string.default_child, model.getItemId(), childPosition));
    }
}
