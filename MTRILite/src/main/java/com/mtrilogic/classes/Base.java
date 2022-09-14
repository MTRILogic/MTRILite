package com.mtrilogic.classes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;

@SuppressWarnings("unused")
public final class Base{
    public static final long INVALID_ID = -1;
    public static final int INVALID_POSITION = -1;

    private static final String TAG = "MainMTRI", INDEX = "index", TOP = "top";

    public static void restoreTopIndex(@NonNull final ListView lvwItems, Bundle state){
        if (state != null) {
            final int index = state.getInt(INDEX, Base.INVALID_POSITION);
            if (index != Base.INVALID_POSITION) {
                final int top = state.getInt(TOP);
                lvwItems.post(new Runnable() {
                    @Override
                    public void run() {
                        lvwItems.setSelectionFromTop(index, top);
                    }
                });
            }
        }
    }

    public static void saveTopIndex(@NonNull ListView lvwItems, Bundle state){
        if (state != null) {
            int index = lvwItems.getFirstVisiblePosition();
            View view = lvwItems.getChildAt(0);
            int top = view != null ? view.getTop() - lvwItems.getPaddingTop() : 0;
            state.putInt(INDEX, index);
            state.putInt(TOP, top);
        }
    }
}
