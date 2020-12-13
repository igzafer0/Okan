package com.igzafer.topraktancom;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class CustomWebview extends WebViewClient {

    ImageView iw;
    public void tanim(final WebView webView,String url,ImageView logo){

        iw=logo;

        iw.setVisibility(View.GONE);
        //LoadinDialog.isVisible(main,true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.setWebViewClient(this);
        webView.loadUrl(url);

    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);

    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        Log.d("winter",url);
        if(url.startsWith("https://app.biyos.net/8458")){
            iw.setVisibility(View.VISIBLE);


        }else{
            iw.setVisibility(View.GONE);
            view.loadUrl("javascript:if (typeof(document.getElementsByClassName('text-muted')[0]) != 'undefined' && " +
                    "document.getElementsByClassName('text-muted')[0] != null)" +
                    "{document.getElementsByClassName('text-muted')[0].style.display = 'none';} void 0");

            view.loadUrl("javascript:if (typeof(document.getElementsByClassName('biyos-app')[0]) != 'undefined' &&" +
                    " document.getElementsByClassName('biyos-app')[0] != null)" +
                    "{document.getElementsByClassName('biyos-app')[0].style.display = 'none';} void 0");
            view.loadUrl("javascript:if (typeof(document.getElementsByClassName('biyos-app')[0]) != 'undefined' &&" +
                    " document.getElementsByClassName('biyos-app')[0] != null)" +
                    "{document.getElementsByClassName('biyos-app')[0].style.display = 'none';} void 0");

               }

    }

    @Override
    public void onPageCommitVisible(WebView view, String url) {
        super.onPageCommitVisible(view, url);

    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {

        view.loadUrl(url);
        return false;
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);




    }

    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
        Log.d("winter http", "" + errorResponse);

    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        //super.onReceivedSslError(view, handler, error);
        handler.proceed();
        Log.d("winter ssl", "" + error);

    }
}
