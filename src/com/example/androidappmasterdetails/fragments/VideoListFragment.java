package com.example.androidappmasterdetails.fragments;

import java.util.List;

import com.example.androidappmasterdetails.R;
import com.example.androidappmasterdetails.adapters.VideoAdapter;
import com.example.androidappmasterdetails.dummy.StaticDataManager;
import com.example.androidappmasterdetails.dummy.Video;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class VideoListFragment extends Fragment implements OnItemClickListener{
	private View mView;
	private ListView mLstViewVideos;
	private VideoAdapter mVideoAdapter;
	private static int position;
	private List<Video> mVideos;
	private static VideoListFragment mVideoListFragment;
	private final String TAG  = this.getClass().getSimpleName();
	
	public static VideoListFragment newInstance(int position) {
		mVideoListFragment = new VideoListFragment();
		
		Bundle args = new Bundle();
	    args.putInt("position", position);
	    mVideoListFragment.setArguments(args);
	    
		return mVideoListFragment;
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.video_list_fragment, container, false);
		mLstViewVideos = (ListView)mView.findViewById(R.id.list_view_videos);
		position = getArguments().getInt("position");
		
		mVideos = StaticDataManager.mLstDumyDatas.get(position).getVideoList();
		mVideoAdapter = new VideoAdapter(getActivity(), R.layout.individual_video_row, mVideos);
		mLstViewVideos.setAdapter(mVideoAdapter);
		mLstViewVideos.setOnItemClickListener(this);
		return mView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		Log.v(TAG, "clicked !!! : position : " + position + "pos : " + pos);
	}
}
