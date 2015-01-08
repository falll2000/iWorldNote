package com.konutek.iworldnote.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.james.utils.MonitorUtils;
import com.konutek.iworldnote.R;

public class DotView extends LinearLayout{
	int currentPosition;
	
	public DotView(Context context) {
		super(context);
	}

	public void setDotNum(int dotNum){
		removeAllViews();
		for(int i=0; i<dotNum; i++){
			int width = MonitorUtils.resizeByMonitor(getContext(), 7);
			int height = MonitorUtils.resizeByMonitor(getContext(), 7);
			ImageView dotImage = new ImageView(getContext());
			dotImage.setLayoutParams(new LinearLayout.LayoutParams(width, height));
			if(i == 0) dotImage.setBackgroundResource(R.drawable.dot_red);
			else dotImage.setBackgroundResource(R.drawable.dot_gray);
			((LinearLayout.LayoutParams)dotImage.getLayoutParams()).setMargins(5, 0, 5, 0);
			addView(dotImage);
		}
	}
	
	public void setDotPosition(int position){
		setDotPosition(position, -1, null);
	}
	
	public void setDotPosition(int position, int delayTime){
		setDotPosition(position, delayTime, null);
	}
	
	public void setDotPosition(int position, int delayTime, final Runnable callBackRunnable){
		if(currentPosition == position) return;
		if(delayTime == -1) delayTime = 350;
		
		currentPosition = position;
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				
				if ( getChildAt(currentPosition) != null ){
					for(int i=0; i<getChildCount(); i++){
						getChildAt(i).setBackgroundResource(R.drawable.dot_gray);
					}
					getChildAt(currentPosition).setBackgroundResource(R.drawable.dot_red);
					//
					if(callBackRunnable != null){
						((Activity)getContext()).runOnUiThread(callBackRunnable);	
					}

				}
					
			}
		}, delayTime);
	}

	public int getDotPosition(){
		return currentPosition;
	}
}
