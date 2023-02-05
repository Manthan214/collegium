package com.example.newapp.ui.degtu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.newapp.R;


public class degtu extends Fragment {

    String web= "http://de.gtu.ac.in/account/login";
    private WebView webView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setMessage("Ruko Jara Sabar Karo......");
        progressDialog.setCancelable(false);
        View view = inflater.inflate(R.layout.fragment_deptsite, container, false);
//        //String url = "http://youtube.com";
//        refreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipesite);
//
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//
//        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
//


        WebView cview = (WebView) view.findViewById(R.id.site);
        cview.requestFocus();
        cview.getSettings().setJavaScriptEnabled(true);
        cview.getSettings().setBuiltInZoomControls(true);
        cview.getSettings().setDisplayZoomControls(false);
//        cview.getSettings().setUserAgentString("Android");
        cview.getSettings().setAppCachePath(getContext().getFilesDir().getAbsolutePath()+"/cache");
        cview.getSettings().setDatabasePath(getContext().getFilesDir().getAbsolutePath()+"/databases");
        cview.loadUrl(web);
//        cview.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });


        cview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                cview.loadUrl(request.getUrl().toString());
                return false;
            }
        });

//        cview.getSettings().setJavaScriptEnabled(true);
//        cview.getSettings().setLoadsImagesAutomatically(true);
//        cview.getSettings().setLoadWithOverviewMode(true);
//        cview.getSettings().setUseWideViewPort(true);
//        cview.getSettings().setDomStorageEnabled(true);
//        cview.getSettings().setBuiltInZoomControls(true);
//        cview.getSettings().setDisplayZoomControls(false);
//
//        cview.loadUrl(web);
//
//        String userAgent = cview.getSettings().getUserAgentString();
//
//        try {
//            String androidString = cview.getSettings().getUserAgentString().
//                    substring(userAgent.indexOf("("),userAgent.indexOf(")")+ 1);
//
//            userAgent = cview.getSettings().getUserAgentString().replace(androidString,"X11; Linux x86_64");
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        cview.getSettings().setUserAgentString(userAgent);
//        cview.reload();

        cview.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });




        cview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {

//                if (progress < 100) {
//                    progressDialog.show();
//                }
//                if (progress == 100) {
//                    progressDialog.dismiss();
//                }
            }
        });

//        cview.loadUrl("javascript:YPqjbf.data-initial-value='kathanmoney.sv21@gmail.com';");
//        cview.loadUrl("javascript:LgbsSe.Next.click();");
//        cview.loadUrl("javascript:YPqjbf.data-initial-value='games214';");
//        cview.loadUrl("javascript:LgbsSe.Next.click();");

//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refreshLayout.setRefreshing(true);
//                cview.reload();
//                refreshLayout.setRefreshing(false);
//            }
//        });

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
