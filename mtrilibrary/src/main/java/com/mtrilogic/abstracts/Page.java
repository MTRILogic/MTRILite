package com.mtrilogic.abstracts;

import android.os.Bundle;

@SuppressWarnings({"unused"})
public abstract class Page extends Model {
    private static final String PAGE_TITLE = "pageTitle", TAG_NAME = "tagName";

    private String pageTitle, tagName;

    /*==============================================================================================
    PUBLIC CONSTRUCTORS
    ==============================================================================================*/

    public Page(){}

    public Page(String pageTitle, String tagName, long itemId, int viewType){
        super(itemId, viewType);
        this.pageTitle = pageTitle;
        this.tagName = tagName;
    }

    /*==============================================================================================
    PROTECTED CONSTRUCTOR
    ==============================================================================================*/

    protected Page(Bundle data){
        super(data);
    }

    /*==============================================================================================
    PUBLIC FINAL METHODS
    ==============================================================================================*/

    public final String getPageTitle(){
        return pageTitle;
    }

    public final void setPageTitle(String pageTitle){
        this.pageTitle = pageTitle;
    }

    public final String getTagName(){
        return tagName;
    }

    public final void setTagName(String tagName){
        this.tagName = tagName;
    }

    /*==============================================================================================
    PROTECTED OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    protected void restoreFromData(Bundle data) {
        super.restoreFromData(data);
        pageTitle = data.getString(PAGE_TITLE);
        tagName = data.getString(TAG_NAME);
    }

    @Override
    protected void saveToData(Bundle data) {
        super.saveToData(data);
        data.putString(PAGE_TITLE, pageTitle);
        data.putString(TAG_NAME, tagName);
    }
}
