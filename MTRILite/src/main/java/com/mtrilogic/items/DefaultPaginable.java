package com.mtrilogic.items;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mtrilogic.abstracts.Paginable;
import com.mtrilogic.interfaces.PaginableItemListener;
import com.mtrilogic.mtrilite.R;
import com.mtrilogic.pages.DefaultPage;

@SuppressWarnings("unused")
public class DefaultPaginable extends Paginable<DefaultPage> {
    private TextView lblTitle;

    /*==============================================================================================
    PUBLIC CONSTRUCTOR
    ==============================================================================================*/

    public DefaultPaginable(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, @NonNull PaginableItemListener listener) {
        super(DefaultPage.class, inflater.inflate(R.layout.fragment_default, parent, false), listener);
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public void onBindItemView() {
        lblTitle = (TextView) itemView.findViewById(R.id.lblTitle);
    }

    @Override
    public void onBindPage() {
        lblTitle.setText(itemView.getContext().getString(R.string.default_page, page.getItemId(), position));
    }
}
