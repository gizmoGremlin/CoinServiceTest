package com.example.nickg.coinservicetest;

import android.app.Application;
import android.content.Context;

import com.example.nickg.coinservicetest.networking.ApiFactory;
import com.example.nickg.coinservicetest.networking.CoinService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class AppController extends Application {

    private CoinService coinService;
    private Scheduler scheduler;

    private static AppController get(Context context){
        return (AppController) context.getApplicationContext();
    }

    public static AppController create(Context context){
        return AppController.get(context);
    }

    public CoinService getCoinService(){
        if (coinService ==  null){
            coinService = ApiFactory.create();
        }
        return  coinService;
    }

    public Scheduler subscribeScheduler(){
        if (scheduler == null){
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setCoinService(CoinService coinService) {
        this.coinService = coinService;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
