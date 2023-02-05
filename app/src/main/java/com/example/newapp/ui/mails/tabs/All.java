package com.example.newapp.ui.mails.tabs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.newapp.R;

public class All extends Fragment {

    String web= "https://mail.google.com/mail";
//String web= "https://mail.google.com/mail/mu/mp/511/#tl/search/subject%3Aevents";
//    ProgressDialog progressBar;
//    private int progressBarStatus = 0;https://mail.google.com/mail/mu/mp/352/#tl/search/subject%3Aevents
//    private Handler progressBarHandler = new Handler();
//    private long fileSize = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);

//        ProgressBar progressBar=(ProgressBar) view.findViewById(R.id.progressbarPredict);
//        //String url = "http://youtube.com";
//        refreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipesite);
//
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//
//        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
//


        WebView cview = (WebView) view.findViewById(R.id.weball);
        cview.requestFocus();
        WebSettings webSettings = cview.getSettings();
        cview.getSettings().setJavaScriptEnabled(true);
        cview.getSettings().setBuiltInZoomControls(true);
        cview.getSettings().setDisplayZoomControls(false);
//        cview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        cview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        cview.getSettings().setAppCacheEnabled(true);
//        cview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
//        webSettings.setEnableSmoothTransition(true);
//        cview.getSettings().setUserAgentString("Android");
        cview.getSettings().setAppCachePath(getContext().getFilesDir().getAbsolutePath() + "/cache");
        cview.getSettings().setDatabasePath(getContext().getFilesDir().getAbsolutePath() + "/databases");
        cview.loadUrl(web);
        cview.setWebViewClient(new WebViewClient() {
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
//
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
//
//        cview.setDownloadListener(new DownloadListener() {
//            public void onDownloadStart(String url, String userAgent,
//                                        String contentDisposition, String mimetype,
//                                        long contentLength) {
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });


//        cview.setWebChromeClient(new WebChromeClient() {
//            public void onProgressChanged(WebView view, int progress) {
//
//            progressBar.getProgress();


//                if (progress < 100) {
//                    for(int i=0;i<progress;i++){
//
//                        progressDialog.setMessage("loading...."+i+"%");
//                    }
//                    progressDialog.show();
//                }
//                if (progress == 100) {
//                    progressDialog.dismiss();
//                }
//            }
//        });

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
//        progressBar = new ProgressDialog(view.getContext());
//        progressBar.setCancelable(true);
//        progressBar.setMessage("Loading....");
//        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        progressBar.setProgress(0);
//        progressBar.setMax(100);
//        progressBar.show();
//        //reset progress bar and filesize status
//        progressBarStatus = 0;
//        fileSize = 0;
//
//        new Thread(new Runnable() {
//            public void run() {
//                while (progressBarStatus < 100) {
//                    // performing operation
//                    progressBarStatus = doOperation();
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    // Updating the progress bar
//                    progressBarHandler.post(new Runnable() {
//                        public void run() {
//                            progressBar.setProgress(progressBarStatus);
//                        }
//                    });
//                }
//                // performing operation if file is downloaded,
//                if (progressBarStatus >= 100) {
//                    // sleeping for 1 second after operation completed
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    // close the progress bar dialog
//                    progressBar.dismiss();
//                }
//            }
//        }).start();
        return view;
    }

//    // checking how much file is downloaded and updating the filesize
//    public int doOperation() {
//        //The range of ProgressDialog starts from 0 to 10000
//        while (fileSize <= 15000) {
//            fileSize++;
//            if (fileSize == 1000) {
//                return 10;
//            } else if (fileSize == 2000) {
//                return 20;
//            } else if (fileSize == 3000) {
//                return 30;
//            } else if (fileSize == 4000) {
//                return 40; // you can add more else if
//            }
//            else if (fileSize == 5000) {
//                return 50; // you can add more else if
//            }else if (fileSize == 6000) {
//                return 60; // you can add more else if
//            }else if (fileSize == 7000) {
//                return 70; // you can add more else if
//            }else if (fileSize == 8000) {
//                return 80; // you can add more else if
//            }else if (fileSize == 9000) {
//                return 90; // you can add more else if
//            }else if (fileSize == 10000) {
//                return 90; // you can add more else if
//            }
//            else if (fileSize == 11000) {
//                return 90; // you can add more else if
//            }else if (fileSize == 12000) {
//                return 90; // you can add more else if
//            }else if (fileSize == 13000) {
//                return 90; // you can add more else if
//            }else if (fileSize == 14000) {
//                return 90; // you can add more else if
//            }else if (fileSize == 15000) {
//                return 100; // you can add more else if
//            }
////         else {
////                return 100;
////            }
//        }
//        return 0;//end of while
////        return 100;
//    }//end of doOperation

}