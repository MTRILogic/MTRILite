package com.mtrilogic.abstracts;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@SuppressWarnings({"unused","WeakerAccess"})
public abstract class ModelableCreator<M extends Modelable>
        implements Parcelable.ClassLoaderCreator<M>{

    // ================< PUBLIC ABSTRACT METHODS >==================================================

    public abstract M getParcelable(@NonNull Bundle data);
    public abstract M[] getParcelableArray(int size);

    // ================< PUBLIC FINAL OVERRIDE METHODS >============================================

    @Override
    public final M createFromParcel(Parcel src, ClassLoader loader){
        return getParcelable(src, loader);
    }

    @Override
    public final M createFromParcel(Parcel src){
        return getParcelable(src,null);
    }

    @Override
    public final M[] newArray(int size){
        return getParcelableArray(size);
    }

    // ================< PRIVATE METHODS >==========================================================

    @NonNull
    private M getParcelable(Parcel source, ClassLoader loader){
        Bundle data = null;
        if (source != null && loader != null){
            data = source.readBundle(loader);
        }
        if (data == null){
            data = new Bundle();
        }
        return getParcelable(data);
    }
}
