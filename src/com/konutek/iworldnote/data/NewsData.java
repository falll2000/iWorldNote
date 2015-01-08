package com.konutek.iworldnote.data;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsData implements Parcelable {
	
	public String newsId;
	public String newsPic;
	public String newsEnTitle;
	public String newsEnContent;
	public String newsChTitle;
	public String newsChContent;
	public long newsTime;
	public int watchTimes;		//	觀看次數
	public int likeTimes;		//	按讚次數
	public String[] keyWords;

	
	// Parcelling part
    
    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    	dest.writeString( newsId );
    	dest.writeString( newsPic );
    	dest.writeString( newsEnTitle );
    	dest.writeString( newsEnContent );
    	dest.writeString( newsChTitle );
    	dest.writeString( newsChContent );
    	dest.writeLong( newsTime  );
    	dest.writeInt( watchTimes  );
    	dest.writeInt( likeTimes );
    	dest.writeStringArray( keyWords );
    	
    }
    
    public static final Parcelable.Creator<NewsData> CREATOR = new Parcelable.Creator<NewsData>() {
        public NewsData createFromParcel(Parcel in) {
        	
        	NewsData mNewsData = new NewsData();
        	mNewsData.newsId = in.readString();
        	mNewsData.newsPic = in.readString();
        	mNewsData.newsEnTitle = in.readString();
            mNewsData.newsEnContent = in.readString();
            mNewsData.newsChTitle = in.readString();
            mNewsData.newsChContent = in.readString();
            mNewsData.newsTime = in.readLong();
        	mNewsData.watchTimes = in.readInt();
        	mNewsData.likeTimes = in.readInt();
        	mNewsData.keyWords = in.createStringArray();
        	return mNewsData; 
        }

        public NewsData[] newArray(int size) {
            return new NewsData[size];
        }
    };

}
