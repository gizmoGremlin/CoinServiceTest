package com.example.nickg.coinservicetest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTC {

    @SerializedName("BTC")
    @Expose
    private Integer bTC;
    @SerializedName("CAD")
    @Expose
    private Double cAD;

    public Integer getBTC() {
        return bTC;
    }

    public void setBTC(Integer bTC) {
        this.bTC = bTC;
    }

    public Double getCAD() {
        return cAD;
    }

    public void setCAD(Double cAD) {
        this.cAD = cAD;
    }

}