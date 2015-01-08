package com.konutek.iworldnote.util;

import java.util.ArrayList;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.BitmapAjaxCallback;
import com.james.views.FreeLayout;
import com.james.views.FreeTextView;
import com.konutek.iworldnote.R;

public class AqImageLoader {
	
	private 	String 					TAG = "AqImageLoader";
	private		Context 				mContext;
	protected 	AQuery 					aq;
	
	public  AqImageLoader  ( Context mContext ){
		if ( aq == null ){
			newInstance ( mContext );
		}
	}
	
	private void newInstance ( Context act ){
		
		AjaxCallback.setNetworkLimit(8);
		//set the max number of icons (image width <= 50) to be cached in memory, default is 20
		BitmapAjaxCallback.setIconCacheLimit(50);

		//set the max number of images (image width > 50) to be cached in memory, default is 20
		BitmapAjaxCallback.setCacheLimit(50);
		
		aq= new AQuery ( act );
	}
	
	
	public void clearResource (){
		
		aq = null;
		
	}
	
	public AQuery getInstance (){
		return aq;
	}
	
	/***
	 * name: loadLocalImage
	 * @param resId: Local image resource id
	 * @param ivImg: 顯示照片的ImageView
	 * @param act: Activity
	 * @param progressBarEnabled: Load照片時，是否使用 ProgressBar
	 * **/
	public void loadLocalImage ( int resId, ImageView ivImg, Context mContext , boolean progressBarEnabled ){
		
		if ( aq == null ){
			newInstance ( mContext );
		}
		
		if ( ivImg != null ){
			
			ivImg.setImageBitmap( null );

			if ( progressBarEnabled == true ){
				aq.id( ivImg ).progress( new ProgressBar ( mContext )).image( resId );
			} else {
				aq.id( ivImg ).image( resId );
			}
		}
	}
	
	
	
	/***
	 * name: loadUrlImage
	 * @param picUrl: Picture Url 
	 * @param ivImg: 顯示照片的ImageView
	 * @param mContext: Activity
	 * @param progressBarEnabled: Load照片時，是否使用 ProgressBar
	 * @param memCacheEnabled: Load照片時，是否使用memery Cache (image is huge, avoid memory caching)
	 * @param fileCacheEnabled: Load照片時，是否使用file Cache
	 */
	public void loadUrlImage ( String picUrl, ImageView ivImg, Context mContext, 
			boolean progressBarEnabled , boolean memCacheEnabled , boolean fileCacheEnabled){
		
		if ( aq == null ){
			newInstance ( mContext );
		}
		
		
		if ( ivImg != null ){
			
			if ( progressBarEnabled == true ){
				aq.id( ivImg ).progress( new ProgressBar ( mContext )).image( picUrl , memCacheEnabled , fileCacheEnabled );
			} else {
				aq.id( ivImg ).image( picUrl , memCacheEnabled , fileCacheEnabled);
			}
		}	
	}
	
	
	public void loadUrlImageCallBack(String picUrl, ImageView ivImg, Context mContext, 
			boolean progressBarEnabled , boolean memCacheEnabled , boolean fileCacheEnabled){
		
		if ( aq == null ){
			newInstance ( mContext );
		}
		
		aq.id( ivImg ).image( picUrl, false, false, 0, 0, new BitmapAjaxCallback(){
			
			public void callback(String url, ImageView iv, Bitmap bm, AjaxStatus status){
				 iv.setImageBitmap(bm);
			}
		});
	}
}
