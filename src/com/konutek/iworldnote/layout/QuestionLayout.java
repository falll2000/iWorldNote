package com.konutek.iworldnote.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;

import com.james.views.FreeLayout;
import com.james.views.FreeTextButton;
import com.james.views.FreeTextView;
import com.konutek.iworldnote.R;

public class QuestionLayout extends FreeLayout {
	public FreeTextView tvQuestion;
	public FreeLayout controlLayout;
	public FreeLayout answerChoiceLayout;
	public FreeTextButton btnPrevWord;
	public FreeTextButton btnNextWord;
	
	public QuestionLayout(Context context, int choiceItemNum ) {
		super(context);
		this.setFreeLayoutFF();
		this.setPicSize(640, 960, TO_WIDTH );
		// TODO Auto-generated constructor stub
		
		
		tvQuestion = (FreeTextView)this.addFreeView( 
				new FreeTextView (context), 
				600, 250, 
				new int []{ CENTER_HORIZONTAL } );
		tvQuestion.setBackgroundColor( Color.WHITE );
		tvQuestion.setText("偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目偶是題目");
		tvQuestion.setPadding( 15, 0, 0, 0 );
		
		controlLayout = (FreeLayout)this.addFreeView( 
				new FreeLayout (context), 
				300, 160, 
				new int []{ CENTER_HORIZONTAL, ALIGN_PARENT_BOTTOM} );
		controlLayout.setBackgroundColor( Color.GREEN );
		
		
		btnPrevWord = (FreeTextButton)controlLayout.addFreeView( 
				new FreeTextButton( context ), 120, 80, 
				new int []{CENTER_VERTICAL, ALIGN_PARENT_LEFT });
		btnPrevWord.setText( context.getString( R.string.question_btn_prev ));
		btnPrevWord.setBackgroundColor( Color.BLUE  );
		btnPrevWord.setTextSizeFitSp( 30 );
		btnPrevWord.setGravity(Gravity.CENTER);
		
		btnNextWord = (FreeTextButton)controlLayout.addFreeView( 
				new FreeTextButton( context ), 120, 80, 
				new int []{CENTER_VERTICAL, ALIGN_PARENT_RIGHT });
		btnNextWord.setText( context.getString( R.string.question_btn_next ));
		btnNextWord.setBackgroundColor( Color.BLUE  );
		btnNextWord.setTextSizeFitSp( 30 );
		btnNextWord.setGravity(Gravity.CENTER);
		
		answerChoiceLayout = (FreeLayout)this.addFreeView( 
				new FreeLayout (context), 
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 
				controlLayout, new int []{ ABOVE }, 
				tvQuestion, new int []{ BELOW });
		answerChoiceLayout.setBackgroundColor(Color.GRAY );
		
		
		
	}
}
