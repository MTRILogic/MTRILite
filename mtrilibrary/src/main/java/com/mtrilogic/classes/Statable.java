package com.mtrilogic.classes;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.mtrilogic.abstracts.Paginable;

@SuppressWarnings("unused")
public class Statable extends ViewModel {
    private MutableLiveData<Listable<Paginable>> listableLiveData;
    private Listable<Paginable> listable;

    public void init(){
        listableLiveData = new MutableLiveData<>();
        listable = new Listable<>();
    }

    public Listable<Paginable> getListable() {
        return listable;
    }

    public LiveData<Listable<Paginable>> getListableLiveData() {
        return listableLiveData;
    }

    public void update(){
        listableLiveData.setValue(listable);
    }

    public void postUpdate(){
        listableLiveData.postValue(listable);
    }
}
