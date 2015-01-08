package com.konutek.iworldnote.layout;

import android.content.Context;

import com.james.views.FreeLayout;
import com.james.views.FreeTextView;

public class ChoiceAnswerLayout extends FreeLayout {
	public FreeTextView tvQuestion;
	
	
	
	public ChoiceAnswerLayout(Context context, int answerNum ) {
		super(context);
		this.setFreeLayoutWW();
		this.setPicSize(640, 960, TO_WIDTH );
		
		
		
		
	}

}
