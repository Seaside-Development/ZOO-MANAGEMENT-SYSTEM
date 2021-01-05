package com.swen3.zooman;

public class Species {


    private String mSpecID;
    private String mSpecName;
    private String mClass;
    private String mDescription;
    private String mDiet;



    public String getDiet() {
        return mDiet;
    }

    public String getAniClass() {
        return mClass;
    }

    public String getSpecID() {
        return mSpecID;
    }


    public String getSpecName() {
        return mSpecName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setAniClass(String mClass) {
        this.mClass = mClass;
    }

    public void setDescription(String mDescritpion) {
        this.mDescription = mDescritpion;
    }


    public void setSpecID(String mSpecID) {
        this.mSpecID = mSpecID;
    }


    public void setDiet(String mDiet) {
        this.mDiet = mDiet;
    }


    public void setSpecName(String mSpecName) {
        this.mSpecName = mSpecName;
    }
}
