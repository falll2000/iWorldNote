package com.konutek.iworldnote.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;

import com.konutek.iworldnote.data.NewsData;
import com.konutek.iworldnote.layout.NewsSurvayPagerLayout;
import com.konutek.iworldnote.util.ImageLoaderUtil;

public class NewsSurvayContentAdapter extends PagerAdapter {
	
	private Context mContext;
	private ArrayList<NewsData> newsList; 
	private ImageLoaderUtil mImageLoader;
	public NewsSurvayContentAdapter(Context context, ArrayList<NewsData> arrayList) {
		
		// TODO Auto-generated constructor stub
		mContext = context;
		newsList = arrayList;
		
		if ( mImageLoader == null ){
			mImageLoader = new ImageLoaderUtil ( context );
		}
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return newsList.size();
	}
	
	@Override
	public Object instantiateItem(ViewGroup view, int position) {
		NewsSurvayPagerLayout mPagerLayout = new NewsSurvayPagerLayout( mContext );
		
		NewsData newsData = newsList.get( position );
		mPagerLayout.tvNewsEnTitle.setText( newsData.newsEnTitle );
		mPagerLayout.tvNewsEnContent.setText( newsData.newsEnContent );
		mPagerLayout.tvNewsChTitle.setText( newsData.newsChTitle );
		mPagerLayout.tvNewsChContent.setText( newsData.newsChContent );
		mImageLoader.displayUrlImage( newsData.newsPic , mPagerLayout.ivNewsPic );
		((ViewPager) view).addView( mPagerLayout );
		
		return mPagerLayout;
		
	}
	
	
	
	@Override
	public boolean isViewFromObject(View view, Object object ) {
		// TODO Auto-generated method stub
		return view.equals(object);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}

	@Override
	public void finishUpdate(View container) {
	}

}
