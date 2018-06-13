package com.example.ckc.mvpproject.demo;

import android.view.View;
import android.widget.Toast;

import com.example.ckc.mvpproject.R;
import com.example.ckc.mvpproject.mvp.BaseFragment;
import com.example.ckc.mvpproject.mvp.MvpView;

import butterknife.OnClick;


/**
 * Created by ckc on 18-6-13.
 */

public class MvpTestFragment extends BaseFragment<MvpTestPresenter> implements MvpTestView {
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_test;
    }

    @Override
    public MvpTestPresenter getPresenter() {
        return new MvpTestPresenter(getActivity().getApplicationContext());
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    protected void init() {
    }

    @OnClick({R.id.btn_eor, R.id.btn_suc})
    public void onClick(View view) {
        if (view.getId() == R.id.btn_eor) {
            mPresenter.getData(false);
        } else if (view.getId() == R.id.btn_suc) {
            mPresenter.getData(true);
        }
    }

    @Override
    public void sucess() {
        Toast.makeText(getContext().getApplicationContext(), "成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error() {
        Toast.makeText(getContext().getApplicationContext(), "失败", Toast.LENGTH_SHORT).show();
    }
}
