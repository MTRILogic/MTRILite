package com.mtrilogic.abstracts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mtrilogic.adapters.RecyclableAdapter;
import com.mtrilogic.interfaces.ModelBindable;
import com.mtrilogic.interfaces.RecyclableItemListener;

@SuppressWarnings("unused")
public abstract class Recyclable<M extends Model> extends RecyclerView.ViewHolder implements ModelBindable {
    protected final RecyclableItemListener listener;

    private final Class<M> clazz;

    protected int position;
    protected M model;

    /*==============================================================================================
    PUBLIC CONSTRUCTOR
    ==============================================================================================*/

    public Recyclable(@NonNull Class<M> clazz, @NonNull View itemView, @NonNull RecyclableItemListener listener) {
        super(itemView);
        this.listener = listener;
        this.clazz = clazz;
    }

    /*==============================================================================================
    PUBLIC METHODS
    ==============================================================================================*/

    public void bindItemView(){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecyclableClick(itemView, model, position);
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return listener.onRecyclableLongClick(itemView, model, position);
            }
        });
        onBindItemView();
    }

    public void bindModel(@NonNull Model model, int position){
        this.model = clazz.cast(model);
        this.position = position;
        onBindModel();
    }

    /*==============================================================================================
    PROTECTED METHODS
    ==============================================================================================*/

    protected final boolean autoDelete(){
        return listener.getModelListable().delete(model);
    }

    protected final void notifyChanged(){
        notifyItem(new OnNotifyItemListener() {
            @Override
            public void onNotifyItem(RecyclableAdapter adapter, int position) {
                adapter.notifyItemChanged(position);
            }
        }, new OnNotifyItemRangeListener() {
            @Override
            public void onNotifyItemRange(RecyclableAdapter adapter, int positionStart, int itemCount) {
                adapter.notifyItemRangeChanged(positionStart, itemCount);
            }
        });
    }

    protected final void notifyInserted(){
        notifyItem(new OnNotifyItemListener() {
            @Override
            public void onNotifyItem(RecyclableAdapter adapter, int position) {
                adapter.notifyItemInserted(position);
            }
        }, new OnNotifyItemRangeListener() {
            @Override
            public void onNotifyItemRange(RecyclableAdapter adapter, int positionStart, int itemCount) {
                adapter.notifyItemRangeInserted(positionStart, itemCount);
            }
        });
    }

    protected final void notifyDeleted(){
        notifyItem(new OnNotifyItemListener() {
            @Override
            public void onNotifyItem(RecyclableAdapter adapter, int position) {
                adapter.notifyItemRemoved(position);
            }
        }, new OnNotifyItemRangeListener() {
            @Override
            public void onNotifyItemRange(RecyclableAdapter adapter, int positionStart, int itemCount) {
                adapter.notifyItemRangeRemoved(positionStart, itemCount);
            }
        });
    }

    protected final void notifyMoved(int fromPosition, int toPosition){
        listener.getRecyclableAdapter().notifyItemMoved(fromPosition, toPosition);
    }

    protected final void makeToast(String line){
        listener.onMakeToast(line);
    }

    /*==============================================================================================
    PRIVATE METHOD
    ==============================================================================================*/

    private void notifyItem(OnNotifyItemListener itemListener, OnNotifyItemRangeListener itemRangeListener){
        RecyclableAdapter adapter = listener.getRecyclableAdapter();
        int position = getAdapterPosition();
        itemListener.onNotifyItem(adapter, position);
        int count = listener.getModelListable().getCount();
        if (count > position) {
            itemRangeListener.onNotifyItemRange(adapter, position, count - position);
        }
    }

    /*==============================================================================================
    PRIVATE INTERFACES
    ==============================================================================================*/

    private interface OnNotifyItemListener{
        void onNotifyItem(RecyclableAdapter adapter, int position);
    }

    private interface  OnNotifyItemRangeListener{
        void onNotifyItemRange(RecyclableAdapter adapter, int positionStart, int itemCount);
    }
}
