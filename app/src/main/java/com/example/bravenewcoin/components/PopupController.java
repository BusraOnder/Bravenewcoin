package com.example.bravenewcoin.components;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.bravenewcoin.MainActivity;
import com.example.bravenewcoin.R;
import com.example.bravenewcoin.components.adapters.MyAssetAdapter;
import com.example.bravenewcoin.components.adapters.MyMarketAdapter;


public class PopupController extends Dialog {

	static Context context;
	ListView listViewFirst;
	public ListView listViewMarkeAndAsset;

	public PopupController(@NonNull Context context) {
		super(context);
		this.context = context;
		XMLObjects();
	}

	private void XMLObjects() {
		this.setContentView(R.layout.list_view);
		listViewFirst = (ListView) findViewById(R.id.list_view);
		listViewMarkeAndAsset = (ListView) findViewById(R.id.list_view2);
		listViewMarkeAndAsset.setVisibility(View.GONE);
	}


	public void showMarketList(MarketList marketList){

		try {
			MyMarketAdapter adapter=new MyMarketAdapter(context,marketList.getMarket());
			listViewFirst.setAdapter(adapter);

			listViewFirst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

					listViewMarkeAndAsset.setVisibility(View.VISIBLE);
					MainActivity.listAsset.clear();

					Log.i("IDDD1", marketList.getMarket().get(position).getId());
					Log.i("IDDD2", marketList.getMarket().get(position).getBaseAssetId());
					Log.i("IDDD3", marketList.getMarket().get(position).getQuoteAssetId());

					MainActivity.getAsset(marketList.getMarket().get(position).getQuoteAssetId());
					MainActivity.getAsset(marketList.getMarket().get(position).getBaseAssetId());

				}
			});


		}catch (Exception e){
			Log.i("MArketExc",e.getMessage());
		}

		showDialog();
	}


	public void showAssetList(AssetList assetList){

		MyAssetAdapter adapter = new MyAssetAdapter(context,assetList.getAsset());
		listViewFirst.setAdapter(adapter);

		listViewFirst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


			}
		});

		showDialog();
	}

	public void showDialog(){
		try {

			WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

			lp.copyFrom(this.getWindow().getAttributes());
			lp.width = (int) (WindowManager.LayoutParams.MATCH_PARENT/0.5);
			lp.height = (int) (WindowManager.LayoutParams.MATCH_PARENT/0.5);

			this.getWindow().setAttributes(lp);
			this.setCanceledOnTouchOutside(true);
			this.setCancelable(true);
			this.show();

		}catch (Exception e){
			Log.i("PopupExcp2",e.getMessage());
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		listViewMarkeAndAsset.setVisibility(View.GONE);

	}
}
