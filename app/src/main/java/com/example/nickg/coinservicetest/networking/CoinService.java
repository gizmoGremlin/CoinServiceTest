package com.example.nickg.coinservicetest.networking;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CoinService {


    @GET
    Observable<CoinResponse> fetchCoins(@Url String url);
}
