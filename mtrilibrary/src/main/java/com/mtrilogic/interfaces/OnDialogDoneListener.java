package com.mtrilogic.interfaces;

import android.os.Bundle;
import android.support.annotation.NonNull;

@SuppressWarnings("unused")
public interface OnDialogDoneListener extends OnMakeToastListener{

    // ================< PUBLIC ABSTRACT METHODS >==================================================

    void onDialogDone(@NonNull Bundle bundle);
}
