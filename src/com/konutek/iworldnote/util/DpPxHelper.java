package com.konutek.iworldnote.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Window;


public class DpPxHelper {

	public static final String T_WIDTH="T_WIDTH";
	public static final String T_HEIGHT="T_HEIGHT";
	
	public static int Dp2Px ( int dp, Context mContext ){

		float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, //轉換dp值
                dp, //dp值
                mContext.getResources().getDisplayMetrics());

		Log.d ("TAG", "DpPxHelper : px" + px );
		return (int) px;
	}
	
	public static int Px2Sp ( int Sp, Context mContext ){

		float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, //轉換dp值
				Sp, //dp值
                mContext.getResources().getDisplayMetrics());

		Log.d ("TAG", "DpPxHelper : px" + px );
		return (int) px;
	}
	
	public static int getTextSizeFitSp(float spValue, Context mContext )
	{
		int monitorWidth = mContext.getResources().getDisplayMetrics().widthPixels;
	
		float pxValue = spValue * 1.5F * monitorWidth / 640;
		float sp = px2sp(pxValue, mContext );
		return (int)sp;
	}
	
	private static float px2sp(float pxValue, Context mContext )
	{
		float density = mContext.getResources().getDisplayMetrics().scaledDensity;
		return pxValue / density / 1.3F;
	}
//	
	public static int  getStatusBarHeight ( Activity mContext ){
		Rect rectangle= new Rect();
		Window window= mContext.getWindow();
		window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
		int statusBarHeight= rectangle.top;
		int contentViewTop= 
		    window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
		int titleBarHeight = contentViewTop - statusBarHeight;
		Log.i("*** Jorgesys :: ", "StatusBar Height= " + statusBarHeight + " , TitleBar Height = " + titleBarHeight);
		return titleBarHeight;

		    
	}
	
//	public static int GetWidthSuiteDesity( int width, Context context ){
//		DisplayMetrics dm = context.getResources().getDisplayMetrics();
////		float factor = GetBaseWidth ( context ); 
//		width =  (int)(width * ( (float)dm.widthPixels / (float)480 )) ;
//		Log.d ("TAG", "GetPositionSuiteDesity: width: " + width );
//		return width;
//	}
//	
//	public static int GetHeightSuiteDesity( int height, Context context ){
//		DisplayMetrics dm = context.getResources().getDisplayMetrics();
////		float factor =  GetBaseHeight ( context );
//		height =  (int)(height * ( (float)dm.widthPixels / (float)480 )) ;
//		Log.d ("TAG", "GetPositionSuiteDesity: height: " + height);
//		return height;
//	}
	/*
	public static int[] GetWidthHeightSuiteDesity( int length[], String ToWhat, Context context ){
		
		int baseLength[]= GetBaseWidth( context);
		
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		float factor = 0;
		if ( ToWhat.equals( T_WIDTH )){
			factor = ((float)dm.widthPixels / (float)baseLength[0] );
		} else if (ToWhat.equals( T_HEIGHT )){
			factor = ((float)dm.heightPixels / (float)baseLength[1] );
		}	
		
		length[0] =  (int)(length[0] * factor);
		length[1] =  (int)(length[1] * factor);
		Log.d ("TAG", "GetPositionSuiteDesity: width: " + length[0] +", height: " + length[1] );
		return length;
	}
	*/
//	TO_W7IDTH
	public static int TO_WIDTH_FreeLayoutPosition ( int px, Context mContext ){
		
		DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
		
		px = px * ( dm.widthPixels / 640 );
		Log.d ("TAG", "DpPxHelper : px" + px );
		return px;
	}
	
	/*
	public static int[] GetBaseWidth (Context context){
		
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		int [] baseLength = {0,0};
		 
		if ( dm.density == DisplayMetrics.DENSITY_LOW  || 
				dm.density == DisplayMetrics.DENSITY_MEDIUM||
				dm.density == DisplayMetrics.DENSITY_HIGH)  
		{
			baseLength[0] = 480;
			baseLength[1] = 800;
			
		} else if (dm.density == DisplayMetrics.DENSITY_XHIGH){
			
			
			baseLength[0] = 720;
			baseLength[1] = 1280;
			
		} else if (dm.density == DisplayMetrics.DENSITY_XXHIGH){
			
			baseLength[0] = 1080;
			baseLength[1] = 1920;
			
		} else if (dm.density == DisplayMetrics.DENSITY_XXXHIGH){
			
			baseLength[0] = 1080;
			baseLength[1] = 1920;
			
		} 
		
		return baseLength;
	}
	*/
		
}
