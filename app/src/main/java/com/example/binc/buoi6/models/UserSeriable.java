package com.example.binc.buoi6.models;

import java.io.Serializable;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by Binc on 17/10/2016.
 */
public class UserSeriable implements Serializable {
    private String mName;
    private String mPass;

    public UserSeriable(String name, String pass) {
        mName = name;
        mPass = pass;
    }

    public String getmName() {
        return mName;
    }
}
