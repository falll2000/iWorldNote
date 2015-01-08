package com.konutek.iworldnote.activity;

import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.konutek.iworldnote.adapter.NewsSurvayAdapter;
import com.konutek.iworldnote.data.NewsData;
import com.konutek.iworldnote.layout.NewsSurvayLayout;
import com.konutek.iworldnote.view.LetterSpacingTextView;

public class NewsSurvayActivity extends BaseActivity{

	public NewsSurvayLayout mNewsSurvayLayout;
	
	public HorizontalScrollView mScrollView;
	public ArrayList<String []> categoryArray = null; 
	public RelativeLayout categoryLayout;
	public GridView mGridView;
	
	public ArrayList<NewsData> newsList;				//	設定給adapter 顯示用	
	public ArrayList<ArrayList<NewsData>> newsDataList;	//	各類別 新聞資料
	public NewsSurvayAdapter mNewsSurvayAdapter;
	private LetterSpacingTextView[] catButtons;
	
	public int categoryNewsNum = 4;
	public int fakeNewsNum = 30;
	private String TAG = this.getClass().getCanonicalName();
	public static final int DEFAULT_CAT = 0;
	public int choiceCat = DEFAULT_CAT;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature( Window.FEATURE_NO_TITLE );
		
		setLayout();
		findView ();
		getNewsData();
		setCategoryButton();
		
