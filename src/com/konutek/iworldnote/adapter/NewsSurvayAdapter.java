package com.konutek.iworldnote.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.view.Gravity;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;

import com.james.views.FreeAdapter;
import com.konutek.iworldnote.R;
import com.konutek.iworldnote.data.NewsData;
import com.konutek.iworldnote.item.NewsItem;
import com.konutek.iworldnote.util.AqImageLoader;
import com.konutek.iworldnote.util.ImageLoaderUtil;

public class NewsSurvayAdapter extends FreeAdapter<NewsData, NewsItem > {

	private Context mContext;
	private ArrayList<NewsData> newsSurvayList;
	private AqImageLoader mAqImageLoader;
	private ImageLoaderUtil mImageLoader;
	public NewsSurvayAdapter(Context context, ArrayList<NewsData> arrayList) {
		super(context, arrayList);
		// TODO Auto-generated constructor stub
		mContext = context;
		newsSurvayList = arrayList;
		
//		if ( mAqImageLoader == null ){
//			mAqImageLoader = new AqImageLoader ( context );
//		}
		
		if ( mImageLoader == null ){
			mImageLoader = new ImageLoaderUtil ( context );
		}
	}

	@Override
	public NewsItem initView(int position) {
		// TODO Auto-generated method stub
		
		NewsItem newsItem = new NewsItem( mContext );
		GridView.LayoutParams params = 
				new GridView.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
		newsItem.setLayoutParams( params );
		newsItem.setGravity( Gravity.CENTER );
		
		return newsItem;
	}

	@Override
	public void setView(int position, NewsItem newsItem) {
		// TODO Auto-generated method stub
		NewsData data = getItem ( position );
		newsItem.tvTitle.setText( data.newsEnTitle );
		newsItem.tvLikeTimes.setText( String.valueOf( data.likeTimes ));
		newsItem.tvWatchTimes.setText( String.valueOf(data.watchTimes ));
		newsItem.tvNewsDate.setText( getTvNewsDate( data.newsTime ) );
		
		
		String keywords [] = data.keyWords;
		String temp = "";
		if ( keywords != null ){
			for ( int i=0;i< keywords.length;i ++ ){
				if ( i == 0 ){
					temp = mContext.getString( R.string.news_survay_keyword_title ) + keywords[i];
					
				} else {
					temp = temp + ", " + keywords[i];
				}
			}
			newsItem.tvKeywords.setText( temp );
		}
		
//		mAqImageLoader.loadUrlImage(
//				data.newsPic,
//				newsItem.ivNewsPic,
//				mContext,
//				true,
//				true, 
//				false);
		mImageLoader.displayUrlImage(data.newsPic, newsItem.ivNewsPic);;
		
	}
	
	public String getTvNewsDate( long newsTime){
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
		return sdf.format( new Date( newsTime ) ) ;
		
		
		
	}
	

}
