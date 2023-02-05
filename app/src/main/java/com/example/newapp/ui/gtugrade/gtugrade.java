package com.example.newapp.ui.gtugrade;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.newapp.R;
//import com.example.newapp.databinding.FragmentGalleryBinding;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

public class gtugrade extends Fragment {

    SwipeRefreshLayout refreshLayout;
    public  static int RC_SIGN_IN=100;
    GoogleSignInClient mGoogleSignInClient;
    String web= "https://www.students.gtu.ac.in/";
    private WebView webView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Ruko Jara Sabar Karo......");
        progressDialog.setCancelable(false);
        View view = inflater.inflate(R.layout.fragment_gtugrade, container, false);
//        //String url = "http://youtube.com";
//        refreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipegradehistory);
//
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//
//        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
//



        WebView cview = (WebView) view.findViewById(R.id.gradehistory);
//        cview.requestFocus();
        cview.getSettings().setBuiltInZoomControls(true);
        cview.getSettings().setJavaScriptEnabled(true);
        cview.getSettings().setUseWideViewPort(true);
        cview.getSettings().setDisplayZoomControls(false);
        cview.getSettings().setUserAgentString("Android");
        cview.getSettings().setAppCachePath(getContext().getFilesDir().getAbsolutePath()+"/cache");
        cview.getSettings().setDatabasePath(getContext().getFilesDir().getAbsolutePath()+"/databases");
        cview.loadUrl(web);
        cview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });


//        WebSettingsCompat.setForceDark(cview.getSettings(), WebSettingsCompat.FORCE_DARK_AUTO);

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
