package com.example.bravenewcoin.components.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bravenewcoin.R;
import com.example.bravenewcoin.components.Market;

import java.util.List;

public class MyMarketAdapter extends BaseAdapter {

    Context con;
    List<Market> marketList;
    Market market;

    public MyMarketAdapter(Context con, List<Market> marketList )
    {
        this.con=con;
        this.marketList =marketList;

    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return marketList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return marketList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        market = marketList.get(position);
        LayoutInflater inflater=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.market_list,parent,false);


        TextView tv1=(TextView)convertView.findViewById(R.id.tvId);
        tv1.setText(market.getId());

        TextView tv2=(TextView)convertView.findViewById(R.id.tvTitle);
        tv2.setText(market.getBaseAssetId());

        TextView tv3=(TextView)convertView.findViewById(R.id.tvBody);
        tv3.setText(market.getQuoteAssetId());

        return convertView;
    }

}
