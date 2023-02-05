package com.example.newapp.ui.mails.tabs;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.newapp.R;

public class Events extends Fragment {

    String web= "https://mail.google.com/mail/mu/mp/352/#tl/search/subject%3Aevents";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState!=null)
        {

        }
        View view = inflater.inflate(R.layout.fragment_events, container, false);


        WebView cview = (WebView) view.findViewById(R.id.webevents);
        cview.requestFocus();
        WebSettings webSettings= cview.getSettings();
        cview.getSettings().setJavaScriptEnabled(true);
        cview.getSettings().setBuiltInZoomControls(true);
        cview.getSettings().setDisplayZoomControls(false);

//        cview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
//        cview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        cview.getSettings().setAppCacheEnabled(true);
//        cview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
//        webSettings.setEnableSmoothTransition(true);
//        cview.getSettings().setUserAgentString("Android");
        cview.getSettings().setAppCachePath(getContext().getFilesDir().getAbsolutePath()+"/cache");
        cview.getSettings().setDatabasePath(getContext().getFilesDir().getAbsolutePath()+"/databases");
        cview.loadUrl(web);
        cview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


        cview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                cview.loadUrl(request.getUrl().toString());
                return false;
            }
        });
        cview.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction()
                        == MotionEvent.ACTION_UP && cview.canGoBack()) {
                    //handler.sendEmptyMessage(1);
                    cview.goBack();
                    return true;
                }

                return false;
            }
        });
        return view;
    }

}