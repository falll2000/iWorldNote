package com.konutek.iworldnote.activity;

import android.content.Intent;
import android.os.Bundle;

public class WellComeActivity extends BaseActivity {

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setLayout();
		gotoMainPage ();
	}
	
	public void setLayout(){
		
	}
	
	public void gotoMainPage (){
		changeActivity( WellComeActivity.this, MainActivity.class,
				null, null, true );
	}


}
