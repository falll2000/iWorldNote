package com.konutek.iworldnote.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;

import com.konutek.iworldnote.adapter.WordListAdapter;
import com.konutek.iworldnote.layout.WordListLayout;
import com.konutek.iworldnote.view.ChipsMultiAutoCompleteTextview;

public class WordListActivity extends BaseActivity{
	
	private WordListLayout mWordListLayout;
	
	private ChipsMultiAutoCompleteTextview mChipsMultiAutoCompleteTextview;
	private ListView mWordListView;
	private ArrayList<String> wordList;
	private WordListAdapter mWordListAdapter;
	public static final int WORD_NUM = 100000;
	
	@Override
	public void onCreate( Bundle savedInstanceState ){
		super.onCreate(savedInstanceState);
		setLayout();
		findView();
		getWordList();
		setAdapter ();
	}
	
	
	private void setLayout(){
		mWordListLayout = new WordListLayout( this );
		setContentView ( mWordListLayout );
	}
	
	private void findView(){
		mChipsMultiAutoCompleteTextview = mWordListLayout.mChipsMultiAutoCompleteTextview;
		mWordListView = mWordListLayout.mWordListView;
	}
	
	private void getWordList(){
		
		if ( wordList == null ){
			
			wordList = new ArrayList<String> ();
			for ( int i=0;i< WORD_NUM ; i ++ ){
				wordList.add( String.valueOf( i ));
			}
		}
		setAdapter();
		
		
	}
	
	private void setAdapter (){
//		顯示單字表用
		mWordListAdapter = new WordListAdapter( this, wordList );
		mWordListView.setAdapter( mWordListAdapter );
		
		
//		字串搜尋
		mChipsMultiAutoCompleteTextview.setAdapter(
				new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, wordList));
		mChipsMultiAutoCompleteTextview.setTokenizer(
				new MultiAutoCompleteTextView.CommaTokenizer());
		
		
	}
	
	
}

