package com.example.bravenewcoin.components;

import java.util.List;

public class MarketListManager {

	List<Market> marketList;
	MarketList mainMarketList;

	public void setMarketList(List<Market> marketList) {
		this.marketList = marketList;
	}

	public MarketList getMainMarketList() {
		return mainMarketList;
	}

	public void setMainMarketList(MarketList marketList2) {
		this.mainMarketList = marketList2;
	}

	public List<Market> getMarketList() {
		return marketList;
	}

	public void setMarketList(MarketList marketList) {
		this.marketList = (List<Market>) marketList;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

	public Market getMarket() {
		return market;
	}

	Market market;

	public MarketListManager(List<Market> _marketList){

		marketList = _marketList;
	}

	public MarketListManager(MarketList _marketList){

		mainMarketList = _marketList;
	}


}
