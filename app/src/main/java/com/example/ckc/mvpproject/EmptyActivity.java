package com.example.ckc.mvpproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;


/**
 * Created by foxleezh on 18-3-14.
 */

public class EmptyActivity extends FragmentActivity {
    private String fragmentName;
    private boolean shouldClose;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentName = getIntent().getStringExtra("fragmentName");
        shouldClose = getIntent().getBooleanExtra("shouldClose", true);
        if (TextUtils.isEmpty(fragmentName)) {
            ActivityInfo info = null;
            try {
                info = this.getPackageManager()
                        .getActivityInfo(getComponentName(),
                                PackageManager.GET_META_DATA);
                fragmentName = info.metaData.getString("fragmentName");
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        setContentView(R.layout.public_activity_empty);
        initFragment();
    }

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getFragment();
        if (fragment == null) {
            finish();
            return;
        }
        transaction.replace(R.id.fl_parent, fragment);
        transaction.commit();
    }

    public Fragment getFragment() {
        if (fragment == null) {
            try {
                Class onwClass = Class.forName(fragmentName);
                Object instance = onwClass.newInstance();
                fragment = (Fragment) instance;
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return fragment;
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fragment.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    public void onBackPressed() {
        if (shouldClose) {
            super.onBackPressed();
        }
    }
}

