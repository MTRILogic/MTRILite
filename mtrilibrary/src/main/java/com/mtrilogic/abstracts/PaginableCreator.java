package com.mtrilogic.abstracts;

import android.os.Parcelable;

@SuppressWarnings("unused")
public abstract class PaginableCreator<P extends Paginable> implements Parcelable.ClassLoaderCreator<P> {}
