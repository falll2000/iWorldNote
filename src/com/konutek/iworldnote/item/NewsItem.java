package com.konutek.iworldnote.item;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;

import com.james.views.FreeLayout;
import com.james.views.FreeTextView;
import com.konutek.iworldnote.R;

public class NewsItem extends FreeLayout {
	
	
	public FreeLayout backgroundLayout;
	public FreeTextView tvNewsDate;
	public ImageView ivNewsPic;
	public FreeTextView tvTitle;
	public FreeLayout newsLikeInfoLayout;
	public FreeLayout newsWatchInfoLayout;
	
	public FreeTextView tvWatchTimesTitle;
	public FreeTextView tvWatchTimes;
	
	public FreeTextView tvLikeTimesTitle;
	public FreeTextView tvLikeTimes;
	public FreeTextView tvKeywords;
	
	public FreeLayout 	recommandLayout;
	public FreeTextView tvRecommandTitle;
	public FreeTextView tvRecommand;
	
	

	public NewsItem(Context context) {
		super(context);
		this.setFreeLayoutWW();
		this.setPicSize(640, 960, TO_WIDTH );
		// TODO Auto-generated constructor stub
		
		backgroundLayout = (FreeLayout)
				this.addFreeView( 
				new FreeLayout ( context ),
				305, 445, new int []{CENTER_IN_PARENT});
//		TODO 推薦人欄位, 隱藏 height 375, 顯示 445
		
		ivNewsPic = (ImageView)backgroundLayout.addFreeView( 
				new ImageView ( context ), 305, 235, 
				new int []{ALIGN_PARENT_TOP} );
		ivNewsPic.setScaleType( ScaleType.CENTER_CROP );

//		顯示按讚次數，觀看次數
		newsLikeInfoLayout = (FreeLayout)backgroundLayout.addFreeView( 
				new FreeLayout ( context ), 100, 70,
				ivNewsPic, new int []{ ALIGN_BOTTOM, ALIGN_PARENT_RIGHT } );
		newsWatchInfoLayout = (FreeLayout)backgroundLayout.addFreeView( 
				new FreeLayout ( context ), 200, 70, 
				ivNewsPic, new int []{ ALIGN_BOTTOM }, 
				newsLikeInfoLayout, new int []{ LEFT_OF });

		tvLikeTimes = (FreeTextView)newsLikeInfoLayout.addFreeView( 
				new FreeTextView ( context ), 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				new int []{ALIGN_PARENT_RIGHT, ALIGN_PARENT_BOTTOM } ); 
		tvLikeTimes.setTextSizeFitSp( 18 );
		tvLikeTimes.setGravity( Gravity.CENTER_VERTICAL );
		tvLikeTimes.setSingleLine(true);
		tvLikeTimes.setEllipsize( TruncateAt.END );
		setMargin ( tvLikeTimes, 0,0,5,0 );
		
//		按讚次數
		tvLikeTimesTitle = (FreeTextView)newsLikeInfoLayout.addFreeView( 
				new FreeTextView ( context ), 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				tvLikeTimes, new int []{LEFT_OF, ALIGN_PARENT_BOTTOM } ); 
		tvLikeTimesTitle.setText( context.getString( R.string.news_survay_item_like_title ));
		tvLikeTimesTitle.setTextSizeFitSp( 18 );
		tvLikeTimesTitle.setGravity( Gravity.CENTER_VERTICAL );
		tvLikeTimesTitle.setSingleLine(true);
		tvLikeTimesTitle.setEllipsize( TruncateAt.END );
		setMargin ( tvLikeTimes, 0,0,5,0 );
		
		

		tvWatchTimes = (FreeTextView)newsWatchInfoLayout.addFreeView( 
				new FreeTextView ( context ), 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				new int []{ALIGN_PARENT_RIGHT, ALIGN_PARENT_BOTTOM } ); 
		tvWatchTimes.setTextSizeFitSp( 18 );
		tvWatchTimes.setGravity( Gravity.CENTER_VERTICAL );
		tvWatchTimes.setSingleLine(true);
		tvWatchTimes.setEllipsize( TruncateAt.END );
		
//		觀看次數
		tvWatchTimesTitle = (FreeTextView)newsWatchInfoLayout.addFreeView( 
				new FreeTextView ( context ), 
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				tvWatchTimes, new int []{LEFT_OF, ALIGN_PARENT_BOTTOM } ); 
		tvWatchTimesTitle.setText( context.getString( R.string.news_survay_item_view_title ));
		tvWatchTimesTitle.setTextSizeFitSp( 18 );
		tvWatchTimesTitle.setGravity( Gravity.CENTER_VERTICAL );
		tvWatchTimesTitle.setSingleLine(true);
		tvWatchTimesTitle.setEllipsize( TruncateAt.END );
		
		
		
//		新聞標頭
		tvTitle = (FreeTextView)backgroundLayout.addFreeView( 
				new FreeTextView ( context ), 
				LayoutParams.MATCH_PARENT, 70, 
				ivNewsPic, new int []{BELOW} ); 
		
		tvTitle.setTextSizeFitSp( 22 );
		tvTitle.setLines( 2 );
		tvTitle.setEllipsize( TruncateAt.END );
		
//		關鍵字
		tvKeywords  = (FreeTextView)backgroundLayout.addFreeView( 
				new FreeTextView ( context ),
				LayoutParams.MATCH_PARENT, 70, 
				tvTitle, new int []{BELOW} ); 
		tvKeywords.setTextSizeFitSp( 22 );
		tvKeywords.setLines( 2 );
		tvKeywords.setEllipsize( TruncateAt.END );
		tvKeywords.setGravity( Gravity.CENTER_VERTICAL );
		
		
		recommandLayout = (FreeLayout) backgroundLayout.addFreeView(
				new FreeLayout ( context ),
				LayoutParams.MATCH_PARENT, 70, 
				tvKeywords, new int []{BELOW} ); 
		recommandLayout.setVisibility(View.VISIBLE);
//		TODO 隱藏 height 375, 顯示 445
		
		tvRecommandTitle = (FreeTextView)recommandLayout.addFreeView( 
				new FreeTextView ( context ),
				LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 
				new int []{ ALIGN_PARENT_LEFT, ALIGN_PARENT_TOP } ); 
		tvRecommandTitle.setText( context.getString( R.string.news_survay_recommand_title ));
		tvRecommandTitle.setTextSizeFitSp( 18 );
		
		tvRecommand  = (FreeTextView)recommandLayout.addFreeView( 
				new FreeTextView ( context ),
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 
				tvRecommandTitle, new int []{ RIGHT_OF } ); 
		tvRecommand.setTextSizeFitSp( 18 );
		tvRecommand.setLines( 2 );
		tvRecommand.setEllipsize( TruncateAt.END );
		tvRecommand.setGravity( Gravity.LEFT | Gravity.TOP );
		tvRecommand.setText("AAA");
//		tvRecommand.setVisibility( View.GONE );
		
		
		tvNewsDate = (FreeTextView)backgroundLayout.addFreeView(
				new FreeTextView ( context ),
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
				new int []{ALIGN_PARENT_LEFT, ALIGN_PARENT_TOP} ); 
		
	}
	

}
