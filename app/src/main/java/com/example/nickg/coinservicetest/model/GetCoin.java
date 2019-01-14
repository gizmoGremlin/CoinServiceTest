package com.example.nickg.coinservicetest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCoin {

    @SerializedName("BTC")
    @Expose
    private BTC bTC;
    @SerializedName("CAD")
    @Expose
    private CAD cAD;

    public BTC getBTC() {
        return bTC;
    }

    public void setBTC(BTC bTC) {
        this.bTC = bTC;
    }

    public CAD getCAD() {
        return cAD;
    }

    public void setCAD(CAD cAD) {
        this.cAD = cAD;
    }

}