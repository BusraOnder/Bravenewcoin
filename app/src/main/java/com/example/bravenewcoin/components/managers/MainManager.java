package com.example.bravenewcoin.components.managers;

import android.util.Log;
import android.view.View;

import com.example.bravenewcoin.components.Asset;
import com.example.bravenewcoin.components.AssetList;
import com.example.bravenewcoin.components.MarketList;
import com.example.bravenewcoin.components.MyView;
import com.example.bravenewcoin.retrofit.ApiClient;
import com.example.bravenewcoin.retrofit.RestInterface;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainManager {

	static RestInterface restInterface;
	public static MarketListManager marketListManager;
	AssetListManager assetListManager;

	public MainManager(){

		restInterface = ApiClient.getClient().create(RestInterface.class);
	}


	public static void  getMarketList(){


		Call<MarketList> call = restInterface.getMarketList(null,null);

		call.enqueue(new Callback<MarketList>() {
			@Override
			public void onResponse(Call<MarketList> call, Response<MarketList> response) {

				Log.i("getMarketList", String.valueOf(response.body().getMarket().get(0).getId()));
				MyView.progressBar.setVisibility(View.GONE);
				EventBus.getDefault().post(new MarketListManager(response.body()));

			}

			@Override
			public void onFailure(Call<MarketList> call, Throwable t) {
				Log.i("getMarketList Failure",t.getMessage());
			}


		});

	}


	public static void  getAsset(String id){

		Call<Asset> call = restInterface.getAssetListById(id);

		call.enqueue(new Callback<Asset>() {
			@Override
			public void onResponse(Call<Asset> call, Response<Asset> response) {

				EventBus.getDefault().post(new AssetListManager(response.body()));
			}

			@Override
			public void onFailure(Call<Asset> call, Throwable t) {
				Log.i("getAsset Failure",t.getMessage());

			}
		});

	}


	public static void getAssetList(){

		Call<AssetList> call = restInterface.getAssetList("ACTIVE");

		call.enqueue(new Callback<AssetList>() {
			@Override
			public void onResponse(Call<AssetList> call, Response<AssetList> response) {

				MyView.progressBar.setVisibility(View.GONE);
				EventBus.getDefault().post(new AssetListManager(response.body()));

			}

			@Override
			public void onFailure(Call<AssetList> call, Throwable t) {
				Log.i("getAsset Failure",t.getMessage());

			}
		});
	}




}
