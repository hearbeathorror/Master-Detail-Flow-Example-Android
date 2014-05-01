package com.example.androidappmasterdetails.adapters;

import java.util.List;

import com.example.androidappmasterdetails.R;
import com.example.androidappmasterdetails.dummy.DummyData;
import com.example.androidappmasterdetails.dummy.Video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class DummyDataAdapter extends BaseExpandableListAdapter {
	private Context mContext;
	private List<DummyData> mDummyData;
	private LayoutInflater mInflater;
	
	public DummyDataAdapter(Context context, 
			List<DummyData> dummyData) {
		mDummyData = dummyData;
		mContext = context;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		if(mDummyData != null && 
				mDummyData.get(groupPosition).getVideoList() != null) {
			return mDummyData.get(groupPosition).getVideoList().get(childPosition);
		}else {
			return null;
		}
	}
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder vh = null;
		
		if(view == null) {
			mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = mInflater.inflate(R.layout.individual_video_row, parent, false);
			vh = new ViewHolder();
			vh.txtVideoName = (TextView)view.findViewById(R.id.txtVideoName);
			vh.txtVideoDesc = (TextView)view.findViewById(R.id.txtDesc);
			view.setTag(vh);
		}else {
			vh = (ViewHolder)view.getTag();
		}
		
		Video video  = mDummyData.get(groupPosition).getVideoList().get(childPosition);
		vh.txtVideoName.setText(video.getVideoName());
		vh.txtVideoDesc.setText(video.getVideoDescription());
		
		return view;
	}
	@Override
	public int getChildrenCount(int groupPosition) {
		if(mDummyData != null && 
				mDummyData.get(groupPosition).getVideoList() != null) {
			return mDummyData.get(groupPosition).getVideoList().size();
		}else {
			return 0;
		}
	}
	@Override
	public Object getGroup(int groupPosition) {
		if(mDummyData != null && 
				mDummyData.get(groupPosition) != null) {
			return mDummyData.get(groupPosition);
		}else {
			return null;
		}
	}
	@Override
	public int getGroupCount() {
		if(mDummyData != null) {
			return mDummyData.size();
		}else {
			return 0;
		}
	}
	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder vh = null;
		
		if(view == null) {
			mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = mInflater.inflate(R.layout.individual_channel_row, parent, false);
			vh = new ViewHolder();
			vh.txtChannelName = (TextView)view.findViewById(R.id.txtChannelName);
			view.setTag(vh);
		}else {
			vh = (ViewHolder)view.getTag();
		}
		
		DummyData dummyData = mDummyData.get(groupPosition);
		vh.txtChannelName.setText(dummyData.getChannelName());
		return view;
	}
	@Override
	public boolean hasStableIds() {
		return false;
	}
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	static class ViewHolder {
		TextView txtVideoName;
		TextView txtChannelName;
		TextView txtVideoDesc;
	}
}
