package com.mtrilogic.classes;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.mtrilogic.abstracts.Paginable;

@SuppressWarnings("unused")
public class Statable extends ViewModel {
    private MutableLiveData<Listable<Paginable>> listableLiveData;
    private Listable<Paginable> listable;

    public Listable<Paginable> getListable() {
        return listable;
    }

    public LiveData<Listable<Paginable>> getListableLiveData() {
        if (listableLiveData == null){
            listableLiveData = new MutableLiveData<>();
            listable = new Listable<>();
        }
        return listableLiveData;
    }

    public void setUpdate(){
        listableLiveData.setValue(listable);
    }

    public void postUpdate(){
        listableLiveData.postValue(listable);
    }
}
