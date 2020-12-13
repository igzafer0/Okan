package com.igzafer.topraktancom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    CustomWebview webview;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.WebView);
        logo=findViewById(R.id.logo);

        webview= new CustomWebview();
        webview.tanim(webView,"https://korupark.topraktan.com",logo);
    }
}