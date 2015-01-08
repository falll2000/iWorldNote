package com.konutek.iworldnote.layout;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.james.views.FreeLayout;
import com.james.views.FreeTextView;
import com.konutek.iworldnote.R;
import com.konutek.iworldnote.view.DotView;

public class NewsSurvayLayout extends FreeLayout {
	
	public FreeTextView tvTitle;
	public HorizontalScrollView mScrollView;
	public RelativeLayout categoryLayout;
	public GridView mGridView;
	
	public NewsSurvayLayout(Context context) {
		super(context);
		this.setFreeLayoutFF();
		this.setPicSize(640, 960, TO_WIDTH );
		// TODO Auto-generated constructor stub
		
		
		tvTitle = (FreeTextView)this.addFreeView( 
				new FreeTextView (context), 
				LayoutParams.MATCH_PARENT, 80 );
		
		tvTitle.setGravity( Gravity.CENTER );
		tvTitle.setText( R.string.news_survay_title );
		tvTitle.setTextSizeFitSp( 30 );
		tvTitle.setTextColor( Color.BLUE );
		
		mScrollView = (HorizontalScrollView) this.addFreeView(
				new HorizontalScrollView(context),
				LayoutParams.WRAP_CONTENT, 70, tvTitle,
				new int []{BELOW});
		
		mScrollView.setHorizontalScrollBarEnabled( false );
		mScrollView.setVerticalScrollBarEnabled( false );
		mScrollView.setOverScrollMode(HorizontalScrollView.OVER_SCROLL_NEVER);
		mScrollView.setFadingEdgeLength(0);
		setMargin ( mScrollView, 0 , 8 , 0 ,0 );
		
//		主播分類 Layout
		categoryLayout = new RelativeLayout( context );
		mScrollView.addView(categoryLayout);
		
		mGridView = (GridView) this.addFreeView( 
				new GridView( context ), 
				LayoutParams.MATCH_PARENT,  LayoutParams.WRAP_CONTENT, 
				mScrollView, 
				new int []{BELOW });
		mGridView.setColumnWidth( 305 );
		mGridView.setNumColumns( 2 );
		mGridView.setHorizontalSpacing( 7 );
		mGridView.setVerticalSpacing( 7);
		mGridView.setGravity(Gravity.CENTER);
		mGridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
	}


}
