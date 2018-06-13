package com.example.ckc.mvpproject.demo;

import android.content.Context;

import com.example.ckc.mvpproject.mvp.MvpBasePresenter;

/**
 * Created by ckc on 18-6-13.
 */

public class MvpTestPresenter extends MvpBasePresenter<MvpTestView,MvpTestModel>{
    /**
     * must be Application context
     *
     * @param context must be Application context
     */
    public MvpTestPresenter(Context context) {
        super(context);
    }

    public void getData(boolean isSucess) {
        if (getView() != null) {
            if (isSucess) {
                getView().sucess();
            } else {
                getView().error();
            }
        }
    }
}
