package com.example.examenapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    WebView wb;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View main = inflater.inflate(R.layout.fragment_2, container, false);

        //Inicializar variable
        wb = main.findViewById(R.id.webview);
        wb.setWebViewClient(new WebViewClient());
        //Activamos javascript
        wb.getSettings().setJavaScriptEnabled(true);
        // Cargamos la web
        wb.loadUrl("https://www.google.es");

        //Método para volver atras sin salir de la app
        wb.setOnKeyListener((view, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK
                    && event.getAction() == MotionEvent.ACTION_UP
                    && wb.canGoBack()) {
                handler.sendEmptyMessage(1);
                return true;
            }
            return false;
        });

        return wb;
    }

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            if (message.what == 1) {
                webViewGoBack();
            }
        }
    };

    private void webViewGoBack() {
        wb.goBack();
    }
}