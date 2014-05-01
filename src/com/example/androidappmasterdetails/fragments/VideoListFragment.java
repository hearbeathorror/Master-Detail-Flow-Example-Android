package com.example.androidappmasterdetails.fragments;

import java.util.List;

import com.example.androidappmasterdetails.R;
import com.example.androidappmasterdetails.adapters.VideoAdapter;
import com.example.androidappmasterdetails.dummy.StaticDataManager;
import com.example.androidappmasterdetails.dummy.Video;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class VideoListFragment extends Fragment{
	private View mView;
	private ListView mLstViewVideos;
	private VideoAdapter mVideoAdapter;
	private int position;
	private List<Video> mVideos;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.video_list_fragment, container, false);
		mLstViewVideos = (ListView)mView.findViewById(R.id.list_view_videos);
		
		if(savedInstanceState != null) {
			position = Integer.parseInt(savedInstanceState.getString("position"));
		}
		
		mVideos = StaticDataManager.mLstDumyDatas.get(position).getVideoList();
		mVideoAdapter = new VideoAdapter(getActivity(), R.layout.individual_video_row, mVideos);
		mLstViewVideos.setAdapter(mVideoAdapter);
		return mView;
	}
}
