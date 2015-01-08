package com.konutek.iworldnote.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import com.james.views.FreeLayout;
import com.james.views.FreeTextButton;
import com.konutek.iworldnote.layout.ChoiceAnswerViewLayout;
import com.konutek.iworldnote.layout.QuestionLayout;

public class QuestionActivity extends BaseActivity implements OnClickListener{
	
	private QuestionLayout mQuestionLayout;
	public static final int NUM = 300;

	
	public FreeTextButton btnPrevWord;
	public FreeTextButton btnNextWord;
	public FreeLayout answerChoiceLayout;
	public int choiceItemNum = 4;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setLayout();
		findView ();
		setOnClick();
		
		mQuestionLayout.getViewTreeObserver().addOnGlobalLayoutListener( new OnGlobalLayoutListener(){

			@Override
			public void onGlobalLayout() {
				// TODO Auto-generated method stub
				
				
				answerChoiceLayout.addFreeView( 
						new ChoiceAnswerViewLayout( QuestionActivity.this, 865,  NUM), 
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				
//				865
//				int height = answerChoiceLayout.getHeight();
//				Log.d("item", "OnGlobalLayoutListener: " + String.valueOf( height ) );
//				
//				LayoutParams param = new LayoutParams (
//						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//				ChoiceAnswerViewLayout mChoiceAnswerViewLayout=
//						new ChoiceAnswerViewLayout(QuestionActivity.this, height, NUM ) ;
//				mChoiceAnswerViewLayout.setLayoutParams( param );
//				answerChoiceLayout.addView( mChoiceAnswerViewLayout);
//				answerChoiceLayout.invalidate();	
			}
			
		});
		
		
	}
	
	public void setLayout(){
		mQuestionLayout = new QuestionLayout ( this, choiceItemNum );
		setContentView ( mQuestionLayout ); 
	}
	
	private void findView (){
		
		btnPrevWord	 = mQuestionLayout.btnPrevWord;
		btnNextWord	 = mQuestionLayout.btnNextWord;
		answerChoiceLayout = mQuestionLayout.answerChoiceLayout;
	}
	
	private void setOnClick() {
		btnPrevWord.setOnClickListener( this );	
		btnNextWord.setOnClickListener( this );	
	}
	
	
	
	@Override
	public void onClick ( View v ){
		
		if ( v.equals( btnPrevWord )){
			
		} else if ( v.equals( btnNextWord )){
			
		} 
	}
	

}
