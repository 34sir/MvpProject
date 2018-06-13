package com.example.ckc.mvpproject.mvp;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseModel implements Parcelable{

    protected BaseModel(Parcel in) {
    }

    protected BaseModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }


}
