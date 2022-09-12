package com.mtrilogic.items;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mtrilogic.abstracts.Recyclable;
import com.mtrilogic.interfaces.RecyclableItemListener;
import com.mtrilogic.models.DefaultModel;
import com.mtrilogic.mtrilibrary.R;

@SuppressWarnings("unused")
public class DefaultRecyclable extends Recyclable<DefaultModel> {
    private TextView lblTitle;

    /*==============================================================================================
    PUBLIC CONSTRUCTOR
    ==============================================================================================*/

    public DefaultRecyclable(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, @NonNull RecyclableItemListener listener) {
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
        lblTitle.setText(itemView.getContext().getString(R.string.default_item, model.getItemId(), position));
    }
}
