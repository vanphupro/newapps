package com.example.newapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.chicky.Variables;

@SuppressLint("SetJavaScriptEnabled")
public class NewsActivity extends Activity {

	private WebView webview;
	private String link;
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.article);
		Bundle bundle = getIntent().getExtras();
		setTitle(R.string.app_name);
		webview = (WebView) findViewById(R.id.wbNews);
		link = bundle.getString(Variables.LINK);

		webview.getSettings().setSupportZoom(true);
		webview.setInitialScale(1);
		webview.getSettings().setLoadWithOverviewMode(true);
		webview.getSettings().setUseWideViewPort(true);
		webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webview.setScrollbarFadingEnabled(false);
		webview.setWebViewClient(new ChickyWebViewClient());
		webview.getSettings().setJavaScriptEnabled(true);
		dialog = ProgressDialog.show(this, "", "Loading...");
		new NewsTask().execute(); 
		super.onCreate(savedInstanceState);
	}

	class NewsTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			webview.loadUrl(link);
			return null;
		}		
	}
	class ChickyWebViewClient extends WebViewClient{

		@Override
		public void onPageFinished(WebView view, String url) {
			if(dialog != null)
			{
				dialog.dismiss();
			}
			super.onPageFinished(view, url);
		}
		
	}

}
