package com.example.ckc.mvpproject.mvp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ckc on 18-6-13.
 *
 * mvp中的view层 持有presenter
 */

public abstract class BaseFragment<P extends MvpPresenter> extends Fragment {
    protected P mPresenter;
    protected View rootView;
    protected boolean isPrepared;
    private Unbinder unbind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (rootView == null) {
            int layoutRes = getLayoutRes();
            mPresenter = getPresenter();
            rootView = getActivity().getLayoutInflater().inflate(layoutRes, null);
            unbind = ButterKnife.bind(this, rootView);
            isPrepared = true;
            mPresenter.attachView(getMvpView());
            init();
        } else {
            if (rootView.getParent() != null) {
                ((ViewGroup) rootView.getParent()).removeView(rootView);
            }
            unbind = ButterKnife.bind(this, rootView);
            mPresenter.attachView(getMvpView());
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbind != null) {
            unbind.unbind();
        }
    }


    /**
     * Return the layout resource like R.layout.my_layout
     *
     * @return the layout resource or zero ("0"), if you don't want to have an UI
     */
    protected abstract int getLayoutRes();

    public abstract P getPresenter();

    protected abstract MvpView getMvpView();

    protected abstract void init();
}
