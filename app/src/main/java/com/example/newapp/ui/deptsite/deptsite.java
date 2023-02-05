package com.example.newapp.ui.deptsite;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

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
import android.widget.Toast;

import com.example.newapp.R;
import com.example.newapp.SettingsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class deptsite extends Fragment {

    WebView cview;
    String web;
//        String department;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setMessage("Ruko Jara Sabar Karo......");
        progressDialog.setCancelable(false);
        View view = inflater.inflate(R.layout.fragment_deptsite, container, false);

//                DepartmentSelection();

        SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getContext());
        String dep=sp.getString("reply","");

        web= "https://sites.google.com/a/git.org.in/"+dep+"/";

//        Toast.makeText(getActivity(), dep, Toast.LENGTH_SHORT).show();
        cview = (WebView) view.findViewById(R.id.site);


        cview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                cview.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        cview.getSettings().setJavaScriptEnabled(true);
        cview.getSettings().setLoadsImagesAutomatically(true);
        cview.getSettings().setLoadWithOverviewMode(true);
        cview.getSettings().setUseWideViewPort(true);
        cview.loadUrl(web);
        cview.getSettings().setDomStorageEnabled(true);
        cview.getSettings().setBuiltInZoomControls(true);
        cview.getSettings().setDisplayZoomControls(false);


        String userAgent = cview.getSettings().getUserAgentString();

        try {
            String androidString = cview.getSettings().getUserAgentString().
                    substring(userAgent.indexOf("("),userAgent.indexOf(")")+ 1);

            userAgent = cview.getSettings().getUserAgentString().replace(androidString,"X11; Linux x86_64");

        }catch (Exception e){
            e.printStackTrace();
        }

        cview.getSettings().setUserAgentString(userAgent);
        cview.reload();

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
        private void DepartmentSelection(){

        }
}
