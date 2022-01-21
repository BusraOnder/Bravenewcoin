package com.example.bravenewcoin.retrofit;

import com.example.bravenewcoin.components.Asset;
import com.example.bravenewcoin.components.AssetList;
import com.example.bravenewcoin.components.MarketList;
import com.example.bravenewcoin.components.TokenBody;
import com.example.bravenewcoin.components.TokenRepsonse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RestInterface  {

	@POST("oauth/token")
	@Headers({
			"x-rapidapi-host: bravenewcoin.p.rapidapi.com",
			"x-rapidapi-key: b15e44e948msh8f1438a0dd8eb21p1f43fajsnbfd578d25e80",
			"Content-Type: application/json"
	})
	Call<TokenRepsonse> postAut(@Body TokenBody object);


	@GET("asset/")
	@Headers({
			"x-rapidapi-host: bravenewcoin.p.rapidapi.com",
			"x-rapidapi-key: b15e44e948msh8f1438a0dd8eb21p1f43fajsnbfd578d25e80",
	})
	Call<AssetList>  getAssetList(@Query(value="status") String status);

	@GET("asset/{id}")
	@Headers({
			"x-rapidapi-host: bravenewcoin.p.rapidapi.com",
			"x-rapidapi-key: b15e44e948msh8f1438a0dd8eb21p1f43fajsnbfd578d25e80",
	})
	Call<Asset>  getAssetListById(@Path("id") String id);

	@GET("market/")
	@Headers({
			"x-rapidapi-host: bravenewcoin.p.rapidapi.com",
			"x-rapidapi-key: b15e44e948msh8f1438a0dd8eb21p1f43fajsnbfd578d25e80",
	})
	Call<MarketList>  getMarketList(@Query(value="baseAssetId") String baseAssetId,@Query(value="quoteAssetId") String quoteAssetId);
}
