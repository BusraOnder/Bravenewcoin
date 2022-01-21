package com.example.bravenewcoin;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

import android.widget.Toast;

import com.example.bravenewcoin.components.Asset;
import com.example.bravenewcoin.components.managers.AssetListManager;
import com.example.bravenewcoin.components.managers.MainManager;
import com.example.bravenewcoin.components.managers.MarketListManager;
import com.example.bravenewcoin.components.MyView;
import com.example.bravenewcoin.components.PopupController;
import com.example.bravenewcoin.components.TokenBody;
import com.example.bravenewcoin.components.TokenRepsonse;
import com.example.bravenewcoin.components.adapters.MyAssetAdapter;
import com.example.bravenewcoin.retrofit.ApiClient;
import com.example.bravenewcoin.retrofit.RestInterface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    public static TokenRepsonse tokenRepsonse;

    public static List<Asset> listAsset;

    static RestInterface restInterface;

    MarketListManager marketListManager;
    AssetListManager assetListManager;

    static MainManager mainManager;

    static PopupController popupController;

    public static int whichList = 0;

    MyView myViewMarket,myViewAsset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainManager = new MainManager();

        restInterface = ApiClient.getClient().create(RestInterface.class);

        popupController = new PopupController(this);

        myViewAsset = (MyView) findViewById(R.id.assetView);
        myViewMarket = (MyView) findViewById(R.id.marketView);

        listAsset = new ArrayList<Asset>();

    }


    public void getToken(){

        Call<TokenRepsonse> call = restInterface.postAut(new TokenBody());
        call.enqueue(new Callback<TokenRepsonse>() {
            @Override
            public void onResponse(Call<TokenRepsonse> call,
                                   retrofit2.Response<TokenRepsonse> response) {

                Log.e("Upload response:", response.message());
                tokenRepsonse = response.body();
                Toast.makeText(getApplicationContext(),"Token alımı başarılı",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<TokenRepsonse> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
            }
        });
    }


    public static void  getAsset(String id){

        MainManager.getAsset(id);

    }


    @Subscribe
    public void getEventMarketList(MarketListManager _marketListManager){
        marketListManager = _marketListManager;
        popupController.showMarketList(marketListManager.getMainMarketList());

    }

    @Subscribe
    public void getEventAssetList(AssetListManager _assetListManager){
        Log.i("EventBus", String.valueOf(whichList));
        assetListManager = _assetListManager;

        try {

            if (whichList == 1){
                Log.i("EventBusAsset","assetList");
                popupController.showAssetList(assetListManager.getAssetList());

            }else{
                Log.i("EventBusAsset","asset");
                listAsset.add(_assetListManager.getAsset());
                MyAssetAdapter adapter = new MyAssetAdapter(popupController.getContext(),listAsset);
                popupController.listViewMarkeAndAsset.setAdapter(adapter);
            }



        }catch (Exception e){
            Log.i("EventBusExc",e.getMessage());
        }




    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        getToken();


    }
}
