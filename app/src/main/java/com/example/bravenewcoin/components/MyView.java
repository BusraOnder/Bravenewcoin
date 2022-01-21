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

public class MyView extends RelativeLayout implements View.OnClickListener{

	@SuppressLint("StaticFieldLeak")
	public static ProgressBar progressBar;
	TextView textView;
	TypedArray attributes;
	String title;


	public MyView(Context context, AttributeSet attrs) {
		super(context,attrs);

		try {

			attributes = context.obtainStyledAttributes(attrs, R.styleable.my_view_source);
			title = attributes.getString(R.styleable.my_view_source__text);
			init(title);

		}catch (Exception e){

		}
	}

	private void init(String text){
		inflate(getContext(),R.layout.my_view,this);
		textView = (TextView) findViewById(R.id.text);
		progressBar = (ProgressBar) findViewById(R.id.progress);
		textView.setText(text);
		this.setOnClickListener(this);

	}


	@SuppressLint("NonConstantResourceId")
	@Override
	public void onClick(View v) {

		try {
			progressBar.setVisibility(VISIBLE);

			switch (v.getId()){
				case R.id.assetView:
					MainActivity.whichList = 1;
					MainManager.getAssetList();
					break;
				case R.id.marketView:
					MainActivity.whichList = 0;
					MainManager.getMarketList();
					break;

			}

		}catch (Exception e){
			Log.i("onClickExcp",e.getMessage());
		}

	}

}
