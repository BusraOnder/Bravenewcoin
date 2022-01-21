package com.example.bravenewcoin.components;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssetList {

    @SerializedName("content")
    @Expose
    private List<Asset> asset = new ArrayList<Asset>();

    public List<Asset> getAsset() {
        return asset;
    }

    public void setAsset(List<Asset> asset) {
        this.asset = asset;
    }

}
