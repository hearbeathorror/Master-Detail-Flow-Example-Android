package com.example.androidappmasterdetails.dummy;

import java.util.ArrayList;
import java.util.List;

public class StaticDataManager {
	public static StaticDataManager mStaticDataManager = new StaticDataManager();
	public static List<DummyData> mLstDumyDatas;
	private static List<Video> mVideoList;
	
	public StaticDataManager() {
		init();
	}
	
	public List<DummyData> getData() {
		return mLstDumyDatas;	
	}
	
	private void init() {
		mLstDumyDatas = new ArrayList<DummyData>();
		for(int i=0;i<10;i++) {
			DummyData dummyData = new DummyData();
			dummyData.setChannelName("Channel " + (i+1));
			dummyData.setVideoList(getVideoList());
			mLstDumyDatas.add(dummyData);
		}
	}
	
	private List<Video> getVideoList(){
		mVideoList = new ArrayList<Video>();
		
		for(int i=0;i<10;i++) {
			Video video = new Video();
			video.setVideoName("Video " + (i+1));
			video.setVideoDescription("slide the lock widget on the virtual device to proceed. " +
					"On the tablet simulator, the application, " +
					"displays the list of three dummy items on the left and the detail of the selected " +
					"slide the lock widget on the virtual device to proceed. " +
					"On the tablet simulator, the application, " +
					"displays the list of three dummy items on the left and the detail of the selected " +
					"slide the lock widget on the virtual device to proceed. " +
					"On the tablet simulator, the application, " +
					"displays the list of three dummy items on the left and the detail of the selected ");
			mVideoList.add(video);
		}
		
		return mVideoList;
	}
	
}
