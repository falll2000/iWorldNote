package com.konutek.iworldnote.activity;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Window;

import com.james.views.FreeTextView;
import com.konutek.iworldnote.adapter.NewsSurvayContentAdapter;
import com.konutek.iworldnote.data.NewsData;
import com.konutek.iworldnote.layout.NewsSurvayContentLayout;
import com.konutek.iworldnote.view.DotView;

public class NewsSurvayContentActivity extends BaseActivity{

	private NewsSurvayContentLayout mNewsSurvayContentLayout;
	private DotView mDotView;
	private ViewPager mViewPager;
	private FreeTextView tvCatName;
	private ArrayList<NewsData> newsList;				//	設定給adapter 顯示用	
	private Context mContext;
	private NewsSurvayContentAdapter mNewsSurvayContentAdapter;
	private String catName = "";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature( Window.FEATURE_NO_TITLE );
		mContext = NewsSurvayContentActivity.this;
		
		setLayout();
		findView ();
		initDotView();
		setPargerAdapter();
		tvCatName.setText( catName );
	}
	
	@Override
	public void onNewIntent (Intent intent) {
		 super.onNewIntent(intent);
		 
		 if ( intent != null ){
			 Log.d ("newIntent", "intent != null");
			 Bundle bundle = intent.getExtras();
			 if ( bundle != null ){
				 Log.d ("newIntent", "bundle != null");
				 newsList = bundle.getParcelableArrayList("newsList");
				 catName = bundle.getString("catName");
				 Log.d ("newIntent", "newsList != null: " 
						 + String.valueOf( newsList == null ));
			 }
		 }
	}
	
	public void setLayout(){
		mNewsSurvayContentLayout = new NewsSurvayContentLayout ( this );
		setContentView (mNewsSurvayContentLayout);
	}
	
	private void findView (){
		tvCatName = mNewsSurvayContentLayout.tvCatName;
		mDotView = mNewsSurvayContentLayout.mDotView;
		mViewPager = mNewsSurvayContentLayout.mViewPager;
	}
	
	private void initDotView(){
		
		if ( newsList != null && !newsList.isEmpty() ){
			mDotView.setDotNum( newsList.size() );
			mDotView.setDotPosition( 0 );
		}
		
		 
		
	}
	
	private void setPargerAdapter(){
		
		mNewsSurvayContentAdapter = new NewsSurvayContentAdapter (this, newsList );
		mViewPager.setAdapter(mNewsSurvayContentAdapter);
		mViewPager.setOnPageChangeListener( new OnPageChangeListener(){

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageSelected(int position ) {
				// TODO Auto-generated method stub
				mDotView.setDotPosition( position );
			}
			
		});
	}
	
}
