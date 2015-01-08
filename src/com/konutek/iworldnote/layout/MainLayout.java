package com.konutek.iworldnote.layout;


import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;

import com.james.views.FreeLayout;
import com.james.views.FreeTextButton;
import com.james.views.FreeTextView;
import com.konutek.iworldnote.R;

public class MainLayout extends FreeLayout {
	
	
	public FreeTextView tvTitle;
	
	public FreeLayout logoLayout;
	public ImageView ivLogo ;
	public FreeLayout controlLayout;
	public FreeTextButton btnNewsSurvay;
	public FreeTextButton btnMyWordNote;
	public FreeTextButton btnWordTest;
	public FreeTextButton btnTradeCenter;
	
	public MainLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		
		tvTitle = (FreeTextView)this.addFreeView( 
				new FreeTextView (context), 
				LayoutParams.MATCH_PARENT, 80 );
		
		tvTitle.setGravity( Gravity.CENTER );
		tvTitle.setText( R.string.main_title );
		tvTitle.setTextSizeFitSp( 30 );
		tvTitle.setTextColor( Color.BLUE );
		
		
		controlLayout = (FreeLayout)this.addFreeView( 
				new FreeLayout (context), 
				550, 480, 
				new int []{CENTER_HORIZONTAL, ALIGN_PARENT_BOTTOM} );
		controlLayout.setBackgroundColor( Color.GREEN );
		
		logoLayout = (FreeLayout)this.addFreeView( 
				new FreeLayout (context), 
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				tvTitle, new int []{BELOW}, 
				controlLayout, new int []{ABOVE} );
		setMargin (logoLayout, 0, 0, 0, 40 );
		logoLayout.setBackgroundColor( Color.YELLOW );
		
//		FIXME: Logo 圖片。圖片暫定 450 * 300 下間隔為 40
		ivLogo = (ImageView )logoLayout.addFreeView( 
				new ImageView (context), 
				450, 300, new int []{CENTER_IN_PARENT} );
		ivLogo.setBackgroundColor( Color.GRAY );
		
		
		btnNewsSurvay = (FreeTextButton) controlLayout.addFreeView( 
				new FreeTextButton( context ), 245, 210, 
				new int []{ALIGN_PARENT_TOP, ALIGN_PARENT_LEFT});
		setMargin (btnNewsSurvay, 20, 20, 0, 0 );
		btnNewsSurvay.setText(context.getString( R.string.main_btn_news_survay ));
		
		btnWordTest = (FreeTextButton) controlLayout.addFreeView( 
				new FreeTextButton( context ), 245, 210, 
				new int []{ALIGN_PARENT_BOTTOM, ALIGN_PARENT_LEFT});
		setMargin (btnWordTest, 20, 0, 0, 20 );
		btnWordTest.setText( context.getString( R.string.main_btn_word_test ));

		btnMyWordNote = (FreeTextButton) controlLayout.addFreeView( 
				new FreeTextButton( context ), 245, 210, 
				new int []{ALIGN_PARENT_TOP, ALIGN_PARENT_RIGHT});
		setMargin (btnMyWordNote, 0, 20, 20, 0 );
		btnMyWordNote.setText( context.getString(  R.string.main_btn_my_wordnote ) );
		
		btnTradeCenter = (FreeTextButton) controlLayout.addFreeView( 
				new FreeTextButton( context ), 245, 210, 
				new int []{ALIGN_PARENT_BOTTOM, ALIGN_PARENT_RIGHT});
		setMargin (btnTradeCenter, 0, 0, 20, 20);
		btnTradeCenter.setText(context.getString(R.string.main_btn_trade_center ) );
		
		
		
	}

}
