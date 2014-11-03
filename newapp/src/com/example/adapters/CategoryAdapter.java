package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newapp.R;

public class CategoryAdapter extends ArrayAdapter<String> {

	private Context context;
	private String[] category;
	private int ivIcon;

	public CategoryAdapter(Context context,  int ivIcon,
			String[] category) {
		super(context, ivIcon, category);
		this.context = context;
		this.category = category;
		this.ivIcon = ivIcon;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// LayoutInflater: phinh ra, phong ra
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.category, parent, false);
		ImageView iv = (ImageView) rowView.findViewById(R.id.ivIcon);
		TextView tv = (TextView) rowView.findViewById(R.id.tvCategory);
		iv.setImageResource(ivIcon);
		tv.setText(category[position]);
		return rowView;
		
	}
}
