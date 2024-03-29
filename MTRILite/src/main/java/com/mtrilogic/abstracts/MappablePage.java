package com.mtrilogic.abstracts;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mtrilogic.classes.Mappable;

@SuppressWarnings("unused")
public abstract class MappablePage<M extends Model> extends Page {
    private Mappable<M> mappable;

    /*==============================================================================================
    PUBLIC CONSTRUCTORS
    ==============================================================================================*/

    public MappablePage() {
        super();
    }

    public MappablePage(@NonNull String pageTitle, @NonNull String tagName, long itemId, int viewType) {
        super(pageTitle, tagName, itemId, viewType);
        mappable = new Mappable<>();
    }

    /*==============================================================================================
    PROTECTED CONSTRUCTOR
    ==============================================================================================*/

    protected MappablePage(Bundle data) {
        super(data);
    }

    /*==============================================================================================
    PUBLIC METHODS
    ==============================================================================================*/

    public final Mappable<M> getMappable() {
        return mappable;
    }

    public final void setMappable(Mappable<M> mappable) {
        this.mappable = mappable;
    }

    /*==============================================================================================
    PROTECTED OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    protected void restoreFromData(@NonNull Bundle data) {
        super.restoreFromData(data);
        mappable = new Mappable<>(data);
    }

    @Override
    protected void saveToData(@NonNull Bundle data) {
        super.saveToData(data);
        mappable.saveToData(data);
    }
}
