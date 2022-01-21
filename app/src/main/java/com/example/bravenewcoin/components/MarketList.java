package com.example.bravenewcoin.components;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarketList {

    @SerializedName("content")
    @Expose
    private List<Market> market = new ArrayList<Market>();

    public List<Market> getMarket() {
        return market;
    }

    public void setMarket(List<Market> market) {
        this.market = market;
    }

}
