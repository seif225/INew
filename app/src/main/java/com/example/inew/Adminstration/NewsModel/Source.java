
package com.example.inew.Adminstration.NewsModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Source {

    @SerializedName("id")
    private Object mId;
    @SerializedName("name")
    private String mName;

    public Object getId() {
        return mId;
    }

    public void setId(Object id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
