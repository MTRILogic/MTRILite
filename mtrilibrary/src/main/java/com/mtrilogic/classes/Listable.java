package com.mtrilogic.classes;

import android.os.Bundle;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.interfaces.Observable;
import com.mtrilogic.interfaces.Observer;
import com.mtrilogic.interfaces.OnIterationListener;

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class Listable<M extends Model> {
    private static final String LIST = "list", IDX = "idx";

    private final ArrayList<M> list;
    private long idx;

    private M lastItem;

    /*==============================================================================================
    PUBLIC CONSTRUCTORS
    ==============================================================================================*/

    public Listable(){
        list = new ArrayList<>();
    }

    public Listable(ArrayList<M> list, long idx){
        this.list = list;
        this.idx = idx;
    }

    public Listable(Bundle data, long itemId){
        this(data, LIST + itemId, IDX + itemId);
    }

    public Listable(Bundle data){
        this(data, LIST, IDX);
    }

    /*==============================================================================================
    PRIVATE CONSTRUCTOR
    ==============================================================================================*/

    private Listable(Bundle data, String keyList, String keyIdx){
        ArrayList<M> list = data.getParcelableArrayList(keyList);
        if (list != null){
            idx = data.getLong(keyIdx);
        }else {
            list = new ArrayList<>();
        }
        this.list = list;
    }

    /*==============================================================================================
    PUBLIC METHODS
    ==============================================================================================*/

    public void saveToData(Bundle data, long itemId){
        saveToData(data, LIST + itemId, IDX + itemId);
    }

    public void saveToData(Bundle data){
        saveToData(data, LIST, IDX);
    }

    // ITERATE METHOD ==============================================================================

    public void iterateList(OnIterationListener<M> listener){
        for (M item : list){
            listener.onIteration(item);
        }
    }

    // ATTACH METHOD ===============================================================================

    public void attach(M item, Observable observable){
        if (item instanceof Observer){
            observable.attach((Observer) item);
        }
    }

    public void attachList(Observable observable){
        iterateList(item -> attach(item, observable));
    }

    // DETACH METHOD ==============================================================================

    public void detach(M item, Observable observable){
        if (item instanceof Observer){
            observable.detach((Observer) item);
        }
    }

    public void detachList(Observable observable){
        iterateList(item -> detach(item, observable));
    }

    // APPEND ======================================================================================

    public boolean appendList(ArrayList<M> list){
        return this.list.addAll(list);
    }

    public boolean append(M item){
        return !list.contains(item) && list.add(item);
    }

    // INSERT ======================================================================================

    public boolean insertList(int position, ArrayList<M> list){
        return isValidPosition(position) && this.list.addAll(list);
    }

    public boolean insert(int position, M item){
        if (isValidPosition(position) && !list.contains(item)){
            list.add(position, item);
            return true;
        }
        return false;
    }

    // GET =========================================================================================

    public ArrayList<M> getList() {
        return list;
    }

    public M get(int position){
        return isValidPosition(position) ? list.get(position) : null;
    }

    public M getLast() {
        return lastItem;
    }

    public long getIdx() {
        return idx;
    }

    public int getPosition(M item){
        return list.indexOf(item);
    }

    public int getCount(){
        return list.size();
    }

    // SET =========================================================================================

    public boolean set(int position, M item){
        if (isValidPosition(position) && !list.contains(item)){
            lastItem = list.set(position, item);
            return true;
        }
        lastItem = null;
        return false;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    // DELETE ======================================================================================

    public boolean deleteList(ArrayList<M> list){
        return this.list.removeAll(list);
    }

    public boolean delete(int position){
        if (isValidPosition(position)){
            lastItem = list.remove(position);
            return true;
        }
        lastItem = null;
        return false;
    }

    public boolean delete(M item){
        return list.remove(item);
    }

    // CONTAINS ====================================================================================

    public boolean containsList(ArrayList<M> list){
        return this.list.containsAll(list);
    }

    public boolean contains(M item){
        return list.contains(item);
    }

    // RETAIN ======================================================================================

    public boolean retainList(ArrayList<M> list){
        return this.list.retainAll(list);
    }

    // CLEAR =======================================================================================

    public void clear(){
        list.clear();
        idx = 0;
    }

    /*==============================================================================================
    PRIVATE METHODS
    ==============================================================================================*/

    private void saveToData(Bundle data, String keyList, String keyIdx){
        data.putParcelableArrayList(keyList, list);
        data.putLong(keyIdx, idx);
    }

    private boolean isValidPosition(int position){
        return position > -1 && position < getCount();
    }
}
