package com.konutek.iworldnote.layout;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ListView;

import com.james.views.FreeLayout;
import com.konutek.iworldnote.R;
import com.konutek.iworldnote.view.ChipsMultiAutoCompleteTextview;

public class WordInfoLayout extends FreeLayout {
	
	public FreeLayout backgroundLayout;
	
	
	public WordInfoLayout ( Context context ){
		super(context);
		this.setFreeLayoutFF();
		this.setPicSize(640, 960, TO_WIDTH );
		
		
		backgroundLayout = (FreeLayout) this.addFreeView( 
				new FreeLayout ( context ), 600, LayoutParams.MATCH_PARENT,
				new int []{CENTER_HORIZONTAL} );
		setMargin ( backgroundLayout, 0,20,0,0 );
		
		
	}
}
