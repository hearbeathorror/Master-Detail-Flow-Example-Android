package com.example.androidappmasterdetails.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidappmasterdetails.R;
import com.example.androidappmasterdetails.dummy.DummyData;

public class ChannelAdapter extends ArrayAdapter<DummyData>{
	private Context mContext;
	private List<DummyData> mDummyData;
	private int RESOURCE;
	private LayoutInflater mInflater;

	public ChannelAdapter(Context context, int resource, List<DummyData> objects) {
		super(context, resource, objects);
		mContext = context;
		RESOURCE = resource;
		mDummyData = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder vh = null;
		
		if(view == null) {
			mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = mInflater.inflate(RESOURCE, parent, false);
			vh = new ViewHolder();
			vh.txtChannelName = (TextView)view.findViewById(R.id.txtChannelName);
			view.setTag(vh);
		}else {
			vh = (ViewHolder)view.getTag();
		}
		
		DummyData dummyData = mDummyData.get(position);
		vh.txtChannelName.setText(dummyData.getChannelName());
		return view;
	}
	
	static class ViewHolder {
		TextView txtChannelName;
	}
}
