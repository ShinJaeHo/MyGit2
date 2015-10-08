package com.example.new108.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by new108 on 2015-10-06.
 */
public class WebActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = (WebView)findViewById(R.id.webView);

        webView.loadUrl("http://m.weather.naver.com");


    }

}
