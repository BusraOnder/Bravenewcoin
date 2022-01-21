package com.example.bravenewcoin.components;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Market {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("baseAssetId")
    @Expose
    private String baseAssetId;
    @SerializedName("quoteAssetId")
    @Expose
    private String quoteAssetId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBaseAssetId() {
        return baseAssetId;
    }

    public void setBaseAssetId(String baseAssetId) {
        this.baseAssetId = baseAssetId;
    }

    public String getQuoteAssetId() {
        return quoteAssetId;
    }

    public void setQuoteAssetId(String quoteAssetId) {
        this.quoteAssetId = quoteAssetId;
    }

}
