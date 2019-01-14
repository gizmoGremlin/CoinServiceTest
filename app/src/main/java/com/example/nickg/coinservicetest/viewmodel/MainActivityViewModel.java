package com.example.nickg.coinservicetest.viewmodel;


import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.nickg.coinservicetest.AppController;
import com.example.nickg.coinservicetest.model.GetCoin;
import com.example.nickg.coinservicetest.networking.CoinResponse;
import com.example.nickg.coinservicetest.networking.CoinService;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static com.example.nickg.coinservicetest.utils.Constant.BTC_CAD_URL_FULL;

public class MainActivityViewModel extends Observable {
   private List<GetCoin> coinList;
   private Context context;
   private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public MainActivityViewModel(Context context) {
        this.context = context;
        this.coinList = new ArrayList<>();

    }
    public void onClickFabToLoad(View view){
        fetchCoinList();
    }

    private void fetchCoinList() {
        AppController appController = AppController.create(context);
        CoinService coinService = appController.getCoinService();

        Disposable disposable = coinService.fetchCoins(BTC_CAD_URL_FULL)
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CoinResponse>() {
                    @Override
                    public void accept(CoinResponse coinResponse) throws Exception {
                        updateCoinDataList(coinResponse.getBtcList());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(context, "Error loading coin data", Toast.LENGTH_SHORT).show();
                    }

    });
        compositeDisposable.add(disposable);
    }

    private void updateCoinDataList(List<GetCoin> coins){
        coinList.addAll(coins);
        setChanged();
        notifyObservers();
    }

    public void reset(){
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
    public List<GetCoin> getCoinList(){
        return coinList;
    }
}


