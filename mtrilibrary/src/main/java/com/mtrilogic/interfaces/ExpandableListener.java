package com.mtrilogic.interfaces;

import android.view.View;

import com.mtrilogic.abstracts.Model;

@SuppressWarnings({"unused", "EmptyMethod", "SameReturnValue"})
public interface ExpandableListener extends OnMakeToastListener{
    boolean onExpandableChildLongClick(View itemView, Model model, int groupPosition, int childPosition, boolean lastChild);

    boolean onExpandableGroupLongClick(View itemView, Model model, int groupPosition, boolean expanded);

    void onExpandableChildClick(View itemView, Model model, int groupPosition, int childPosition, boolean lastChild);

    void onExpandableGroupClick(View itemView, Model model, int groupPosition, boolean expanded);
}
