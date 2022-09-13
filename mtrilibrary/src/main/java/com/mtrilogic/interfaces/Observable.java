package com.mtrilogic.interfaces;

@SuppressWarnings("unused")
public interface Observable {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyUpdate();
}
