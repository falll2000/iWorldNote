package com.konutek.iworldnote.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;

import com.james.views.FreeLayout;
import com.james.views.FreeTextButton;

public class ChoiceAnswerViewLayout extends FreeLayout {
	
	
	FreeTextButton btnChoices[];
	
	public ChoiceAnswerViewLayout(Context context, int parentHeight, int choiceItemNum ) {
		super(context);
		this.setFreeLayoutFF();
		this.setPicSize(640, 960, TO_HEIGHT );
		// TODO Auto-generated constructor stub
		this.setBackgroundColor( Color.YELLOW );
//		選擇提 區域大小
		int choiceItemTotalHeight = (int)(parentHeight* 0.8);
		
		int singleChoiceItemHeight = (int)(choiceItemTotalHeight * 0.9);
		int emptyBetweenItem = (int)(choiceItemTotalHeight * 0.1);
//		其餘區域範圍高度
		int emptyLayoutHeight = (int)(parentHeight * 0.2);
		Log.d("item", "choiceItemTotalHeight: " + String.valueOf( choiceItemTotalHeight ) );
		Log.d("item", "emptyBetweenItem: " + String.valueOf( emptyBetweenItem ) );
		Log.d("item", "emptyLayoutHeight: " + String.valueOf( emptyLayoutHeight ) );
		btnChoices = new FreeTextButton[choiceItemNum];;
		
		
		for ( int i=0;i<choiceItemNum;i++ ){
			
			
			if ( i == 0 ){
				
				btnChoices[i] = (FreeTextButton)this.addFreeView( 
						new FreeTextButton ( context ), 200, 100, 
						new int []{CENTER_HORIZONTAL, ALIGN_PARENT_TOP});
				setMargin (btnChoices[i], 0,25,0,0 );
			} else {
				btnChoices[i] = (FreeTextButton)this.addFreeView( 
						new FreeTextButton ( context ), 200, 100, 
						btnChoices[i-1],
						new int []{BELOW,CENTER_HORIZONTAL });
				setMargin (btnChoices[i], 0,16,0,0 );
			}
			
			
			btnChoices[i].setTextColor( Color.BLACK );
			btnChoices[i].setBackgroundColor( Color.YELLOW );
			btnChoices[i].setText( "答案: " + String.valueOf( i ));
			btnChoices[i].setGravity( Gravity.CENTER );
			
			
//			btnChoices[i] = new Button( context );	
//			btnChoices[i].setTextColor( Color.BLACK );
//			btnChoices[i].setBackgroundColor( Color.YELLOW );
//			btnChoices[i].setText( "答案: " + String.valueOf( i ));
//			btnChoices[i].setGravity( Gravity.CENTER );
//			
//			String packangeName = context.getPackageName();
////			取得 resource id  存在 ids.xml內
//			int resID = getResources().getIdentifier( 
//					"choiceItem"+ String.valueOf( i+1 ) , "id", packangeName );
//			btnChoices[i].setId( resID );
//			
//			LayoutParams params = new LayoutParams ( 200, singleChoiceItemHeight/choiceItemNum );
//			params.addRule( RelativeLayout.CENTER_HORIZONTAL );
//			if ( i == 0 ){
//				
//				params.addRule( RelativeLayout.ALIGN_PARENT_TOP );
//			} else {
//				params.addRule( RelativeLayout.BELOW, btnChoices[i-1].getId() );
//				
//			}
//			btnChoices[i].setLayoutParams(params);
//			this.addView( btnChoices[i]);
//		
//			if ( i == 0 ){
//				btnChoices[i].setPadding(0, emptyLayoutHeight/2, 0, 0);
//			} else {
//				btnChoices[i].setPadding(0, emptyBetweenItem, 0, 0);
//			}
		}
	}
}
