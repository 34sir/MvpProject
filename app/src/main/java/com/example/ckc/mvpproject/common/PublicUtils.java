package com.example.ckc.mvpproject.common;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.example.ckc.mvpproject.EmptyActivity;
import com.example.ckc.mvpproject.R;


/**
 * 该类介绍 通用工具类
 * Created by foxleezh on 2017/9/15.
 */

public class PublicUtils {

    /**
     * 跳转页面
     * @param context
     * @param fragmentName 跳转页面的Fragment名字，必须是全称，包括包名
     */
    public static void startActivity(Activity context, String fragmentName){
        Intent intent = new Intent(context, EmptyActivity.class);
        startActivity(context,fragmentName,intent);
    }

    /**
     * 跳转页面
     * @param context
     * @param fragmentName 跳转页面的Fragment名字，必须是全称，包括包名
     * @param intent 跳转所需的Intent
     */
    public static void startActivity(Activity context,String fragmentName ,Intent intent) {
        startActivity(context,fragmentName,intent,true,-1);
    }

    /**
     * 跳转页面
     * @param context
     * @param fragmentName 跳转页面的Fragment名字，必须是全称，包括包名
     * @param intent 跳转所需的Intent
     * @param shouldAnim 是否需要跳转动画
     */
    public static void startActivity(Activity context,String fragmentName ,Intent intent,boolean shouldAnim) {
        startActivity(context,fragmentName,intent,shouldAnim,-1);
    }

    /**
     * 跳转页面
     * @param context
     * @param fragmentName 跳转页面的Fragment名字，必须是全称，包括包名
     * @param intent 跳转所需的Intent
     * @param shouldAnim 是否需要跳转动画
     * @param resultCode 跳转返回的resultCode
     */
    public static void startActivity(Activity context,String fragmentName ,Intent intent,boolean shouldAnim,int resultCode){
        if(context==null){
            return;
        }
        if(!TextUtils.isEmpty(fragmentName)) {
            intent.putExtra("fragmentName", fragmentName);
        }
        if(resultCode!=-1){
            context.startActivityForResult(intent,resultCode);
        }else {
            context.startActivity(intent);
        }
    }
}
