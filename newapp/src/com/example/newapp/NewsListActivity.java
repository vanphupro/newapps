package com.example.newapp;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.adapters.NewsAdapter;
import com.example.chicky.RssParser;
import com.example.chicky.Variables;
import com.example.models.RssItem;

public class NewsListActivity extends ListActivity {

	private List<RssItem> items;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		int category = bundle.getInt(Variables.CATEGORY);
		int paper = bundle.getInt(Variables.PAPER);
		setTitle(Variables.CATEGORIES[category][paper]);
		
		int key = paper * 1000 + category;
		RssParser parser = new RssParser();

		items = parser
				.getNewsList(Variables.LINKS[paper][category]);
		Variables.newsMap.get(key);
		NewsAdapter adapter = new NewsAdapter(this, Variables.ICONS[paper], items);
		setListAdapter(adapter);
		
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, NewsActivity.class);
		intent.putExtra(Variables.LINK, items.get(position).getLink());
		startActivity(intent);
		super.onListItemClick(l, v, position, id);
	}

	
}
