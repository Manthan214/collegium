package com.example.newapp.ui.mails;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.example.newapp.PagerAdpter;
import com.example.newapp.R;
import com.google.android.material.tabs.TabLayout;

public class mails extends Fragment {

//    private FragmentHomeBinding binding;
    TabLayout tabLayout;
    ViewPager viewPager;
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    private long fileSize = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mails,container,false);


         tabLayout=(TabLayout)view.findViewById(R.id.tablayout);
         viewPager = (ViewPager) view.findViewById(R.id.viewpage);
        loadmail loadmail=new loadmail();
            loadmail.execute();

        return view;

    }
    public class loadmail extends AsyncTask{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar = new ProgressDialog(getActivity());
            progressBar.setCancelable(true);
            progressBar.setMessage("Loading....");
            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressBar.setProgress(0);
            progressBar.setMax(100);
//            progressBar.show();
            //reset progress bar and filesize status
            progressBarStatus = 0;
            fileSize = 0;

            new Thread(new Runnable() {
                public void run() {
                    while (progressBarStatus < 100) {
                        // performing operation
                        progressBarStatus = doOperation();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // Updating the progress bar
                        progressBarHandler.post(new Runnable() {
                            public void run() {
                                progressBar.setProgress(progressBarStatus);
                            }
                        });
                    }
                    // performing operation if file is downloaded,
                    if (progressBarStatus >= 100) {
                        // sleeping for 1 second after operation completed
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // close the progress bar dialog
                        progressBar.dismiss();
                    }
                }
            }).start();



        }

        @Override
        protected Object doInBackground(Object[] objects) {
            PagerAdpter adapter = new PagerAdpter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(adapter);
            return null;
        }



        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            viewPager.setOffscreenPageLimit(4);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            viewPager.addOnPageChangeListener(new com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.addOnTabSelectedListener(new com.google.android.material.tabs.TabLayout.OnTabSelectedListener() {


                @Override
                public void onTabSelected(com.google.android.material.tabs.TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());

                }

                @Override
                public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {
//                getFragmentManager().beginTransaction().detach().attach(this).comit();
                }
            });

        }
    }
    // checking how much file is downloaded and updating the filesize
    public int doOperation() {
        //The range of ProgressDialog starts from 0 to 10000
        while (fileSize <= 15000) {
            fileSize++;
            if (fileSize == 1000) {
                return 10;
            } else if (fileSize == 2000) {
                return 20;
            } else if (fileSize == 3000) {
                return 30;
            } else if (fileSize == 4000) {
                return 40; // you can add more else if
            }
            else if (fileSize == 5000) {
                return 50; // you can add more else if
            }else if (fileSize == 6000) {
                return 60; // you can add more else if
            }else if (fileSize == 7000) {
                return 70; // you can add more else if
            }else if (fileSize == 8000) {
                return 80; // you can add more else if
            }else if (fileSize == 9000) {
                return 90; // you can add more else if
            }else if (fileSize == 10000) {
                return 90; // you can add more else if
            }
            else if (fileSize == 11000) {
                return 90; // you can add more else if
            }else if (fileSize == 12000) {
                return 90; // you can add more else if
            }else if (fileSize == 13000) {
                return 90; // you can add more else if
            }else if (fileSize == 14000) {
                return 90; // you can add more else if
            }else if (fileSize == 15000) {
                return 100; // you can add more else if
            }
//         else {
//                return 100;
//            }
        }
        return 0;//end of while
//        return 100;
    }

}