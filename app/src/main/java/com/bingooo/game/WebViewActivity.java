// WebViewActivity.java
package com.bingooo.game;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressDialog progressDialog;

    private final String LOGIN_URL = "https://bingooo.site/login";
    private final String DASHBOARD_URL = "https://bingooo.site/dashboard";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUserAgentString(webSettings.getUserAgentString().replace("wv", ""));

        webView.setWebChromeClient(new WebChromeClient());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains("/dashboard")) {
                    setLoginStatus(true);
                }
                return false;
            }

            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                progressDialog.show();
            }

            public void onPageFinished(WebView view, String url) {
                progressDialog.dismiss();
            }
        });

        boolean isLoggedIn = getSharedPreferences("bingooo", MODE_PRIVATE)
                .getBoolean("isLoggedIn", false);

        // Always start from login, let WebView handle redirection
        webView.loadUrl(isLoggedIn ? DASHBOARD_URL : LOGIN_URL);
    }

    private void setLoginStatus(boolean status) {
        SharedPreferences prefs = getSharedPreferences("bingooo", MODE_PRIVATE);
        prefs.edit().putBoolean("isLoggedIn", status).apply();
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
