package com.mtrilogic.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtrilogic.abstracts.Page;
import com.mtrilogic.abstracts.Paginable;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.interfaces.Fragmentable;
import com.mtrilogic.interfaces.PaginableAdapterListener;

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class PaginableAdapter extends PagerAdapter {
    private final PaginableAdapterListener listener;
    private final LayoutInflater inflater;

    private final ArrayList<View> itemViewList;

    /*==============================================================================================
    PUBLIC CONSTRUCTOR
    ==============================================================================================*/

    public PaginableAdapter(LayoutInflater inflater, PaginableAdapterListener listener){
        itemViewList = new ArrayList<>();
        this.inflater = inflater;
        this.listener = listener;
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public int getCount() {
        return getPageListable().getCount();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        Paginable<? extends Page> paginable = (Paginable<? extends Page>) object;
        return paginable.isFromView(view);
    }

    @Override
    public Paginable<? extends Page> instantiateItem(ViewGroup container, int position) {
        View itemView = null;
        if (position < itemViewList.size()){
            itemView = itemViewList.get(position);
        }
        Page page = getPage(position);
        Paginable<? extends Page> paginable;
        if (itemView != null){
            paginable = (Paginable<? extends Page>) itemView.getTag();
        }else {
            int viewType = page.getViewType();
            paginable = listener.getPaginable(viewType, inflater, container);
            itemView = paginable.getItemView();
            itemView.setTag(paginable);
            while (itemViewList.size() <= position){
                itemViewList.add(null);
            }
            itemViewList.set(position, itemView);
            container.addView(itemView);
        }
        paginable.bindPage(page, position);
        return paginable;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = itemViewList.set(position, null);
        container.removeView(view);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getPage(position).getPageTitle();
    }

    @Override
    public int getItemPosition(Object object) {
        Fragmentable fragmentable = (Fragmentable) object;
        Page page = fragmentable.getPage();
        Listable<Page> pageListable = getPageListable();
        if (pageListable.contains(page)){
            int position = pageListable.getPosition(page);
            if (fragmentable.getPosition() != position){
                fragmentable.setPosition(position);
                return position;
            }
            return POSITION_UNCHANGED;
        }
        return POSITION_NONE;
    }

    /*==============================================================================================
    PRIVATE METHODS
    ==============================================================================================*/

    private Listable<Page> getPageListable(){
        return listener.getPageListable();
    }

    private Page getPage(int position){
        return getPageListable().get(position);
    }
}
