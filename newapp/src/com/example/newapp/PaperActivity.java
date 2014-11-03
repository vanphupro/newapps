package com.example.newapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.example.adapters.PaperAdapter;
import com.example.chicky.Variables;

public class PaperActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// simple listView
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, Variables.PAPER);
		// setListAdapter(adapter);
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// R.layout.paper, R.id.tvPaper, Variables.PAPER);
		PaperAdapter adapter = new PaperAdapter(this, R.id.tvPaper,
				Variables.PAPERS);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent("com.example.newapp.CATEGORY");
		intent.putExtra(Variables.PAPER, position);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.paper, menu);
		return true;
	}

}
