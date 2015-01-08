package com.konutek.iworldnote.layout;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.Gravity;

import com.james.views.FreeLayout;
import com.james.views.FreeTextView;
import com.konutek.iworldnote.view.DotView;


/**
 * 顯示新聞內文
 * NewsSurvayContentActivity 的 Layout 檔
 * */
public class NewsSurvayContentLayout extends FreeLayout {
	

	public FreeTextView tvCatName;
	FreeLayout dotViewLayout;
	public DotView mDotView;
	public ViewPager mViewPager;
	
	public NewsSurvayContentLayout(Context context) {
		super(context);
		this.setFreeLayoutFF();
		this.setPicSize(640, 960, TO_WIDTH );
		// TODO Auto-generated constructor stub
		
		
		tvCatName = (FreeTextView)this.addFreeView( 
				new FreeTextView (context), 
				LayoutParams.MATCH_PARENT, 80 );
		
		tvCatName.setGravity( Gravity.CENTER );
//		tvCatName.setText( R.string.news_survay_title );
		tvCatName.setTextSizeFitSp( 30 );
		tvCatName.setTextColor( Color.BLUE );
		
		
		dotViewLayout = (FreeLayout)this.addFreeView( 
				new FreeLayout (context), 
				LayoutParams.MATCH_PARENT, 50, 
				new int []{ALIGN_PARENT_BOTTOM});
		dotViewLayout.setBackgroundColor(Color.YELLOW);
		mDotView = (DotView) dotViewLayout.addFreeView( 
				new DotView (context), 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				new int []{CENTER_IN_PARENT});
		
		mViewPager = (ViewPager)this.addFreeView( 
				new ViewPager (context), 
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				tvCatName, new int []{BELOW},
				dotViewLayout, new int []{ABOVE});
		mViewPager.setBackgroundColor( Color.GREEN );
		
		
	}
}
