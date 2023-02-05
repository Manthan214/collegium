package com.example.newapp.ui.gtu100points;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.newapp.R;
//import com.example.newapp.databinding.FragmentSlideshowBinding;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

public class gtu100points extends Fragment {

//    private FragmentSlideshowBinding binding;

    SwipeRefreshLayout refreshLayout;
    public  static int RC_SIGN_IN=100;
    GoogleSignInClient mGoogleSignInClient;
    String web= "https://www.100points.gtu.ac.in/";
    private WebView webView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Wait...");
        progressDialog.setCancelable(false);
        View view = inflater.inflate(R.layout.fragment_gtu100points, container, false);
//        //String url = "http://youtube.com";
//        refreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipesports);
//
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//
//        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
//


        WebView cview = (WebView) view.findViewById(R.id.ssfragment);
//        cview.requestFocus();
//        cview.getSettings().setJavaScriptEnabled(true);
//        cview.getSettings().setBuiltInZoomControls(true);
//        cview.getSettings().setDisplayZoomControls(false);
//        cview.getSettings().setUserAgentString("Android");
//        cview.getSettings().setAppCachePath(getContext().getFilesDir().getAbsolutePath()+"/cache");
//        cview.getSettings().setDatabasePath(getContext().getFilesDir().getAbsolutePath()+"/databases");
//        cview.loadUrl(web);
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


        cview.getSettings().setJavaScriptEnabled(true);
        cview.getSettings().setLoadsImagesAutomatically(true);
        cview.getSettings().setLoadWithOverviewMode(true);
        cview.getSettings().setUseWideViewPort(true);
        cview.getSettings().setDomStorageEnabled(true);
        cview.getSettings().setBuiltInZoomControls(true);
        cview.getSettings().setDisplayZoomControls(false);

        cview.loadUrl(web);

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