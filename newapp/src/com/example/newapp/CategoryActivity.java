package com.example.newapp;

import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.adapters.CategoryAdapter;
import com.example.chicky.RssParser;
import com.example.chicky.Variables;
import com.example.models.RssItem;

public class CategoryActivity extends ListActivity {

	private int paper;
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		paper = bundle.getInt(Variables.PAPER);
		setTitle(Variables.PAPERS[paper]);

		CategoryAdapter adapter = new CategoryAdapter(this,
				Variables.ICONS[paper], Variables.CATEGORIES[paper]);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		dialog = ProgressDialog.show(this, "", "Loading...");
		new CategoryTask().execute(position);

	}

	class CategoryTask extends AsyncTask<Integer, Void, Void> {
		private int position;

		@Override
		protected Void doInBackground(Integer... param) {
			position = param[0];
			RssParser parser = new RssParser();
			int key = paper * 100 + param[0];
			List<RssItem> items = parser
					.getNewsList(Variables.LINKS[paper][position]);
			System.out.println("Rss size: " + items.size());
			Variables.newsMap.put(key, items);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if (dialog != null) {
				dialog.dismiss();
			}
			Intent intent = new Intent(CategoryActivity.this,
					NewsListActivity.class);
			intent.putExtra(Variables.PAPER, paper);
			intent.putExtra(Variables.CATEGORY, position);

			startActivity(intent);
			super.onPostExecute(result);
		}
	}

}
