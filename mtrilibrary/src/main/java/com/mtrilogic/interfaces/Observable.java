package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;

@SuppressWarnings("unused")
public interface Observable {
    void attach(@NonNull Observer observer);

    void detach(@NonNull Observer observer);

    void notifyUpdate();
}
