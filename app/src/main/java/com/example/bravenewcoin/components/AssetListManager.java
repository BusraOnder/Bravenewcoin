package com.example.bravenewcoin.components;

public class AssetListManager {

	AssetList assetList;
	Asset asset;

	public AssetListManager(AssetList _assetList){

		assetList = _assetList;
	}

	public AssetList getAssetList() {
		return assetList;
	}

	public void setAssetList(AssetList assetList) {
		this.assetList = assetList;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public AssetListManager(Asset _asset){
		asset = _asset;
	}
}
