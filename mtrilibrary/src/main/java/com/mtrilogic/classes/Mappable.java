package com.mtrilogic.classes;

import android.os.Bundle;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.interfaces.Observable;
import com.mtrilogic.interfaces.OnIterationListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public final class Mappable<M extends Model> {
    private final Map<M, Listable<M>> childListableMap = new HashMap<>();
    private final Listable<M> groupListable;

    private Listable<M> lastChildListable;

    /*==============================================================================================
    PUBLIC CONSTRUCTORS
    ==============================================================================================*/

    public Mappable(){
        groupListable = new Listable<>();
    }

    public Mappable(Bundle data){
        groupListable = new Listable<>(data);
        iterateGroupList(group -> {
            Listable<M> listable = new Listable<>(data, group.getItemId());
            lastChildListable = childListableMap.put(group, listable);
        });
    }

    /*==============================================================================================
    PUBLIC METHODS
    ==============================================================================================*/

    public void saveToData(Bundle data){
        groupListable.saveToData(data);
        iterateGroupList(group -> {
            Listable<M> listable = childListableMap.get(group);
            if (listable != null) {
                listable.saveToData(data, group.getItemId());
            }
        });
    }

    // ITERATE METHODS >>***************************************************************************

    public void iterateGroupList(OnIterationListener<M> listener){
        groupListable.iterateList(listener);
    }

    public void iterateChildList(M group, OnIterationListener<M> listener){
        Listable<M> childListable = getChildListable(group);
        if (childListable != null){
            childListable.iterateList(listener);
        }
    }

    // ATTACH METHODS ==============================================================================

    public void attachGroupList(Observable observable){
        groupListable.attachList(observable);
    }

    public void attachChildList(M group, Observable observable){
        Listable<M> childListable = getChildListable(group);
        if (childListable != null){
            childListable.attachList(observable);
        }
    }

    public void attachGroup(M group, Observable observable){
        groupListable.attach(group, observable);
    }

    public void attachChild(M group, M child, Observable observable){
        Listable<M> childListable = getChildListable(group);
        if (childListable != null) {
            childListable.attach(child, observable);
        }
    }

    // DETACH METHODS ==============================================================================

    public void detachGroupList(Observable observable){
        groupListable.detachList(observable);
    }

    public void detachChildList(M group, Observable observable){
        Listable<M> childListable = getChildListable(group);
        if (childListable != null){
            childListable.detachList(observable);
        }
    }

    public void detachGroup(M group, Observable observable){
        groupListable.detach(group, observable);
    }

    public void detachChild(M group, M child, Observable observable){
        Listable<M> childListable = getChildListable(group);
        if (childListable != null) {
            childListable.detach(child, observable);
        }
    }

    // APPEND METHODS ==============================================================================

    public boolean appendGroup(M group){
        return appendGroup(group, new Listable<>());
    }

    public boolean appendGroup(M group, Listable<M> childListable){
        if (groupListable.append(group)){
            lastChildListable = childListableMap.put(group, childListable);
            return true;
        }
        lastChildListable = null;
        return false;
    }

    public boolean appendGroupList(ArrayList<M> groupList){
        if (groupListable.appendList(groupList)){
            for (M group : groupList){
                lastChildListable = childListableMap.put(group, new Listable<>());
            }
            return true;
        }
        lastChildListable = null;
        return false;
    }

    public boolean appendChild(M group, M child){
        Listable<M> childListable = getChildListable(group);
        return childListable != null && childListable.append(child);
    }

    public boolean appendChildList(M group, ArrayList<M> childList){
        Listable<M> childListable = getChildListable(group);
        return childListable != null && childListable.appendList(childList);
    }

    // INSERT METHODS ==============================================================================

    public boolean insertGroup(int groupPosition, M group){
        return insertGroup(groupPosition, group, new Listable<>());
    }

    public boolean insertGroup(int groupPosition, M group, Listable<M> childListable){
        if (groupListable.insert(groupPosition, group)){
            lastChildListable = childListableMap.put(group, childListable);
            return true;
        }
        lastChildListable = null;
        return false;
    }

    public boolean insertGroupList(int groupPosition, ArrayList<M> groupList){
        if (groupListable.insertList(groupPosition, groupList)){
            for (M group : groupList){
                lastChildListable = childListableMap.put(group, new Listable<>());
            }
            return true;
        }
        lastChildListable = null;
        return false;
    }

    public boolean insertChild(M group, int childPosition, M child){
        Listable<M> childListable = getChildListable(group);
        return childListable != null && childListable.insert(childPosition, child);
    }

    public boolean insertChildList(M group, int childPosition, ArrayList<M> childList){
        Listable<M> childListable = getChildListable(group);
        return childListable != null && childListable.insertList(childPosition, childList);
    }

    // GET METHODS =================================================================================

    public Map<M, Listable<M>> getChildListableMap() {
        return childListableMap;
    }

    public Listable<M> getGroupListable() {
        return groupListable;
    }

    public ArrayList<M> getGroupList(){
        return groupListable.getList();
    }

    public ArrayList<M> getChildList(M group){
        Listable<M> childListable = getChildListable(group);
        return childListable != null ? childListable.getList() : null;
    }

    public ArrayList<M> getLastChildList() {
        return lastChildListable != null ? lastChildListable.getList() : null;
    }

    public M getGroup(int groupPosition){
        return groupListable.get(groupPosition);
    }

    public M getChild(M group, int childPosition){
        Listable<M> childListable = getChildListable(group);
        return childListable != null ? childListable.get(childPosition) : null;
    }

    public M getLastGroup(){
        return groupListable.getLast();
    }

    public M getLastChild(M group){
        Listable<M> childListable = getChildListable(group);
        return childListable != null ? childListable.getLast() : null;
    }

    public long getGroupIdx(){
        return groupListable.getIdx();
    }

    public long getChildIdx(M group){
        Listable<M> childListable = getChildListable(group);
        return childListable != null ? childListable.getIdx() : -1;
    }

    // SET METHODS =================================================================================

    public boolean setGroup(int groupPosition, M group){
        if (groupListable.set(groupPosition, group)){
            lastChildListable = childListableMap.remove(groupListable.getLast());
            lastChildListable = childListableMap.put(group, lastChildListable);
            return true;
        }
        lastChildListable = null;
        return false;
    }

    public boolean setChild(M group, int childPosition, M child){
        Listable<M> childListable = getChildListable(group);
        return childListable != null && childListable.set(childPosition, child);
    }

    public void setGroupIdx(long idx){
        groupListable.setIdx(idx);
    }

    public void setChildIdx(M group, long idx){
        Listable<M> childListable = getChildListable(group);
        if (childListable != null){
            childListable.setIdx(idx);
        }
    }

    // DELETE METHODS ==============================================================================

    public boolean deleteGroup(M group){
        if (groupListable.delete(group)){
            lastChildListable = childListableMap.remove(group);
            return true;
        }
        lastChildListable = null;
        return false;
    }

    public boolean deleteChild(M group, M child){
        Listable<M> childListable = getChildListable(group);
        return childListable != null && childListable.delete(child);
    }

    public boolean deleteGroupList(ArrayList<M> groupList){
        if (groupListable.deleteList(groupList)){
            for (M group : groupList){
                lastChildListable = childListableMap.remove(group);
            }
            return true;
        }
        lastChildListable = null;
        return false;
    }

    public boolean deleteChildList(M group, ArrayList<M> childList){
        Listable<M> childListable = getChildListable(group);
        return childListable != null && childListable.deleteList(childList);
    }

    // CONTAINS METHODS ============================================================================

    public boolean containsGroup(M group){
        return groupListable.contains(group);
    }

    public boolean containsChild(M group, M child){
        Listable<M> childListable = getChildListable(group);
        return childListable != null && childListable.contains(child);
    }

    public boolean containsGroupList(ArrayList<M> groupList){
        return groupListable.containsList(groupList);
    }

    public boolean containsChildList(M group, ArrayList<M> childList){
        Listable<M> childListable = getChildListable(group);
        return childListable != null && childListable.containsList(childList);
    }

    // RETAIN METHODS ==============================================================================

    public boolean retainGroupList(ArrayList<M> groupList){
        if (groupListable.retainList(groupList)){
            Map<M, Listable<M>> childListableMap = new LinkedHashMap<>();
            for (M group : groupList){
                childListableMap.put(group, getChildListable(group));
            }
            this.childListableMap.clear();
            this.childListableMap.putAll(childListableMap);
            return true;
        }
        return false;
    }

    public boolean retainChildList(M group, ArrayList<M> childList){
        Listable<M> childListable = getChildListable(group);
        return childListable != null && childListable.retainList(childList);
    }

    // POSITION METHODS ============================================================================

    public int getGroupPosition(M group){
        return groupListable.getPosition(group);
    }

    public int getChildPosition(M group, M child){
        Listable<M> childListable = getChildListable(group);
        return childListable != null ? childListable.getPosition(child) : Base.INVALID_POSITION;
    }

    // COUNT METHODS ===============================================================================

    public int getGroupCount(){
        return groupListable.getCount();
    }

    public int getChildCount(M group){
        Listable<M> childListable = getChildListable(group);
        return childListable != null ? childListable.getCount() : Base.INVALID_POSITION;
    }

    // CLEAR METHODS ===============================================================================

    public void clearChildListable(M group){
        Listable<M> childListable = getChildListable(group);
        if (childListable != null){
            childListable.clear();
        }
    }

    public void clearGroupListable(){
        childListableMap.clear();
        groupListable.clear();
    }

    // Experimental functions ======================================================================

    public boolean insertMapable(int groupPosition, Mappable<M> mappable){
        ArrayList<M> groupList = mappable.getGroupList();
        if (groupListable.insertList(groupPosition, groupList)){
            for (M group : groupList){
                lastChildListable = childListableMap.put(group, mappable.getChildListable(group));
            }
            return true;
        }
        lastChildListable = null;
        return false;
    }

    public boolean addMapable(Mappable<M> mappable){
        ArrayList<M> groupList = mappable.getGroupList();
        if (groupListable.appendList(groupList)){
            for (M group : groupList){
                lastChildListable = childListableMap.put(group, mappable.getChildListable(group));
            }
            return true;
        }
        lastChildListable = null;
        return false;
    }

    /*==============================================================================================
    PRIVATE METHODS
    ==============================================================================================*/

    private Listable<M> getChildListable(int groupPosition){
        return getChildListable(getGroup(groupPosition));
    }

    private Listable<M> getChildListable(M group){
        return childListableMap.get(group);
    }
}
