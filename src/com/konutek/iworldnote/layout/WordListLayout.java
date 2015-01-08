package com.konutek.iworldnote.layout;


import android.content.Context;
import android.widget.ImageView;
import android.widget.ListView;

import com.james.views.FreeLayout;
import com.konutek.iworldnote.R;
import com.konutek.iworldnote.view.ChipsMultiAutoCompleteTextview;

public class WordListLayout extends FreeLayout{

	
	public FreeLayout inputLayout;
	public ChipsMultiAutoCompleteTextview mChipsMultiAutoCompleteTextview;
	public ImageView ivMic;
	
	public FreeLayout mWordListLayout;
	public ListView mWordListView;
	
	public WordListLayout ( Context context ){
		super(context);
		this.setFreeLayoutFF();
		this.setPicSize(640, 960, TO_WIDTH );
		
		
		inputLayout = (FreeLayout) this.addFreeView( 
				new FreeLayout ( context ), 600, 80, new int []{CENTER_HORIZONTAL} );
		setMargin ( inputLayout, 0,20,0,0 );
		
		
		mChipsMultiAutoCompleteTextview = 
				(ChipsMultiAutoCompleteTextview)inputLayout.addFreeView( 
				new ChipsMultiAutoCompleteTextview ( context ),
				490, 70, new int []{ ALIGN_PARENT_LEFT, CENTER_VERTICAL } );
		setMargin ( mChipsMultiAutoCompleteTextview, 10,0,0,0 );
		
		ivMic = (ImageView) inputLayout.addFreeView( 
				new ImageView ( context ),
				70, 70,
				mChipsMultiAutoCompleteTextview,
				new int []{ RIGHT_OF, CENTER_VERTICAL } );
		setMargin ( ivMic, 10,0,0,0 );
		ivMic.setBackgroundResource( R.drawable.mic );
		
		mWordListLayout = (FreeLayout )this.addFreeView( 
				new FreeLayout( context ), 600, 840, 
				inputLayout, new int []{BELOW, CENTER_HORIZONTAL} );
		setMargin ( mWordListLayout, 0,20,0,0 );
		
		mWordListView = (ListView)mWordListLayout.addFreeView( 
				new ListView( context ), 
				580 , LayoutParams.WRAP_CONTENT, 
				new int []{ CENTER_HORIZONTAL} );
		
		mWordListView.setId(  R.id.wordListView );
	}
}
