package com.konutek.iworldnote.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.GridView;

import com.james.views.FreeLayout;
import com.james.views.FreeTextButton;
import com.james.views.FreeTextView;
import com.konutek.iworldnote.R;
import com.konutek.iworldnote.util.DpPxHelper;

public class WordTestLayout  extends FreeLayout{

	
	public FreeLayout topbarLayout;
	public FreeTextView tvTopbar;
	public FreeTextButton btnTest;
	public FreeLayout contentLayout;
	public GridView testWordGridView;
	public FreeLayout emptyLayout;
	
	public WordTestLayout ( Context context ){
		super(context);
		this.setFreeLayoutFF();
		this.setPicSize(640, 960, TO_WIDTH );
		
		
		topbarLayout = (FreeLayout) this.addFreeView( 
				new FreeLayout ( context ), 600, 80, 
				new int []{ALIGN_PARENT_TOP, CENTER_HORIZONTAL} );
		setMargin ( topbarLayout, 20,0,0,0 );
		
		
		tvTopbar = (FreeTextView) topbarLayout.addFreeView( 
				new FreeTextView ( context ),
				510, LayoutParams.MATCH_PARENT,
				new int []{ ALIGN_PARENT_LEFT } );
		
		tvTopbar.setGravity( Gravity.CENTER_VERTICAL );
		tvTopbar.setBackgroundColor( Color.WHITE );
		tvTopbar.setText( context.getString( R.string.test_title ));
		
		
		btnTest = (FreeTextButton )topbarLayout.addFreeView( 
				new FreeTextButton( context ), 70, 70, 
				tvTopbar, new int []{RIGHT_OF, CENTER_VERTICAL} );
		setMargin ( btnTest, 10,0,0,0 );
		btnTest.setBackgroundColor( Color.GRAY );
		btnTest.setText( context.getString( R.string.test_btn_test ));
		btnTest.setTextSizeFitSp( 22 );
		
		contentLayout = (FreeLayout) this.addFreeView( 
				new FreeLayout ( context ), 
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 
				topbarLayout, new int []{BELOW} );
		setMargin ( contentLayout, 0,20,0,0 );
		
		emptyLayout = (FreeLayout) contentLayout.addFreeView( 
				new FreeLayout ( context ), LayoutParams.MATCH_PARENT, 20, 
				new int []{ALIGN_PARENT_BOTTOM} );
		
		testWordGridView = (GridView) contentLayout.addFreeView( 
				new GridView( context ), 
				600 , LayoutParams.WRAP_CONTENT, 
				emptyLayout, new int []{ ABOVE, ALIGN_PARENT_TOP, CENTER_HORIZONTAL } );
		testWordGridView.setBackgroundColor( Color.GREEN );
		testWordGridView.setId(  R.id.testWordGridView );
		testWordGridView.setHorizontalSpacing( DpPxHelper.Dp2Px(10, context) );
		testWordGridView.setVerticalSpacing( DpPxHelper.Dp2Px(10, context) );
		testWordGridView.setNumColumns( 3 );
		testWordGridView.setColumnWidth( DpPxHelper.Dp2Px(193, context));
		
		
		
		
	}
}