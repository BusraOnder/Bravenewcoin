package com.example.bravenewcoin.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bravenewcoin.MainActivity;
import com.example.bravenewcoin.R;
import com.example.bravenewcoin.components.managers.MainManager;

public class MyView extends RelativeLayout implements View.OnClickListener{

	@SuppressLint("StaticFieldLeak")
	public static ProgressBar progressBar;
	TextView textView;
	TypedArray attributes;
	RelativeLayout mainView;
	String title;


	@SuppressLint("CustomViewStyleable")
	public MyView(Context context, AttributeSet attrs) {
		super(context,attrs);

		try {

			attributes = context.obtainStyledAttributes(attrs, R.styleable.my_view_source);
			title = attributes.getString(R.styleable.my_view_source__text);
			init(title);

		}catch (Exception e){
			Log.i("Exception1",e.getMessage());
		}
	}

	private void init(String text){
		try {
			inflate(getContext(),R.layout.my_view,this);
			mainView = (RelativeLayout) findViewById(R.id.mainView);
			this.setOnClickListener(this);


			textView = (TextView) findViewById(R.id.text);
			textView.setText(text);
		}catch (Exception e){
			Log.i("Exception2",e.getMessage());
		}


	}


	@SuppressLint("NonConstantResourceId")
	@Override
	public void onClick(View v) {

		progressBar = (ProgressBar) findViewById(R.id.progress);
		progressBar.setVisibility(VISIBLE);
		try {
			progressBar.setVisibility(VISIBLE);


			switch (v.getId()){
				case R.id.assetView:
					Log.i("ID", "asset");
					MainActivity.whichList = 1;
					MainManager.getAssetList();
					break;
				case R.id.marketView:
					Log.i("ID", "market");
					MainActivity.whichList = 0;
					MainManager.getMarketList();
					break;

			}

		}catch (Exception e){
			Log.i("onClickExcp",e.getMessage());
		}



	}

}
