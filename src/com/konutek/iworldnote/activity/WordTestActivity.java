package com.konutek.iworldnote.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;

import com.james.views.FreeTextButton;
import com.konutek.iworldnote.adapter.WordTestAdapter;
import com.konutek.iworldnote.layout.WordTestLayout;

public class WordTestActivity extends BaseActivity implements OnClickListener{
	
	private WordTestLayout mWordTestLayout;
	public FreeTextButton btnTest;
	public GridView testWordGridView;
	private WordTestAdapter mWordTestAdapter;
	private ArrayList<String> wordTestList;
	public static final int NUM = 300;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setLayout();
		findView ();
		setOnClick();
		getTestData();
		setAdapter();
	}
	
	public void setLayout(){
		mWordTestLayout = new WordTestLayout ( this );
		setContentView ( mWordTestLayout ); 
	}
	
	private void findView (){
		
		btnTest	 			= mWordTestLayout.btnTest;
		testWordGridView	= mWordTestLayout.testWordGridView;
	}
	
	private void setOnClick() {
		btnTest.setOnClickListener( this );	
	}
	
	
	private void getTestData() {
		
		if ( wordTestList == null ){
			wordTestList = new ArrayList<String>();
		}
		
		for (int i=0;i<NUM;i++ ){
			wordTestList.add(String.valueOf( i ));
		}
		
	}
	
	
	private void setAdapter() {
		
		mWordTestAdapter = new WordTestAdapter( this, wordTestList );
		testWordGridView.setAdapter( mWordTestAdapter );
	}
	
	
	@Override
	public void onClick ( View v ){
		
		if ( v.equals( btnTest )){
			changeActivity ( this, QuestionActivity.class, null, null, false );
			
		} 
	}
	

}
