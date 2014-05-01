package com.example.androidappmasterdetails.adapters;

import java.util.List;

import com.example.androidappmasterdetails.R;
import com.example.androidappmasterdetails.dummy.Video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VideoAdapter extends ArrayAdapter<Video>{
	private Context mContext;
	private int RESOURCE;
	private List<Video> mVideos;
	private LayoutInflater mInflater;
	
	public VideoAdapter(Context context, int resource, List<Video> objects) {
		super(context, resource, objects);
		mContext = context;
		RESOURCE = resource;
		mVideos = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder vh = null;
		
		if(view == null) {
			mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = mInflater.inflate(RESOURCE, parent, false);
			vh = new ViewHolder();
			vh.txtName = (TextView)view.findViewById(R.id.txtVideoName);
			vh.txtDesc = (TextView)view.findViewById(R.id.txtDesc);
			view.setTag(vh);
		}else {
			vh = (ViewHolder)view.getTag();
		}
		
		Video video  = mVideos.get(position);
		vh.txtName.setText(video.getVideoName());
		vh.txtDesc.setText(video.getVideoDescription());
		
		return view;
	}
	
	static class ViewHolder {
		TextView txtName;
		TextView txtDesc;
	}
}
