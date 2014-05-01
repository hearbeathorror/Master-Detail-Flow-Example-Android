package com.example.androidappmasterdetails.fragments;

import java.util.List;

import com.example.androidappmasterdetails.R;
import com.example.androidappmasterdetails.activities.MainActivity;
import com.example.androidappmasterdetails.adapters.ChannelAdapter;
import com.example.androidappmasterdetails.dummy.DummyData;
import com.example.androidappmasterdetails.dummy.StaticDataManager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ChannelListFragment extends Fragment implements OnItemClickListener {
	private View mView;
	private ListView mChannelList;
	private List<DummyData> mDummyDataList;
	private ChannelAdapter mChannelAdapter;
	private final String TAG  =this.getClass().getSimpleName();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.channel_list_fragment, container, false);
		mChannelList = (ListView)mView.findViewById(R.id.list_view);
		
		mDummyDataList = StaticDataManager.mLstDumyDatas;
		mChannelAdapter = new ChannelAdapter(getActivity(),
				R.layout.individual_channel_row, mDummyDataList);
		mChannelList.setAdapter(mChannelAdapter);
		mChannelList.setOnItemClickListener(this);
		return mView;
	}
	
	public void setActivateOnItemClick(boolean activateOnItemClick) {
		// When setting CHOICE_MODE_SINGLE, ListView will automatically
		// give items the 'activated' state when touched.
		mChannelList.setChoiceMode(
				activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
						: ListView.CHOICE_MODE_NONE);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view,
			int position, long id) {
		Log.v(TAG,"on item click :  " + position);
		((MainActivity)getActivity()).performOnItemClick(position);
	}
}
