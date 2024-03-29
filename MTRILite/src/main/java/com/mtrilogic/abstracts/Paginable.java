package com.mtrilogic.abstracts;

import android.support.annotation.NonNull;
import android.view.View;

import com.mtrilogic.interfaces.Fragmentable;
import com.mtrilogic.interfaces.PageBindable;
import com.mtrilogic.interfaces.PaginableItemListener;

@SuppressWarnings("unused")
public abstract class Paginable<P extends Page> implements PageBindable, Fragmentable {
    protected final PaginableItemListener listener;
    protected final View itemView;

    private final Class<P> clazz;

    protected int position;
    protected P page;

    /*==============================================================================================
    PUBLIC CONSTRUCTOR
    ==============================================================================================*/

    public Paginable(@NonNull Class<P> clazz, @NonNull View itemView, @NonNull PaginableItemListener listener){
        this.itemView = itemView;
        this.listener = listener;
        this.clazz = clazz;
    }

    /*==============================================================================================
    PUBLIC METHODS
    ==============================================================================================*/

    public View getItemView(){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPaginableClick(itemView, page, position);
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return listener.onPaginableLongClick(itemView, page, position);
            }
        });
        onBindItemView();
        return itemView;
    }

    public void bindPage(@NonNull Page page, int position){
        this.page = clazz.cast(page);
        this.position = position;
        onBindPage();
    }

    public final boolean isFromView(View view){
        return itemView == view;
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public final void setPosition(int position) {
        this.position = position;
    }

    @Override
    public final int getPosition() {
        return position;
    }

    @NonNull
    @Override
    public final Page getPage() {
        return page;
    }

    @Override
    public final void onMakeToast(String line) {
        makeToast(line);
    }

    /*==============================================================================================
    PROTECTED METHODS
    ==============================================================================================*/

    protected final boolean autoDelete(){
        return listener.getPageListable().delete(page);
    }

    protected final void notifyChanged(){
        listener.getPaginableAdapter().notifyDataSetChanged();
    }

    protected final void makeToast(String line){
        listener.onMakeToast(line);
    }
}
