package com.konutek.iworldnote.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;

import com.konutek.iworldnote.R;

public class BaseActivity extends ActionBarActivity{
	
	@Override
	public void onCreate ( Bundle savedInstanceState ){
		super.onCreate(savedInstanceState);
		onNewIntent ( this.getIntent() );
	}
	
	@Override  
    public void onSaveInstanceState(Bundle outState) {  
        super.onSaveInstanceState(outState); 
    }  
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	

	@Override
	protected void onPause() {
		super.onPause();
	}

	
	@Override
	protected void onStart() {
		super.onStart();
		
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
	}
	

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("BaseActivity", "onActivityResult");
          
    }
	
	/**
	 * changeActivity 
	 * @param: from(Context): 現在頁面的 Context
	 * @param: toClass(Class<?>): 要去的頁面
	 * @param: bundle( Bundle ): 要帶的參數  不帶可送 null
	 * @param: flags ( int [] ): 要加的 Intent Flags 全裝在 flag 陣列，若無可設定為　null 
	 * **/
	public void changeActivity ( Context from, Class<?> toClass,
								Bundle bundle, int flags[], boolean isFinish ){
		
		Intent intent = new Intent ( from, toClass ) ;
		
		if  ( bundle != null ){
			intent.putExtras( bundle );
		}
		
		if ( flags != null ){
			for ( int i=0 ;i<flags.length;i++ ){
				intent.setFlags( flags[i] );
			}
			flags = null;
		}
		startActivity ( intent );
		
		if ( isFinish == true && from != null ){
			((Activity)from).finish();
		}
	}
	
	
	/**
	 * onNewIntent()
	 * getBundle 寫在這
	 * */
	@Override
	public void onNewIntent (Intent intent) {
		 super.onNewIntent(intent);
		 if(intent != null){
			 this.setIntent(intent);
		 }
		 //getBundle 寫在這
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
