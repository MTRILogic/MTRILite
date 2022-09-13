package com.mtrilogic.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mtrilogic.abstracts.Page;
import com.mtrilogic.classes.Base;
import com.mtrilogic.classes.Listable;
import com.mtrilogic.interfaces.Fragmentable;
import com.mtrilogic.interfaces.FragmentableAdapterListener;

@SuppressWarnings({"unused"})
public class FragmentableAdapter extends FragmentPagerAdapter {
    private final FragmentableAdapterListener listener;

    /*==============================================================================================
    PUBLIC CONSTRUCTOR
    ==============================================================================================*/

    public FragmentableAdapter(@NonNull FragmentManager manager, @NonNull FragmentableAdapterListener listener){
        super(manager);
        this.listener = listener;
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @NonNull
    @Override
    public final Fragment getItem(int position){
        return listener.getFragment(getPage(position), position);
    }

    @Override
    public final int getCount(){
        return getPageListable().getCount();
    }

    @Override
    public final int getItemPosition(@NonNull Object object){
        Fragmentable fragmentable = (Fragmentable) object;
        Page page = fragmentable.getPage();
        Listable<Page> paginableListable = getPageListable();
        if (paginableListable.contains(page)){
            int position = paginableListable.getPosition(page);
            if (fragmentable.getPosition() != position){
                fragmentable.setPosition(position);
                listener.onPositionChanged(position);
                return position;
            }
            return POSITION_UNCHANGED;
        }
        if (getCount() == 0){
            listener.onPositionChanged(Base.INVALID_POSITION);
        }
        return POSITION_NONE;
    }

    @Nullable
    @Override
    public final CharSequence getPageTitle(int position){
        return getPage(position).getPageTitle();
    }

    @Override
    public final long getItemId(int position){
        return getPage(position).getItemId();
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
