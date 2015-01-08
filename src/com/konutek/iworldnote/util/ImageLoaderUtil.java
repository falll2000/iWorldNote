package com.konutek.iworldnote.util;

import java.io.File;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class ImageLoaderUtil {
	
	private String TAG = "ImgLoader_NewVer";
	private Context mContext;
	private ImageLoaderConfiguration config;
	private ImageLoader imageLoader;
	private DisplayImageOptions options;
	
	public ImageLoaderUtil(Context context){
		mContext = context;
		
		setImageLoaderConfiguration();
		imageLoader = ImageLoader.getInstance();
		imageLoader.init(config);
	}
	
	public ImageLoader getLoader(){
		if(imageLoader == null){
			imageLoader = ImageLoader.getInstance();
			imageLoader.init(config);
		} 
		return this.imageLoader;
	}
	
	private void setImageLoaderConfiguration() {
		
		File cacheDir = StorageUtils.getCacheDirectory(mContext);
		
		options = new DisplayImageOptions.Builder()//.showStubImage(R.drawable.login_setprofile_female_default)
		       	//.showImageForEmptyUri(R.drawable.login_setprofile_female_default)
		        //.showImageOnFail(R.drawable.login_setprofile_female_default)
		        .resetViewBeforeLoading(false)  // default
		        .delayBeforeLoading(500) // 1000
		        .cacheInMemory(true) // default false
		        .cacheOnDisc(true) // default false
		        .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default    
		        .displayer(new SimpleBitmapDisplayer()) // default
		        .bitmapConfig(Bitmap.Config.RGB_565)
		        .handler(new Handler())
//		        .displayer(new FadeInBitmapDisplayer(1000))
		        .build();
		
		
		
		config = new ImageLoaderConfiguration.Builder(mContext)
			.memoryCacheExtraOptions(640, 375) // default = device screen dimensions 480 800
			//.discCacheExtraOptions(500, 375, CompressFormat.JPEG, 90, null)
			.threadPoolSize(5) // default
			.threadPriority(Thread.NORM_PRIORITY - 1) // default
			.tasksProcessingOrder(QueueProcessingType.FIFO) // default
			.denyCacheImageMultipleSizesInMemory()
			.memoryCache(new LruMemoryCache(16 * 1024 * 1024)) //8
			.memoryCacheSize(16 * 1024 * 1024)
			.memoryCacheSizePercentage(13) // default 13
			.discCache(new UnlimitedDiscCache(cacheDir)) // default
			.discCacheSize(100 * 1024 * 1024)//
			.discCacheFileCount(200)
			.discCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
			.imageDownloader(new BaseImageDownloader(mContext)) // default
			.defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
			.writeDebugLogs()
//			.imageDownloader(new HttpClientImageDownloader(mContext,
//					new DefaultHttpClient(manager, params))) // connectTimeout (5 s), readTimeout (20 s)
			.defaultDisplayImageOptions(options).build();
		
	} // setImageLoaderConfiguration()
	
	public void displayUrlImage ( String url, ImageView ivPic ){
		
		imageLoader.displayImage( url, ivPic);
		
	}
	

	
	
}
