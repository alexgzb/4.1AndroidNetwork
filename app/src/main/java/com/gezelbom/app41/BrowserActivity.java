package com.gezelbom.app41;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;


public class BrowserActivity extends Activity {

    private static final String TAG = "BrowserActivity";
    private String url = null;
    private EditText urlTextView = null;
    private WebView wView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        Log.d(TAG, "The URL received " + url);

        urlTextView = (EditText) findViewById(R.id.textViewUrl);
        urlTextView.setText(url);
        wView = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = wView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wView.setWebViewClient(new WebViewClient());
        wView.loadUrl(url);

    }

    public BrowserActivity() {
    }

    public void go(View v) {
        url = urlTextView.getText().toString();
        wView.loadUrl("http://" + url);
        wView.requestFocus();
    }


}
