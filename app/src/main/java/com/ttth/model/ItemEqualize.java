package com.ttth.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HangPC on 11/14/2017.
 */

public class ItemEqualize implements Parcelable {
    private String title;

    public ItemEqualize(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
    }

    protected ItemEqualize(Parcel in) {
        this.title = in.readString();
    }

    public static final Parcelable.Creator<ItemEqualize> CREATOR = new Parcelable.Creator<ItemEqualize>() {
        @Override
        public ItemEqualize createFromParcel(Parcel source) {
            return new ItemEqualize(source);
        }

        @Override
        public ItemEqualize[] newArray(int size) {
            return new ItemEqualize[size];
        }
    };
}
