package com.swen3.zooman;


import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.UUID;

public class Customer {

    private String mEmail;
    private String mUserName;
    private String mPassword;

    public String getEmail(){return mEmail;}

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }


    public String getUserName(){
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }


    public String getPassword(){ return  mPassword;}

}
