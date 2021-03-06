package com.example.androidappmasterdetails.activities;

import java.util.List;

import com.example.androidappmasterdetails.R;
import com.example.androidappmasterdetails.adapters.DummyDataAdapter;
import com.example.androidappmasterdetails.dummy.DummyData;
import com.example.androidappmasterdetails.dummy.StaticDataManager;
import com.example.androidappmasterdetails.fragments.ChannelListFragment;
import com.example.androidappmasterdetails.fragments.VideoListFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ExpandableListView;

public class MainActivity extends FragmentActivity {
	private static boolean mTwoPane;
	private DummyDataAdapter mDummyDataAdapter;
	private List<DummyData> mDummyDataList;
	private ExpandableListView mExpandableListView;
	private final String TAG = this.getClass().getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(findViewById(R.id.realContent) != null) {
			mTwoPane = true;
			
			// item should be selected
			((ChannelListFragment) getSupportFragmentManager().findFragmentById(
					R.id.item_list)).setActivateOnItemClick(true);
		}else {
			// expandable list view code here
			mDummyDataList = StaticDataManager.mLstDumyDatas;
			mExpandableListView = (ExpandableListView)findViewById(android.R.id.list);
			mDummyDataAdapter = new DummyDataAdapter(this, mDummyDataList);
			mExpandableListView.setAdapter(mDummyDataAdapter);
		}
	}
	
	public void performOnItemClick(int position) {
		if(mTwoPane) {
			Log.v(TAG," String.valueOf(position) : " + String.valueOf(position));
			VideoListFragment fragment = VideoListFragment.newInstance(position);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.realContent, fragment).commit();
		}
	}
}
