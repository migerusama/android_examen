package com.example.examenapp.practica;

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

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.examenapp.R;

public class FragmentInternet extends Fragment {

    //Definición variables
    WebView wb;

    //Constructor
    public FragmentInternet() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View main = inflater.inflate(R.layout.fragment_internet, container, false);

        //Inicializar variable
        wb = main.findViewById(R.id.wbInternet);
        wb.setWebViewClient(new WebViewClient());
        //Activamos javascript
        wb.getSettings().setJavaScriptEnabled(true);
        // Cargamos la web
        wb.loadUrl("https://www.google.com");

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
    private final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            if (message.what == 1) {
                webViewGoBack();
            }
        }
    };

    private void webViewGoBack(){
        wb.goBack();
    }

}