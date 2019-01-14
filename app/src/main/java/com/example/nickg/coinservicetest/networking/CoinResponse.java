package com.example.nickg.coinservicetest.networking;

import com.example.nickg.coinservicetest.model.BTC;
import com.example.nickg.coinservicetest.model.CAD;
import com.example.nickg.coinservicetest.model.GetCoin;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoinResponse {

    @SerializedName("coin_results") private List<GetCoin> btcList;


    public List<GetCoin> getBtcList() {
        return btcList;
    }

    public void setBtcList(List<GetCoin> btcList) {
        this.btcList = btcList;
    }
}
