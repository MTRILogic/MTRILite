package com.mtrilogic.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mtrilogic.abstracts.Fragmentable;

import java.util.List;

@SuppressWarnings("unused")
public class FragmentableAdapter extends FragmentPagerAdapter{
    private List<Fragmentable> fragments;

    @SuppressWarnings("unused")
    public FragmentableAdapter(FragmentManager manager, List<Fragmentable> fragments){
        super(manager);
        this.fragments = fragments;
    }

    @Override
    public Fragmentable getItem(int position){
        return fragments.get(position);
    }

    @Override
    public int getCount(){
        return fragments.size();
    }

    @Override
    public long getItemId(int position){
        return getItem(position).getItemId();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return getItem(position).getPageTitle();
    }

    @Override
    public int getItemPosition(@NonNull Object object){
        if(object instanceof Fragmentable){
            if(fragments.contains(object)){
                return fragments.indexOf(object);
            }
        }
        return POSITION_NONE;
    }
}
