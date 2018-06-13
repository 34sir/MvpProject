package com.example.ckc.mvpproject.mvp;

/**
 * Created by ckc on 18-6-13.
 */

public interface MvpPresenter<V extends MvpView> {

    public void attachView(V view);

    public void detachView();
}
