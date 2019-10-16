package com.mtrilogic.abstracts;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtrilogic.interfaces.FragmentableAdapterListener;

@SuppressWarnings("unused")
public abstract class Fragmentable<P extends Paginable> extends Fragment{
    private static final String PAGINABLE = "paginable";
    private FragmentableAdapterListener listener;
    private P page;
    private int position;

    protected abstract View onCreateViewFragment(@NonNull LayoutInflater inflater,
                                                 @Nullable ViewGroup container,
                                                 @Nullable Bundle savedInstanceState, P page);

// ++++++++++++++++| PUBLIC STATIC METHODS |++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static Fragmentable getInstance(Paginable paginable, Fragmentable fragmentable){
        Bundle args = new Bundle();
        args.putParcelable(PAGINABLE, paginable);
        fragmentable.setArguments(args);
        return fragmentable;
    }

// ++++++++++++++++| PUBLIC OVERRIDE METHODS |++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentableAdapterListener){
            listener = (FragmentableAdapterListener) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null){
            page = args.getParcelable(PAGINABLE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (page != null){
            position = listener.getAdapter().getPaginablePosition(page);
            return onCreateViewFragment(inflater, container, savedInstanceState, page);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();
    }

// ++++++++++++++++| PUBLIC METHODS |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public FragmentableAdapterListener getListener(){
        return listener;
    }

    public P getPage(){
        return page;
    }

    public int getPosition() {
        return position;
    }
}
