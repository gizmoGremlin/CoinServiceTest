package com.example.nickg.coinservicetest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CAD {

    @SerializedName("BTC")
    @Expose
    private Double bTC;
    @SerializedName("CAD")
    @Expose
    private Integer cAD;

    public Double getBTC() {
        return bTC;
    }

    public void setBTC(Double bTC) {
        this.bTC = bTC;
    }

    public Integer getCAD() {
        return cAD;
    }

    public void setCAD(Integer cAD) {
        this.cAD = cAD;
    }

}