		setAdapter( choiceCat );
		setGridViewOnClickEvent();
	}
	
	public void setLayout(){
		mNewsSurvayLayout = new NewsSurvayLayout ( this );
		setContentView ( mNewsSurvayLayout ); 
	}
	
	private void findView (){
		
		categoryLayout	= mNewsSurvayLayout.categoryLayout;
		mGridView	 	= mNewsSurvayLayout.mGridView;
		
	}
	
	private void getNewsData (){
		
		if ( categoryArray == null ){
			categoryArray = new ArrayList<String[]>();
		}
		
		if ( newsDataList == null ){
			newsDataList = new ArrayList<ArrayList<NewsData>>();
		}
		
		for ( int i =0;i< categoryNewsNum ; i++ ){
//			新增存放每個類別新聞資料的 ArrayList
			
			
			categoryArray.add( new String[ categoryNewsNum ] ) ;
			newsDataList.add( new ArrayList<NewsData> () );
			
			
			for ( int j =0;j< fakeNewsNum ; j++ ){
				
				NewsData data = new NewsData();
				data.newsTime = Calendar.getInstance().getTimeInMillis();
				
				if ( i == 0 ){
					categoryArray.get(i)[0] = "0";
					categoryArray.get(i)[1] = "Mimicooper";
					data.newsId = String.valueOf( i )+" - "+String.valueOf( j );
					data.newsEnTitle = "Title: AirAsia jet with 162 on board goes missing on way to Singapore.";
//					data.newsEnContent = "Content: " + categoryArray.get(i)[1] + " " +String.valueOf( i );
					data.newsEnContent = "Content: \n" + "(CNN) -- [Breaking news update, posted at 12:51 a.m. ET]" +
								"Before communication was lost with AirAsia Flight 8501, the aircraft requested to deviate from the planned flight route due to weather, the airline said in a statement."+
								"The plane was still under Indonesian air traffic control as it headed toward Singapore." +
								"[Breaking news update, posted at 12:42 a.m. ET]"+
								"Missing AirAsia Flight 8501 is carrying 162 people: 155 passengers, two pilots and five cabin crew members, the airline said in a statement." + 
								"On board are 157 from Indonesia, three South Koreans, one Malaysian and one Singaporean." + 
								"[Original story, posted at 12:25 a.m. ET]"+	
								"The search is on for AirAsia Flight 8501, which lost contact with air traffic control in Indonesia, the airline said Sunday."+
								"Flight QZ 8501 from the Indonesian city of Surabaya to Singapore lost contact with air traffic control at 7:24 a.m. Sunday (7:24 p.m. Saturday ET), AirAsia said";
					data.newsChTitle = "標題： " + categoryArray.get(i)[1] + " " + String.valueOf( i );
					data.newsChContent = "新聞內容: " + categoryArray.get(i)[1] + " " +String.valueOf( i );
					data.newsPic = "http://www.thezimmail.co.zw/wp-content/uploads/2014/06/mini-cooper-hardtop.jpg";
					
				} else if ( i == 1){
					categoryArray.get(i)[0] = "1";
					categoryArray.get(i)[1] = "Toyota";
					data.newsId = String.valueOf( i )+" - "+String.valueOf( j );
					data.newsEnTitle = "Title: " + categoryArray.get(i)[1] + " " + String.valueOf( i );
					data.newsEnContent = "Content: " + categoryArray.get(i)[1] + " " +String.valueOf( i );
					data.newsChTitle = "標題： " + categoryArray.get(i)[1] + " " + String.valueOf( i );
					data.newsChContent = "新聞內容: " + categoryArray.get(i)[1] + " " +String.valueOf( i );
					data.newsPic = "http://www.dvice.com/sites/dvice/files/Toyota%20FCV2.jpg";
				} else if ( i == 2 ){
					categoryArray.get(i)[0] = "2";
					categoryArray.get(i)[1] = "Mazda";
					data.newsId = String.valueOf( i )+" - "+String.valueOf( j );
					data.newsEnTitle = "Title: " + categoryArray.get(i)[1] + " " + String.valueOf( i );
					data.newsEnContent = "Content: " + categoryArray.get(i)[1] + " " +String.valueOf( i );
					data.newsChTitle = "標題： " + categoryArray.get(i)[1] + " " + String.valueOf( i );
					data.newsChContent = "新聞內容: " + categoryArray.get(i)[1] + " " +String.valueOf( i );
					data.newsPic = "http://autoviva.sapo.pt/img/photos/040/mazda_furai_large_34040.jpg";
				} else if ( i == 3 ){
					categoryArray.get(i)[0] = "3";
					categoryArray.get(i)[1] = "Ford";
					data.newsId = String.valueOf( i )+" - "+String.valueOf( j );
					data.newsEnTitle = "Title: " + categoryArray.get(i)[1] + " " + String.valueOf( i );
					data.newsEnContent = "Content: " + categoryArray.get(i)[1] + " " +String.valueOf( i );
					data.newsChTitle = "標題： " + categoryArray.get(i)[1] + " " + String.valueOf( i );
					data.newsChContent = "新聞內容: " + categoryArray.get(i)[1] + " " +String.valueOf( i );
					data.newsPic = "http://www.topcarrating.com/ford/1995-ford-gt90-concept.jpg";
				}  
				
				data.likeTimes = 0;
				data.watchTimes = 0;
				data.keyWords = new String[]{"keyword1","keyword2", "keyword3"};
				newsDataList.get( i ).add(data);
			}
		}
		
		
	}
	
	public void setCategoryButton(){
		
		int layoutIndex = 0;
		
		if ( catButtons == null ){
			catButtons = new LetterSpacingTextView [newsDataList.size()];
		}
		
		 
		int buttonWidth = this.getResources().getDisplayMetrics().widthPixels / 4 ;
		int textSize = categoryLayout.getLayoutParams().height * 5/10 ;
		//Log.d("ddd", "categoryList: " + categoryList.size() );
		LetterSpacingTextView prevButton = null;
		
		for ( String [] cat : categoryArray ){
			
			LetterSpacingTextView mButton = new LetterSpacingTextView ( this );
			RelativeLayout.LayoutParams params 
				= new RelativeLayout.LayoutParams( 
						buttonWidth,LayoutParams.MATCH_PARENT);
			if ( layoutIndex == 0 ){
//				最左邊button屬性
				params.addRule(RelativeLayout.ALIGN_PARENT_LEFT );
			} else {
				params.addRule(RelativeLayout.RIGHT_OF, prevButton.getId());
			}
			mButton.setLetterSpacing ( 5 );
			mButton.setTextColor( Color.rgb(200, 200, 200) );
//			mButton.setTextSize( textSize );
			mButton.setBackgroundColor(Color.TRANSPARENT);
			mButton.setGravity( Gravity.CENTER );
//			取得 package name
			String packangeName = this.getPackageName();
//			取得 resource id  存在 ids.xml內
			int resID = getResources().getIdentifier( "news_button_cat"+ String.valueOf( layoutIndex+1 ) , "id", packangeName );
			//Log.d ( TAG, "resource: Id" + "live_button_cat"+ String.valueOf( layoutIndex+1 ) + ", integer: " + String.valueOf( resID ));
			
			catButtons [layoutIndex] = mButton;
			mButton.setId( resID );
			mButton.setLayoutParams( params );
			categoryLayout.addView( mButton, params );
			
			mButton.setText( cat [ 1 ] );
			mButton.setTag( cat[0] );  //	類別 id 設定到 tag內
			
			
			mButton.setOnClickListener( new newsCategoryClickListener() );
			
			
			mButton.setTextSizeFitPx(textSize);
			
			
//			if (layoutIndex == 0){
//				mButton.setTextColor( Color.rgb(38, 213, 250)  );
//			}
			
			prevButton = mButton;	//	紀錄上一個button  用來作Layout 
			layoutIndex ++ ;
			params = null;
		}
		
		catButtons[choiceCat].setTextColor( Color.rgb(38, 213, 250) );
		
		
	}
	
	private void setAdapter( int choiceCatId ) {
		
		newsList = newsDataList.get( choiceCatId ); 
		
		mNewsSurvayAdapter = new NewsSurvayAdapter(this, newsList);
		mGridView.setAdapter( mNewsSurvayAdapter );
	}
	
	private void setGridViewOnClickEvent(){
		
		mGridView.setOnItemClickListener( new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String cat [] = categoryArray.get( choiceCat );
				Bundle bundle = new Bundle();
				bundle.putParcelableArrayList("newsList", newsList);
				bundle.putString("catName",  cat[1]);
				 
				changeActivity( NewsSurvayActivity.this, 
						NewsSurvayContentActivity.class, 
						bundle, null, false );
			}
		});
		
	}
	
	public class newsCategoryClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String tempIndex  = (String)v.getTag();	
			
			choiceCat = Integer.parseInt( tempIndex );
			//Log.d ("fff", "catButtonResId: " + clickedButtonIndex );
			
			for ( int i=0;i<catButtons.length;i++ ){
				if ( i == choiceCat ){
//					Log.d ("fff", "i == clickedButtonIndex: " + clickedButtonIndex+ ", " +  catButtonResId [ clickedButtonIndex ]);
					catButtons[i].setTextColor( Color.rgb(38, 213, 250) );
				} else {
//					Log.d ("fff", "i != clickedButtonIndex: " + clickedButtonIndex+ ", " +  catButtonResId [ clickedButtonIndex ]);
					catButtons[i].setTextColor( Color.rgb(200, 200, 200) );
				}
			}
					
			setAdapter ( choiceCat ) ;
			Log.d ( TAG, "anchorCategoryClickListener: Id" + (String)v.getTag());
		}
		
	}
}
