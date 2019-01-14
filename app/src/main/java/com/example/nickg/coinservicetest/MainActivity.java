package com.example.nickg.coinservicetest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

//https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,CAD&tsyms=BTC,CAD
//api Key for CryptoCompare==   8740dd7c30e6d85723c614e470c9f8221030f468beffa42442f6add53294a745
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
