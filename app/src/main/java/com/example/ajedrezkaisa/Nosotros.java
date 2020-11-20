package com.example.ajedrezkaisa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Nosotros extends AppCompatActivity {

    String url= "https://informacioncaissa.azurewebsites.net/";
    private WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nosotros);
        browser = (WebView) findViewById(R.id.visorWeb);
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);//habilitar javascript--
        webSettings.setDomStorageEnabled(true);//almacenamiento
        webSettings.setLoadWithOverviewMode(true);//tamaño de la ventana
        WebSettings.getDefaultUserAgent(this);
        WebView.setWebContentsDebuggingEnabled (true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(url);
    }
}