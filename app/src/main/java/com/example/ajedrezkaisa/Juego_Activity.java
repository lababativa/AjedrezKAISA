package com.example.ajedrezkaisa;

import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.os.Bundle;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Juego_Activity extends AppCompatActivity {


    //String url="https://ivaaan06.github.io/KaissaGame/";
    //String url= "http://kaissa2.tonohost.com/html/juego.html";
    String url= "https://ajedrezkaissa.000webhostapp.com";
    private WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_);

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