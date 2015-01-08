package com.konutek.iworldnote.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ScrollView;

import com.james.views.FreeLayout;
import com.james.views.FreeTextView;
import com.konutek.iworldnote.R;

/**
 * NewsSurvayContentActivity 內, ViewPager 使用的 View
 * */
public class NewsSurvayPagerLayout extends FreeLayout{

	public ScrollView mScrollView;
	public FreeLayout contentLayout;
	public ImageView ivNewsPic;
	public FreeLayout enContentLayout;
	public FreeLayout chContentLayout;
	public FreeTextView tvNewsEnTitle;
	public FreeTextView tvNewsChTitle;
	public FreeTextView tvNewsEnContent;
	public FreeTextView tvNewsChContent;
	
	public NewsSurvayPagerLayout(Context context) {
		super(context);
		this.setFreeLayoutFW();
		this.setPicSize(640, 960, TO_WIDTH );
		// TODO Auto-generated constructor stub
		
		
		mScrollView = (ScrollView)this.addFreeView( 
				new ScrollView (context), 
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		 
		contentLayout = new FreeLayout ( context );
		mScrollView.addView(contentLayout);
		
		
		ivNewsPic =  (ImageView)contentLayout.addFreeView( 
				new ImageView (context), 
				600, 340, 
				new int []{CENTER_HORIZONTAL, ALIGN_PARENT_TOP} );
		ivNewsPic.setScaleType( ScaleType.CENTER_CROP );
		
		
//		英文新聞Layout
		enContentLayout =  (FreeLayout)contentLayout.addFreeView( 
				new FreeLayout (context), 
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 
				ivNewsPic, new int []{BELOW} );

//		中文新聞Layout
		chContentLayout =  (FreeLayout)contentLayout.addFreeView( 
				new FreeLayout (context), 
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 
				enContentLayout, new int []{BELOW});
		
		//	英文新聞title
		tvNewsEnTitle = (FreeTextView)enContentLayout.addFreeView( 
				new FreeTextView (context), 
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		
		tvNewsEnTitle.setGravity( Gravity.LEFT );
//		tvNewsEnTitle.setText( R.string.news_survay_title );
		tvNewsEnTitle.setTextSizeFitSp( 26 );
		tvNewsEnTitle.setTextColor( Color.BLACK );
		

//		英文新聞 content
		tvNewsEnContent = (FreeTextView)enContentLayout.addFreeView( 
				new FreeTextView (context), 
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 
				tvNewsEnTitle, new int []{BELOW});
			
		tvNewsEnContent.setGravity( Gravity.LEFT );
//		tvNewsEnContent.setText( R.string.news_survay_title );
		tvNewsEnContent.setTextSizeFitSp( 22 );
		tvNewsEnContent.setTextColor( Color.BLACK );
		
		
		//	中文新聞title
		tvNewsChTitle = (FreeTextView)chContentLayout.addFreeView( 
				new FreeTextView (context), 
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		
		tvNewsChTitle.setGravity( Gravity.LEFT );
//		tvNewsChTitle.setText( R.string.news_survay_title );
		tvNewsChTitle.setTextSizeFitSp( 26 );
		tvNewsChTitle.setTextColor( Color.BLACK );
		
//		中文新聞 content
		tvNewsChContent = (FreeTextView)chContentLayout.addFreeView( 
				new FreeTextView (context), 
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT,
				tvNewsChTitle, new int []{BELOW});
			
		tvNewsChContent.setGravity( Gravity.LEFT );
//		tvNewsChContent.setText( R.string.news_survay_title );
		tvNewsChContent.setTextSizeFitSp( 22 );
		tvNewsChContent.setTextColor( Color.BLACK );
	}
}
