package com.konutek.iworldnote.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;

import com.james.views.FreeAdapter;
import com.james.views.FreeTextView;

public class WordListAdapter extends FreeAdapter<String, FreeTextView> {

	private Context mContext;
	private ArrayList<String> wordList;
	
	public WordListAdapter(Context context, ArrayList<String> arrayList) {
		super(context, arrayList);
		// TODO Auto-generated constructor stub
		mContext = context;
		wordList = arrayList;
	}

	@Override
	public FreeTextView initView(int position) {
		// TODO Auto-generated method stub
		
		
		
		FreeTextView mTextView = new FreeTextView( mContext );
		ListView.LayoutParams params = 
				new ListView.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		
		mTextView.setLayoutParams( params );
		
				
		
		return mTextView;
	}

	@Override
	public void setView(int position, FreeTextView tvWordView) {
		// TODO Auto-generated method stub
		String word = getItem ( position );
		tvWordView.setText( word );
	}

}
