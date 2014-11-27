package com.konutek.iworldnote.layout;

import android.content.Context;
import android.widget.ListView;

import com.james.views.FreeLayout;
import com.konutek.iworldnote.view.ChipsMultiAutoCompleteTextview;

public class WordListLayout extends FreeLayout{

	
	public FreeLayout inputLayout;
	public ChipsMultiAutoCompleteTextview mChipsMultiAutoCompleteTextview;
	public FreeLayout mWordListLayout;
	public ListView mWordListView;
	
	public WordListLayout ( Context context ){
		super(context);
		this.setFreeLayoutFF();
		this.setPicSize(640, 960, TO_WIDTH );
		
		
		inputLayout = (FreeLayout) this.addFreeView( 
				new FreeLayout ( context ), 600, 80 );
		setMargin ( inputLayout, 0,20,0,0 );
		
		
		mChipsMultiAutoCompleteTextview = 
				(ChipsMultiAutoCompleteTextview)inputLayout.addFreeView( 
				new ChipsMultiAutoCompleteTextview ( context ),
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		mWordListLayout = (FreeLayout )this.addFreeView( 
				new FreeLayout( context ), 600, 840, 
				inputLayout, new int []{BELOW} );
		setMargin ( mWordListLayout, 0,20,0,0 );
		
		mWordListView = (ListView)mWordListLayout.addFreeView( 
				new ListView( context ), 
				LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT );
	}
}
