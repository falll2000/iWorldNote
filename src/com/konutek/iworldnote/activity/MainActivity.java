package com.konutek.iworldnote.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.james.views.FreeTextButton;
import com.konutek.iworldnote.layout.MainLayout;

public class MainActivity extends BaseActivity implements OnClickListener{
	
	private MainLayout mMainLayout;

	private FreeTextButton btnNewsSurvay;
	private FreeTextButton btnMyWordNote;
	private FreeTextButton btnWordTest;
	private FreeTextButton btnTradeCenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setLayout();
		findView ();
		setOnClick();
	}
	
	public void setLayout(){
		mMainLayout = new MainLayout ( this );
		setContentView ( mMainLayout ); 
	}
	
	private void findView (){
		
		btnNewsSurvay	 = mMainLayout.btnNewsSurvay;
		btnMyWordNote	 = mMainLayout.btnMyWordNote;
		btnWordTest		 = mMainLayout.btnWordTest;
		btnTradeCenter	 = mMainLayout.btnTradeCenter;
		
	}
	
	private void setOnClick() {
		btnNewsSurvay.setOnClickListener( this );	
		btnMyWordNote.setOnClickListener( this );
		btnWordTest.setOnClickListener( this );
		btnTradeCenter.setOnClickListener( this );
	}
	
	@Override
	public void onClick ( View v ){
		
		if ( v.equals( btnMyWordNote )){
			changeActivity ( this, WordListActivity.class, null, null, false );
		} else if ( v.equals(btnNewsSurvay )){
			changeActivity ( this, NewsSurvayActivity.class, null, null, false );
			
		} else if ( v.equals(btnWordTest )){
			changeActivity ( this, WordTestActivity.class, null, null, false );
		} else if ( v.equals(btnTradeCenter )){
			
		} 
	}
	

}
