package com.example.bravenewcoin.components.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bravenewcoin.R;
import com.example.bravenewcoin.components.Asset;

import java.util.List;

public class MyAssetAdapter extends BaseAdapter {

    Context con;
    List<Asset> assetList;
    Asset asset;
    ImageView activeIcon;

    public MyAssetAdapter(Context con, List<Asset> assetList )
    {
        this.con=con;
        this.assetList=assetList;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return assetList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return assetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub


        asset=assetList.get(position);
        LayoutInflater inflater=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.asset_list,parent,false);

        activeIcon = (ImageView) convertView.findViewById(R.id.activeIcon);
        if (asset.getStatus().equals("ACTIVE")){
            activeIcon.setColorFilter(Color.GREEN);

        }else{
            activeIcon.setColorFilter(Color.RED);
        }


        TextView tv1=(TextView)convertView.findViewById(R.id.tvId);
        tv1.setText(asset.getId());

        TextView tv2=(TextView)convertView.findViewById(R.id.tvTitle);
        tv2.setText(asset.getName());
/*
        TextView tv3=(TextView)convertView.findViewById(R.id.tvBody);
        tv3.setText(asset.getStatus());


 */



        return convertView;
    }

}
