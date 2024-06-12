package com.ibrahim.haventune;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {


    /**
     * * Created by Jummania on 12,June,2024.
     * * Email: sharifuddinjumman@gmail.com
     * * Dhaka, Bangladesh.
     */
        /*
    >>Source Code provided by
    >>Jubayer Hossain [https://www.facebook.com/JubayerHossainbd]
    >>Please don't forget to put a review on my site [www.bongoacademy.com]
    >>Share my course with your friends on Facebook
    >>Your positive words help me doing even better
     */


    ///====================================================
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired
    final ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    //=======================================================
    //====================================================================
    //====================================================================
    TextView tvDate;
    LinearLayout layoutContainer;
    FloatingActionButton fabButton;
    RelativeLayout _rootLay;
    InterstitialAd mInterstitialAd;
    // JPlayer that created by Sharif Uddin Jumman (Jummania)
    JPlayer jPlayer;
    LinearLayout layPlayer;
    ImageView imngClosePlayer, imgPlayPause, imgPrevious, imgNext;
    HashMap<String, String> hashMap;
    int PLAYING_NOW = 0;
    boolean playingVideo = false;
    private long mBackPressed;

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    ///==============================================

    //====================================================================
    private void addVideos() {
        // We will add all videos here

        //Video Details Here Here

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "3jtqM_EsUCQ");
        hashMap.put("vdo_title", "Islam: A Role Model for Communal Harmony | Mizanur Rahman Azhari");
        hashMap.put("vdo_desciption", "ইসলাম সাম্প্রদায়িক সম্প্রীতির রোল মডেল | মিজানুর রহমান আজহারি সমাজে বিদ্যমান ভেদাভেদ আর বৈষম্যের বেড়াজাল ভেঙ্গে সম্প্রীতি কীভাবে প্রতিষ্ঠিত করতে হয় সেটা ইসলামই শিখিয়েছে। ");
        arrayList.add(hashMap);

        //Video Details Here Here

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "_4msv5qILRk");
        hashMap.put("vdo_title", "ইব্রাহিম আঃ এর জীবনী | মিজানুর রহমান আজহারী ওয়াজ |");
        hashMap.put("vdo_desciption", "Watch Mizanur Rahman Azhari Waz “Story of Ibrahim Prophet – ইব্রাহিম আঃ এর জীবনী”");
        arrayList.add(hashMap);

        //------------->>>>>>>>>>>>>>>>>


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "Gx7OLd-qEaw");
        hashMap.put("vdo_title", "Allah Allah | Bangla Islamic Song by Kalarab Shilpigosthi | ");
        hashMap.put("vdo_desciption", "Song: Allah Allah Singer: Abu Rayhan & Kalarab youth group Lyric & Tune: Sayed Ahmad");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "GOOayxVKmSo");
        hashMap.put("vdo_title", "পকুকুরে কামড় দেওয়ার আর মানুষ পাইলো না।");
        hashMap.put("vdo_desciption", "Do something for human as much as possible ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "NP5KlYhgjew");
        hashMap.put("vdo_title", "আল্লাহু আল্লাহু তুমি জাল্লে জালালুহু । ");
        hashMap.put("vdo_desciption", "Singer:Mahmud Huzaifa  Muhammad Ibrahim Mazharul Islam  Moeen Uddin");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "16GxtAyuGqI");
        hashMap.put("vdo_title", "হৃদয় শীতলকরা কণ্ঠে আল্লাহু আল্লাহু গজল || ");
        hashMap.put("vdo_desciption", "হৃদয় শীতলকরা কণ্ঠে আল্লাহু আল্লাহু গজল || Muhammad Ibrahim || Mahmud Huzaifa");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "KGOoLw2NyGU");
        hashMap.put("vdo_title", "কান্না চলে আসার মত সেরা গজল । Ami Etim Bole । আমি এতিম বলে । ");
        hashMap.put("vdo_desciption", "Holy Tune presents Islamic Song : কান্না চলে আসার সেরা গজল । Ami Etim Bole । আমি এতিম বলে । ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "UiFe4-Fn-bA");
        hashMap.put("vdo_title", "এতো কষ্টেও চলছে এদের জীবন, অথচ আমি আপনি কতো হতাশ !");
        hashMap.put("vdo_desciption", "নানা সমস্যাকে সংগী করে এদের মতো মানুষেরা দিব্যি জীবন পার করছে। আর আমরা আছি শুধু হায় হুতাশ নিয়ে, কখনো চিন্তা করি না যে, আল্লাহ  আমাদের কতোটা ভালো রেখেছে।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "F6B14rx8Sio");
        hashMap.put("vdo_title", "সবাই যে আপনাকে অবিশ্বাস করবে ব্যপারটা তেমন নয়।");
        hashMap.put("vdo_desciption", "Do something for human as much as possible");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "gsWkfeI-msA");
        hashMap.put("vdo_title", "রেশমী চুড়ী ।");
        hashMap.put("vdo_desciption", "Do something for human as much as possible ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "pfmzpJ3Qdi4");
        hashMap.put("vdo_title", "দেখা হোক বা না হোক, আপনাদের ভালোবাসা আমি উপলব্ধি করতে পারি।");
        hashMap.put("vdo_desciption", "দেখা হোক বা না হোক, আপনাদের ভালোবাসা আমি উপলব্ধি করতে পারি।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "1QN2AAyxhIU");
        hashMap.put("vdo_title", "অপ্রয়োজনে এদের পন্য না নিলে এরাই কিছু দিন পরে ভিক্ষা করতে বাধ্য হয়।");
        hashMap.put("vdo_desciption", "এভাবে হিজাব এর ব্যাপকতার প্রসার ঘটছে আলহামদুলিল্লাহ  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "u12vv_i7bQY");
        hashMap.put("vdo_title", "অন্যের কথা শুনার চাইতে ভাঙ্গারি টোকাইয়া খাওয়াই ভালো।");
        hashMap.put("vdo_desciption", "অন্যের কথা শুনার চাইতে ভাঙ্গারি টোকাইয়া খাওয়াই ভালো।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "6raF-0wbs3o");
        hashMap.put("vdo_title", "প্রত্যেক মা-বোনের জন্য এটি অনেক গুরুত্বপূর্ণ।");
        hashMap.put("vdo_desciption", "প্রত্যেক মা-বোনের জন্য এটি অনেক গুরুত্বপূর্ণ।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "98aUluPxRi0");
        hashMap.put("vdo_title", "জীবন সংগ্রাম কখনই বয়সের দিক বিবেচনা করে আসে না ।");
        hashMap.put("vdo_desciption", "জীবন সংগ্রাম কখনই বয়সের দিক বিবেচনা করে আসে না ।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "Otp3YhZQqtA");
        hashMap.put("vdo_title", "ইজ্জত বাঁচাতে না দেখার ভান করলে, মূলত ইজ্জত রক্ষা হবে না।");
        hashMap.put("vdo_desciption", "ইজ্জত বাঁচাতে না দেখার ভান করলে, মূলত ইজ্জত রক্ষা হবে না।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "2kKUDYwl78A");
        hashMap.put("vdo_title", "আমার জন্য কিছু খাবার নিয়ে আসো, দেখি কে কি আনো ?");
        hashMap.put("vdo_desciption", "আমার জন্য কিছু খাবার নিয়ে আসো, দেখি কে কি আনো ? ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "sjhlqSnPh0E");
        hashMap.put("vdo_title", "যে ভিক্ষাবৃত্তি রাসুল (সাঃ) অপছন্দ করতেন, তা রোধ করতে আমাদের সবার এগিয়ে আসা উচিৎ।");
        hashMap.put("vdo_desciption", "যে ভিক্ষাবৃত্তি রাসুল (সাঃ) অপছন্দ করতেন, তা রোধ করতে আমাদের সবার এগিয়ে আসা উচিৎ। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "F5DbVPDwGDc");
        hashMap.put("vdo_title", "যদি আল্লাহ্ কবুল করেন, এই অল্পপুঁজিতেই লাভবান হবেন। ");
        hashMap.put("vdo_desciption", "যদি আল্লাহ্ কবুল করেন, এই অল্পপুঁজিতেই লাভবান হবেন।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "uV89pv5Y3i0");
        hashMap.put("vdo_title", "আমার জন্য না, আমার মায়ের জন্য লাগবে।");
        hashMap.put("vdo_desciption", "নিজের পরার জন্য জুতা নেই অথচ ওরা বাবা, মা, এবং ভাইয়ের কথা চিন্তা করছে। মাশাআল্লাহ!! এতো অল্প বয়সে পরিবার নিয়ে চিন্তা কয়জন করতে পারে ?  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "szRBX14teI8");
        hashMap.put("vdo_title", "সামান্য টাকা পেয়ে কেমন খুশি, অথচ অনেকের ১৭০০ কোটিতে ও মন ভরে না। ");
        hashMap.put("vdo_desciption", "সামান্য টাকা পেয়ে কেমন খুশি, অথচ অনেকের  ১৭০০ কোটিতে ও মন ভরে না। ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "MUXFW5PjkrQ");
        hashMap.put("vdo_title", "বুড়ো বয়সের লাঠি মানে নতুন একটা পা।");
        hashMap.put("vdo_desciption", "মানবতার মহান শিক্ষক হচ্ছে আমাদের প্রিয় নবী হযরত মোহাম্মদ স,,,,,৷");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "AHfBzjWiGoM");
        hashMap.put("vdo_title", "আপন মানুষ চোখের আড়াল হলে সবাই ব্যাথিত হয়। সেই ব্যাথা ধনী-গরীব বুঝে না।");
        hashMap.put("vdo_desciption", "আপন মানুষ চোখের আড়াল হলে সবাই ব্যাথিত হয়। সেই ব্যাথা ধনী-গরীব বুঝে না।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "B5m8sYtnCvk");
        hashMap.put("vdo_title", "মেয়ে মইরা ভালোই হইছে ।");
        hashMap.put("vdo_desciption", "মেয়ে মইরা ভালোই হইছে । কতটা শোকে এই কথা মায়ের মুখে আসে ?");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "B5m8sYtnCvk");
        hashMap.put("vdo_title", "শুধু নিজের না, সবার চিন্তাই করতে হবে। ");
        hashMap.put("vdo_desciption", "শুধু নিজের না, সবার চিন্তাই করতে হবে। এই লকডাউন নিয়ে উনি সবার জন্য চিন্তিত।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "9WSng35EEDs");
        hashMap.put("vdo_title", "হিসাব ঐ একটাই, কোটি টাকা থাকলে ও আপনি দান করতে পারবেন না, যদি আল্লাহ্ না কবুল করে।");
        hashMap.put("vdo_desciption", "হিসাব ঐ একটাই, কোটি টাকা থাকলে ও আপনি দান করতে পারবেন না, যদি আল্লাহ্ না কবুল করে।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "PLfcPWvrV40");
        hashMap.put("vdo_title", "এভাবেই একটা এক্সিডেন্ট সারাজীবনের কান্না হয়ে দাঁড়ায়। ");
        hashMap.put("vdo_desciption", "এক্সিডেন্টের ঠিক পূর্বমুহুর্তে আমরা কি করি ? আমরা কিছুটা অসতর্ক থাকি। মানে একটু অসতর্কতা, অসাবধানতার কারনে বেশির ভাগ এক্সিডেন্টগুলা ঘটে।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "CiYZcQUolz0");
        hashMap.put("vdo_title", "এরাই প্রকৃত জীবনযোদ্ধা ");
        hashMap.put("vdo_desciption", " আপনার ৯০ বছর বয়সে আপনি কাজ করে খাইতে পারবেন তো ?বয়সের চেয়ে  আত্মসম্মানবোধ যখন বেশি, তখন কাজ না করে উপায় কি?  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "NSp2gqn1URk");
        hashMap.put("vdo_title", "ভাগ্য এবং পরিস্থিতি কাউকে ধনী বানায়, আবার কাউকে রাখে বঞ্ছিত। ");
        hashMap.put("vdo_desciption", "বৈচিত্রময় জীবনযুদ্ধ চালিয়ে যাওয়া এইসব মানুষগুলোকে আমরা নানান ভাবে অবহেলা করে থাকি, কারো কাছে এরা টোকাই, হিরনঞ্চি, কারো কাছে এরা প্রতিবন্ধী, আবার কারো কাছে এরা পথশিশু।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "h6vmCZpGkCM");
        hashMap.put("vdo_title", "যাত্রী ছাড়া রিক্সা চলবে ঠিকই, কিন্তু পেট তো চলবে না ");
        hashMap.put("vdo_desciption", "যাত্রী ছাড়া রিক্সা চলবে ঠিকই, কিন্তু পেট তো চলবে না ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "YcSiDfvIWlU");
        hashMap.put("vdo_title", "এক দিন আমার, আপনার, সবার এই ৩টি প্রশ্নের সম্মুখীন হতে হবে। ");
        hashMap.put("vdo_desciption", "এক দিন আমার, আপনার, সবার এই ৩টি প্রশ্নের সম্মুখীন হতে হবে। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "d67iIYRdHMM");
        hashMap.put("vdo_title", "লকডাউনের মত দূর্যোগ এরা কিভাবে সামলাবে ? ");
        hashMap.put("vdo_desciption", "লকডাউনের মত দূর্যোগ এরা কিভাবে সামলাবে ?  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "jiyIMSWjSf4");
        hashMap.put("vdo_title", "সামান্য কিছু মূলধনের অভাবে অনেকেই এ পথ বেছে নেয়। ");
        hashMap.put("vdo_desciption", "সামান্য কিছু মূলধনের অভাবে অনেকেই এ পথ বেছে নেয়। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "1tlIPy_jZLs");
        hashMap.put("vdo_title", "বৃষ্টি সবার জন্য রোমান্টিক হয়না । ");
        hashMap.put("vdo_desciption", "বৃষ্টিতে অনেক সময় এরা আমার আপনার বাড়ীর নিচে অথবা দোকানের সামনে এসে দাঁড়ায়, এটা আপনার জন্য কিছুটা বিরক্তির কারন হলেও দয়া করে পাগল-পাগল বলে তাড়িয়ে দিবেন না। ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "zCcxBuBtess");
        hashMap.put("vdo_title", "আলহামদুলিল্লাহ্!! নানি-নাত্নির জীবনে নতুন মোড়।");
        hashMap.put("vdo_desciption", "আলহামদুলিল্লাহ্!!! নানি-নাত্নির জীবনে নতুন মোড়। Story of Shanta : Part- 02  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "qlVDJZoMJB0");
        hashMap.put("vdo_title", "এভাবেই চলছে নানি-নাত্নির জীবন।");
        hashMap.put("vdo_desciption", "এভাবেই চলছে নানি-নাত্নির জীবন। Story of Shanta : Part 01 ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "uyFX-vJY2PM");
        hashMap.put("vdo_title", "যাদের দু'বেলা খাবারের নিশ্চয়তা নেই ");
        hashMap.put("vdo_desciption", "যাদের দু'বেলা খাবারের নিশ্চয়তা নেই, তাদের অসুস্থতা এবং ঔষধের খবর কে রাখে ?  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "22JQOcgg_tE");
        hashMap.put("vdo_title", "এই ঈদে খানিকটা খুশি ছড়িয়ে দিলো idea Fashion |");
        hashMap.put("vdo_desciption", "প্রতি শো-রুম থেকে মিনিমাম ৫ টা করে নতুন কাপড় অসহায় মানুষদের গিফট করার কথা বলেছিলাম আইডিয়া ফ্যাশন হাউজের ঔনার মুহিব্বুল্লাহ ভাইকে, কিন্তু তিনি আমাকে সারপ্রাইজড করলেন।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "oq59vbGCS1I");
        hashMap.put("vdo_title", "খুশি ছড়িয়ে যাক সবার মাঝে।");
        hashMap.put("vdo_desciption", "খুশি ছড়িয়ে যাক সবার মাঝে।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "k3M6EwILp14");
        hashMap.put("vdo_title", "এদের হাসিতে হোক আমাদের ঈদ। ");
        hashMap.put("vdo_desciption", "আমি আল্লাহর কাছে চাই এই মানি ব্যাগটা তিনি যেন কোন দিন খালি না করে। এতটুকু ব্যাগে অযস্র ভালোবাসা আছে।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "98ALaV5VuGY");
        hashMap.put("vdo_title", "ঈমান যদি মজবুত হয় তাহলে কোটি টাকার প্রলোভন ও তার কাছে তুচ্ছ। ");
        hashMap.put("vdo_desciption", "ঈমান যদি মজবুত হয় তাহলে কোটি টাকার প্রলোভন ও তার কাছে তুচ্ছ।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "v-O1bCcncMU");
        hashMap.put("vdo_title", "জীবন এখানে এমন। অমানুষরা মানুষের রূপ নিয়ে এদের সাথে এমন করে । ");
        hashMap.put("vdo_desciption", "কে শুনবে এদের দুংক্ষের কথা, কে করবে ওদের বিচার। ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "dcc8ruHl5Xk");
        hashMap.put("vdo_title", "আমাদের কাছে যেটা পরিত্যক্ত, এদের কাছে সেটাই মূল্যবান। ");
        hashMap.put("vdo_desciption", "আমাদের কাছে যেটা পরিত্যক্ত, এদের কাছে সেটাই মূল্যবান। ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "ebwPunvDuYo");
        hashMap.put("vdo_title", "ছোটবেলার এমন বিপদের কথা প্রায়ই মনে পড়ে। ");
        hashMap.put("vdo_desciption", "ছোটবেলার এমন বিপদের কথা প্রায়ই মনে পড়ে। ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "lj7KYXtICrs");
        hashMap.put("vdo_title", "সমাজটা এমন হয়েছে যে, সামর্থ্য থাকুক আর না থাকুক মেয়ের বাড়িতে ইফতার দিতেই হয়।");
        hashMap.put("vdo_desciption", "আমরা সমাজ রক্ষা করতে গিয়ে ইসলামকে ভুলে যাই। এই যেমন, সামর্থ্য থাকুক আর না থাকুক মেয়ের বাড়িতে ইফতার সামগ্রী পাঠানো লাগবে। যার আছে তার তো সমস্যা নাই।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "wYanfvQ0JU8");
        hashMap.put("vdo_title", "আমরা প্রায়ই এদেরকে ক্ষুধার্ত রেখে হুর হুর করে তাড়িয়ে দেই। ");
        hashMap.put("vdo_desciption", "ভালো খাবার খাওয়া আমার আপনার কাছে হয়তো বড় কোন বিষয় না। কিন্তু এদের কাছে এটি একটি স্বপ্নের মতো। তাই সুযোগ হলে এদের এই স্বপ্ন পূরন করার চেষ্টা করা উচিৎ।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "jOuR7CGTca0");
        hashMap.put("vdo_title", "সারা জীবন মানুষের বাসায় বাসায় চাউলের বস্তা পৌঁছে দিয়েছেন, কিন্তু ?");
        hashMap.put("vdo_desciption", "সব সময় কষ্ট করলেই মিষ্টি মিলে না। তাই কষ্ট করতে হবে সঠিক লাইনে .এইযে দুধু মিয়াকেই দেখেন, সারাজীবন মানুষের বাসায় বাসায় চাউলের বস্তা পৌছিয়ে দিয়েছেন, কিন্তু নিজের ঘরে কখনো একটা বস্তা চাউল নেওয়ার সৌভাগ্য হয়নি। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "3nfD1n9JmDU");
        hashMap.put("vdo_title", "আল্লাহ্ সকল জনপ্রতিনিধিদের হেদায়াত দান করুন।");
        hashMap.put("vdo_desciption", "ঐ চেয়ারম্যান, মেম্বারের নাম ভিডিওতে রেখে কি হবে ? হতে পারে উল্টা বৃদ্ধ মায়ের উপর একটা এক্সট্রা প্রেশার আসবে।   ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "_o86mzUx47g");
        hashMap.put("vdo_title", "লক্ষ্য কোটি টাকার ব্যাবসা নিয়েও আত্মবিশ্বাস থাকে না, অনেকের দিন কাটে হতাশায়। আর উনাদের ? ");
        hashMap.put("vdo_desciption", "লক্ষ্য কোটি টাকার ব্যাবসা নিয়েও আত্মবিশ্বাস থাকে না, দিন কাটে হতাশায়। আর উনি চলছেন আত্মবিশ্বাস আর আল্লাহ্র উপর ভরসা করে।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "-ncZ9Y0cKcM");
        hashMap.put("vdo_title", "হঠাৎ করেই জানার আগ্রহ হলো, মানিব্যাগ হাতে দিলে উনারা কি করেন ! ");
        hashMap.put("vdo_desciption", "হঠাৎ করেই জানার আগ্রহ হলো, মানিব্যাগ হাতে দিলে উনারা কি করেন !  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "UeZuP5-EY0I");
        hashMap.put("vdo_title", "বিয়ের অনুষ্ঠানে আমরা যা অপচয় করি, তা দিয়েই এদের ফ্রেশ খাবারের ব্যবস্থা হয়ে যেতো। ");
        hashMap.put("vdo_desciption", "এক দিকে পৃথীবিতে ৮০+ কোটি মানুষ থাকে ক্ষুধার্ত, আরেক দিকে বছরে ১৩০ কোটি টন খাবার করি অপচয়।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "-d2BIKRRveM");
        hashMap.put("vdo_title", "Beautiful Sunflower । দয়া করে ফসলের ক্ষতি করবেন না");
        hashMap.put("vdo_desciption", "উনাদের কথা হচ্ছে, আপনারা অনেক দূর থেকে ঘুরতে আসছেন, দেখেন, ছবি তোলেন, কিন্তু ফসলের ক্ষতি কইরেন না।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "6R4yS0pRqW4");
        hashMap.put("vdo_title", "বৃদ্ধ বয়সে পুরো গ্রাম ঘুরাটা আসলেই অনেক কষ্টকর, আল্লাহ্ সবাইকে হেফাজত করুক। ");
        hashMap.put("vdo_desciption", "বি:দ্র:  ক্যামেরার সামনে কখন এসে যে একটা পোঁকা বসেছিলো খেয়াল করি নাই। তাই ভিডিও এর সামনে একটু ঘোলা দেখা যাচ্ছে, বিষয়টা ক্ষমাসুন্দর দৃষ্টিতে দেখবেন। ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "50Y7Z_WOPac");
        hashMap.put("vdo_title", "পলিথিন দিয়েই চলছে জীবন ! ");
        hashMap.put("vdo_desciption", "অনেক থাকতেও আমাদের চাহিদার শেষ নাই। উনাদের তেমন কিছুই নাই, তারপরও চাহিদা নাই। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "u5QiiExSkdI");
        hashMap.put("vdo_title", "( Accident ) দুই থেকে আড়াই মাসের একটা ছাগলের বাচ্চা হঠাৎ করে আমার বাইকের নিচে চলে আসে। ");
        hashMap.put("vdo_desciption", "চলার পথে এমন অনাকাঙ্ক্ষিত ঘটনা আমার সাথে এর আগে কখনো ঘটেনি। আমি বিশ্বাস করি আল্লাহ্যা করেন ভালোর জন্য করেন, আলহামদুলিল্লাহ্আমার কিছুই হয় নাই।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "Dj6_r4GvekI");
        hashMap.put("vdo_title", "উনি পথ ভুল করে রাজশাহীর বাঘা, বামন ডাঙ্গা থেকে চাঁদপুরে চলে এসেছেন। ");
        hashMap.put("vdo_desciption", "রাজশাহী জেলার একটি উপজেলার নাম বাঘা। উনি সেই  বর্ডার এলাকা বাঘা, ব্রাহ্মন ডাঙ্গা থেকে প্রায় চাঁদপুরে ঢুকে পরেছেন। আমি গত ৮ ফেব্রুয়ারি চাঁদপুর থেকে ঢাকা আসার পথে মতলব বেড়িবাঁধ রোডে উনার দেখা পেয়েছিলাম।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "ReyNtEFStAA");
        hashMap.put("vdo_title", "আলহামদুলিল্লাহ্, ১৮ বছর পর বাবা তার সন্তান কে খু্ঁজে পেলেন।");
        hashMap.put("vdo_desciption", "আল্লাহ্ সর্বোত্তম পরিকল্পনাকারী। কোন দিন, কি কারনে, কার ভাগ্য পরিবর্তন হবে, সেটা একমাত্র আল্লাহ্ সবচেয়ে ভালো জানেন।  তা না হলে ১৮ বছর পর কোহিনূর তার পরিবার ফিরে পেতো না। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "Hu6wH2mxRKw");
        hashMap.put("vdo_title", "কুয়াশা, Winter 2021");
        hashMap.put("vdo_desciption", "কুয়াশা, Winter 2021 ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "rBllRbftxBs");
        hashMap.put("vdo_title", "তাঁর দেওয়া উদাহরণ গুলা ছিলো শুনার মত। বেশি বেচতে পারি, কিন্তু দুই নাম্বারি কইরা তো নিতে পারি না। ");
        hashMap.put("vdo_desciption", "বেশি বেচতে পারি, কিন্তু দুই নাম্বারি কইরা তো নিতে পারি না। এক টাকার চকলেট দুই টাকা বিক্রি করে, কারন এটাই তাঁর সব। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "iiFcJEhJOPs");
        hashMap.put("vdo_title", "উনার মনে অনেক কষ্ট থাকলেও কথার মধ্যে অনেক মায়া।  ");
        hashMap.put("vdo_desciption", "উনার মনে অনেক কষ্ট থাকলেও কথার মধ্যে অনেক মায়া।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "B5m8sYtnCvk");
        hashMap.put("vdo_title", "শুধু নিজের না, সবার চিন্তাই করতে হবে। ");
        hashMap.put("vdo_desciption", "শুধু নিজের না, সবার চিন্তাই করতে হবে। এই লকডাউন নিয়ে উনি সবার জন্য চিন্তিত।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "OPl56leYiso");
        hashMap.put("vdo_title", "আলহামদুলিল্লাহ্, আল্লাহ্ কুলছুমের জীবন পরিবর্তনের একটা সুযোগ করে দিলেন। ");
        hashMap.put("vdo_desciption", "আমার লাস্ট ভিডিওয়ের কুলছুমের কথা অনেক মানুষ শুনেছিলেন, সেই সাথে ছিলেন চাঁদপুরের জেলা প্রশাসক সহ অনেকেই । সেই কুলছুমের লেখাপড়া, তার বাবা মায়ের চিকিৎসা ও তাদের ঘর তৈরি করে দেয়ার দায়িত্ব নিলেন জেলা প্রশাসক, চাঁদপুর অঞ্জনা খান মজলিশ।   ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "ofp6zbIwXLg");
        hashMap.put("vdo_title", "১০ বছরের মেয়ে বলে, কষ্ট করলেই তো মিষ্টি মিলে। আর আমরা হতাশ হয়ে যাই এক নিমিষেই ।");
        hashMap.put("vdo_desciption", "১০ বছরের মেয়ে বলে, কষ্ট করলেই তো মিষ্টি মিলে। আর আমরা হতাশ হয়ে যাই এক নিমিষেই ।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "APG22xN7THg");
        hashMap.put("vdo_title", "মন কে আনন্দিত রাখতে অনেক কিছু করা যায়। ");
        hashMap.put("vdo_desciption", "মন কে আনন্দিত রাখতে অনেক কিছু করা যায়। ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "hW01u-j8zWo");
        hashMap.put("vdo_title", "এমন অনেক ফুটফুটে বাচ্চা আছে যারা খানিকটা সাপোর্ট পেলেই আর রাস্তায় ঘুমাতে হয় না। ");
        hashMap.put("vdo_desciption", "মারিয়া, মরিয়মের মত এমন অনেক ফুটফুটে বাচ্চা আছে যারা খানিকটা সাপোর্ট পেলেই আর রাস্তায় ঘুমাতে হয় না।   ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "yH5_TDKoGR8");
        hashMap.put("vdo_title", "এ রকম অনেক ছেলেমেয়ে আছে যারা ভিক্ষা করতে আগ্রহী না। ");
        hashMap.put("vdo_desciption", "এ রকম অনেক ছেলেমেয়ে আছে যারা ভিক্ষা করতে আগ্রহী না। কারন ভিক্ষা লজ্জার, ব্যাবসা গর্বের। ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "Tar1fuzcGys");
        hashMap.put("vdo_title", "ছোট ছোট দোয়া গুলোই হতে পারে আপনার পুলসিরাত পার হবার সিড়ি। ");
        hashMap.put("vdo_desciption", "ছোট ছোট দোয়া গুলোই হতে পারে আপনার পুলসিরাত পার হবার সিড়ি। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "nCz9Arorj0I");
        hashMap.put("vdo_title", "কোটি টাকা থাকলে ও আপনি দান করতে পারবেন না, যদি আল্লাহ্ না কবুল করে।");
        hashMap.put("vdo_desciption", "কোটি টাকা থাকলে ও আপনি দান করতে পারবেন না, যদি আল্লাহ্ না কবুল করে। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "a4m4S7S3kEc");
        hashMap.put("vdo_title", "A MAN WITH AN ONE BLIND EYE ( 90+ Age ) | Never Lose Hope | Firoz Hasan ");
        hashMap.put("vdo_desciption", "একটি মানুষ যার বয়স হয়েছে ৯০+ , যার একটি চোখ অন্ধ,সে মানুষ্টা হাল ছেড়ে দেয়না, আর হাল ছেড়ে দেই আমরা ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "D2mLhKuWQT4");
        hashMap.put("vdo_title", "চারদিকে এতো এতো ভেজাল জিনিষের ভিড়ে এরা বিক্রি করে ভালোবাসা । ");
        hashMap.put("vdo_desciption", "ছোট মেয়েটার যখন মনটা খারাপ হয়ে গিয়েছিলো তখন তাঁর চেহারোটার মধ্যে কেমন যেনো একটা মায়াবি রঙ ধারন করলো । যেটা অভিনয় করে দেখানো কখনোই সম্ভব না।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "8wH0Ux0OT_M");
        hashMap.put("vdo_title", "হতে পারে মেয়েটা বলেছিলো মা মাছ নিয়ে আইসো, তাই শুধু মাছের কথাটাই বলেছে।");
        hashMap.put("vdo_desciption", "ভিক্ষাবৃত্ত আল্লাহর রাসুল (সঃ) খুব অপছন্দ করতেন। তাই আমাদের উচিৎ সমাজ থেকে ভিক্ষাবৃত্তির অবসান ঘটানো।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "4o_sVjjI0e0");
        hashMap.put("vdo_title", "একটা পরিবারের কালো অধ্যায় নেমে আসার পিছনের গল্পটা খুবই ছোট । ");
        hashMap.put("vdo_desciption", "বিঃ দ্রঃ - ভিডিও দেখার পরে আপনারা অনেকেই হয়তো ভাববেন, এতো বড় ছেলেটা কি করে ?কেনো তাঁর মায়ের দেখভাল করতে পারছে না ? সে টাকা ইনকাম করলেই তো হয়।   ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "KibbYQn2Nc8");
        hashMap.put("vdo_title", "তিনজন মানুষ তিনটি কারনে মন খারাপ ছিলো, আমরা তাদের মন ভালো করার চেষ্টা করেছি মাত্র।");
        hashMap.put("vdo_desciption", "আমরা চাইলে খুব অল্পতে অন্য মানুষের মুখে হাসি ফুটাতে পারি, তাঁর মন ভালো করে দিতে পারি, ভিডিও তে দেখানো তিনজন মানুষ তিনটি কারনে মন খারাপ ছিলো, আমরা তাদের মন ভালো করার চেষ্টা করেছি মাত্র।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "7u4rrOht9cU");
        hashMap.put("vdo_title", "HOW TO SETUP A ACTION CAMERA IN A HELMET JUST 5 MINUTES | ");
        hashMap.put("vdo_desciption", "হেলমেটে ক্যামারা লাগানো অনেক সহজ একটা কাজ, ভিডিও টি দেখলে নিজে নিজেই লাগাতে পারবেন।   ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "YeBdd5TpKqM");
        hashMap.put("vdo_title", "এক খন্ড প্রাকৃতিক সুন্দর্য | ঢাকার পাশেই সবচেয়ে সুন্দর জায়গা । সারিঘাট, হাসনাবাদ, কেরানিগঞ্জ। ");
        hashMap.put("vdo_desciption", "এটি একটি প্রাকৃতিক কাশবনের লীলাভুমি , প্রকৃতি যেন নিজ হাতে এই পরিবেশটাকে সাজিয়েছে ।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "SdTToAwgFsY");
        hashMap.put("vdo_title", "Street Boy Selling chocolate for his Mother. ");
        hashMap.put("vdo_desciption", "যে সব ছেলে মেয়ে ভিক্ষা না করে ছোট খাটো ব্যাবসা করার চেষ্টা করে, এদের কাছ থেকে প্রয়োজনে বা অপ্রয়োজনে কিছু কিনার চেষ্টা করুন, এতে করে এরা ভিক্ষার দিকে না ঝুকে কাজের প্রতি আগ্রহী হবে। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "u7aZaigVKCU");
        hashMap.put("vdo_title", "মৃত্যু থেকে বাঁচতে মানুষের কত শত চেষ্টা । আর বৃদ্ধ মহিলা মাত্র ৫ কেজি চাউলের জন্য রাস্তায় ঘুরে।");
        hashMap.put("vdo_desciption", "মৃত্যু থেকে পালিয়ে বাঁচতে আমাদের কত শত চেষ্টা, আর বৃদ্ধ মহিলা মাত্র ২২৫ টাকার ৫ কেজি চাউলের জন্য রাস্তায় রাস্তায় ঘুরে।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "3FBSHTNa13k");
        hashMap.put("vdo_title", "পাহাড়ের শেষ মাথায় একটা স্কু্ল। কি অপরূপ দৃশ্যের কংলাক পাহাড়। ");
        hashMap.put("vdo_desciption", "পাহাড়ের শেষ মাথায় একটা স্কু্ল। তাঁরপরে আর রাস্তা নাই। কি অপরূপ দৃশ্যের কংলাক পাহাড়  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "XkUeTsS9pCk");
        hashMap.put("vdo_title", "লক্ষ লক্ষ গোলাপ ফুল | সাভার, গোলাপ গ্রাম | Rose Village | ");
        hashMap.put("vdo_desciption", "সাভারে অবস্থিত এই গোলাপ গ্রাম থেকে প্রতিদিন হাজার হাজার গোলাপ দেশের বিভিন্ন যায়গায় বিক্রি করা হয়। এখানে ঢুকতে কোন টাকা বা টিকে ট লাগে না। গুগোল মেপে Rose Village লিখলেই পেয়ে যাবেন।  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "Cc-xIAuvat0");
        hashMap.put("vdo_title", "লকডাউন | নিজের ছেলের কারনে আজকে পথের ফকির ");
        hashMap.put("vdo_desciption", "আপনার সামর্থ্যানুযায়ি আপনি চেষ্টা করুন দুর্দিনে অসহায় মানুষের পাশে দাড়াইতে, আল্লাহ আপনার উপকারের জন্য একদিন আরেকজন কে পাঠাবেন ।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "bg_Gdz3Bob8");
        hashMap.put("vdo_title", "Dhaka To Mawa | Bangladesh's First Expressway | Video With Behind the Scenes |  ");
        hashMap.put("vdo_desciption", "Dhaka To Mawa | Bangladesh's First Expressway | Video With Behind the Scenes |  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "GrKjqDJiM9M");
        hashMap.put("vdo_title", "কামরাইলে কি করমু বাবা ? A Message for Government |  ");
        hashMap.put("vdo_desciption", "রাস্তায় পরে থাকা মানুষদের মশারি টাঙ্গিয়ে ঘুমানোর মত পরিস্থিতি নাই, আর কয়েল জ্বলিয়ে মশা থেকে বাঁচা ও সম্ভব না, এদেরকে তো ঘরে নিয়ে যায়গা দিবেন না, তো প্লিজ মশার কামড় থেকে বাঁচান।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "k-RZ3O7TFcY");
        hashMap.put("vdo_title", "My Birthday Celebration | Free Motion By Firoz Hasan ");
        hashMap.put("vdo_desciption", "ভিডিও ফুটেজ টি গত ২৩ ফেব্রুয়ারী, ২০২০ এ করা। যেদিন আসলে আমার জন্মদিন ছিল উৎসর্গ করলাম সকল বাবা-মা কে। ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "eMIjIclIRLw");
        hashMap.put("vdo_title", "হাইমচর, চাঁদপুর | মেঘনা নদী | Another tourist spots In Chandpur | Mini cox’s Bazar |  ");
        hashMap.put("vdo_desciption", "হাইমচর, চাঁদপুর | মেঘনা নদী | Another tourist spots In Chandpur | Mini cox’s Bazar |  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "STbLaVa0GgE");
        hashMap.put("vdo_title", "সাজেক ট্যুর 2020 | Main Part | Khagrachari To Sajek |  ");
        hashMap.put("vdo_desciption", "সাজেক ট্যুর 2020 | Main Part | Khagrachari To Sajek |  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "oHfT1eskDq0");
        hashMap.put("vdo_title", "সাজেকের পথে বাচ্চা গুলোর হার্টবিট শুনুন | Sajek Tour 2020  ");
        hashMap.put("vdo_desciption", "আমার আগে জানা ছিলোনা বাচ্চা গুলোকে কিছু দিলে এতোটা খুশি হবে। আপনারা যখনি সাজেক যাবেন, চেষ্টা করবেন ওদের জন্য কিছু নিয়ে যেতে। কারন রাস্তার দুই পাশে এরা আপনাকে যে স্বাগতমটা জানায় তা আপনি এড়িয়ে যেতে পারবেন না।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "BQ4ZuVRGaTk");
        hashMap.put("vdo_title", "Heart Touching Violin Music | Night View With Moto Drive | Dhaka city ");
        hashMap.put("vdo_desciption", "Heart Touching Violin Music | Night View With Moto Drive | Dhaka city  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "MIPsA6K-Vrg");
        hashMap.put("vdo_title", "Megical Village Views with Moto Drive | Haimchar, Chandpur | GoPro Hero 7 black");
        hashMap.put("vdo_desciption", "Megical Village Views with Moto Drive | Haimchar, Chandpur | GoPro Hero 7 black  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "xkEQ7Bv3EuI");
        hashMap.put("vdo_title", "RAJUK Uttara Model Town | Building Emerging Dhaka City, sector 18 | GoPro 7 Black");
        hashMap.put("vdo_desciption", "RAJUK Uttara Model Town | Building Emerging Dhaka City, sector 18 | GoPro 7 Black  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "6UIUPyHPJMY");
        hashMap.put("vdo_title", "Suzuki SF Crash | কাঁশফুল | Green Model town , Manda | ");
        hashMap.put("vdo_desciption", "গুলিস্তান থেকে মুগদা। সেখানথেকে মান্ডা। সময় লাগবে 30-45 মিনিটস । অবাংাদেশ ইসলামিক ইউনিভারসিটি ক্যম্পাস এর মধ্যেই অবস্থিত। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "qSMa6lQLdnY");
        hashMap.put("vdo_title", "হাইওয়ের মারাত্মক এক্সিডেন্ট | Ena Vs Sadia Poribohon Crushed in Meghna Bridge |");
        hashMap.put("vdo_desciption", "6/Oct/2019 বিকালে চাঁদপুর থেকে আসার পথে, ঢাকা চিটাগাং  হাইওয়েতে এনা পরিবহন এবং সাদিয়া এন্টারপ্রাইজ নামক দুটি বাস মখোমুখি সংঘর্স হয়।   ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "aU-NA6nUL9A");
        hashMap.put("vdo_title", "চাঁদপুর বর্তমানে ইলিশের নয় অটোরিক্সার শহর | Talking About Chandpur City | ");
        hashMap.put("vdo_desciption", "চাঁদপুর শহরের একটি বড় সমস্যা হলো শহরের রাস্তায় অতিরিক্ত অটো-রিক্সা । এখনি যদি পরিকল্পনা অনুযায়ী এর একটি সমাধান বের করা না হয়, তাহলে দিন দিন শহরে যানজট এবং এক্সিডেন্ট বেড়েই চলবে।  ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "jg6ZNtAD-cM");
        hashMap.put("vdo_title", "ঢাকার মধ্যে সবচেয়ে সুন্দর জায়গা | Bashundhara Riverview | Sharighat , Keraniganj | ");
        hashMap.put("vdo_desciption", "akta short trip er jonno best akta jayga ,tmn kno khoroch o nai, postogola theke ekta CNG reserve   150 tk nibe , r sekhane giya jodi nowkate ghuren tahole per hour 130-160 tk nibe,  ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "rDpOdBlviFc");
        hashMap.put("vdo_title", "Most Beautiful Road in Bangladesh | Matlab Beribadh, Chandpur | Firoz Hasan");
        hashMap.put("vdo_desciption", "Most Beautiful Road in Bangladesh | Matlab Beribadh, Chandpur | Firoz Hasan ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "bx3KF1uBuoA");
        hashMap.put("vdo_title", "The Hidden Beauty of Chandpur│Part 01│District 01│Firoz Hasan");
        hashMap.put("vdo_desciption", "বহু বছরের পুরানো ঐতিহ্য আর গ্রামের মনরম পরিবেশ দেখে বিকালটা কাটাবেন চাঁদপুর বড় স্টেশন বা তিন নদীর মোহনা তে। তারপরে আপনার সময় মত করে রাতে লঞ্চে ভ্রমনের স্বাদ নিয়ে চলে আসবেন ঢাকা, লঞ্চ ভাড়া 100tk থেকে শুরু।   ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("vdo_id", "UiFe4-Fn-bA");
        hashMap.put("vdo_title", "এতো কষ্টেও চলছে এদের জীবন, অথচ আমি আপনি কতো হতাশ !");
        hashMap.put("vdo_desciption", "নানা সমস্যাকে সংগী করে এদের মতো মানুষেরা দিব্যি জীবন পার করছে। আর আমরা আছি শুধু হায় হুতাশ নিয়ে, কখনো চিন্তা করি না যে, আল্লাহ  আমাদের কতোটা ভালো রেখেছে।");
        arrayList.add(hashMap);


    }
    //============================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, initializationStatus -> {
        });


        tvDate = findViewById(R.id.tvDate);
        layoutContainer = findViewById(R.id.layoutContainer);
        fabButton = findViewById(R.id.fabButton);
        _rootLay = findViewById(R.id._rootLay);
        jPlayer = findViewById(R.id.jPlayer);
        layPlayer = findViewById(R.id.layPlayer);
        imngClosePlayer = findViewById(R.id.imngClosePlayer);
        imgPlayPause = findViewById(R.id.imgPlayPause);
        imgNext = findViewById(R.id.imgNext);
        imgPrevious = findViewById(R.id.imgPrevious);

        // Load Admob Ads
        loadFullscreenAd();


        /**
         Author: Sharif Uddin Jumman
         Email: sharifuddinjumman@gmail.com, arsharifuddinjumman04@gmail.com
         Location: Dhaka, Bangladesh
         */

        //init JPlayer
        jPlayer.initialize("Sharif Uddin Jumman (Jummania)", MainActivity.this);
        jPlayer.setOnPlayingListener(isPlaying -> {
            if (isPlaying) onPlaying();
            else onPaused();
        });

        /**
         Author: Sharif Uddin Jumman
         Email: sharifuddinjumman@gmail.com, arsharifuddinjumman04@gmail.com
         Location: Dhaka, Bangladesh
         */

        //Set Date For Cover Section
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
        formatter.setTimeZone(TimeZone.getDefault());
        Date date1 = new Date();
        String s_date = formatter.format(date1);
        tvDate.setText(s_date);


        //Calling addVideos method by which we will make a video list
        addVideos();
        makeListView();


        //Fab Button onClick
        fabButton.setOnClickListener(v -> {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Check " + getString(R.string.app_name) + " app ♥ It's awesome! \n" + "https://play.google.com/store/apps/details?id=");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        });

        imngClosePlayer.setOnClickListener(v -> {
            closePlayer();
            fabButton.setVisibility(View.VISIBLE);
            playingVideo = false;


        });

        imgPlayPause.setOnClickListener(v -> {

            if (v != null && v.getTag() != null) {
                String tag = v.getTag().toString();
                if (tag.contains("PLAYING")) {
                    if (jPlayer != null) jPlayer.pause();
                    else
                        Toast.makeText(MainActivity.this, "Please wait...", Toast.LENGTH_LONG).show();

                } else if (tag.contains("PAUSED")) {
                    if (jPlayer != null) jPlayer.play();
                    else
                        Toast.makeText(MainActivity.this, "Please wait...", Toast.LENGTH_LONG).show();
                }
            }


        });

        imgNext.setOnClickListener(v -> playNextVideo());

        imgPrevious.setOnClickListener(v -> playPreviousVideo());


    } // End of onCreate Bundle

    // loadFullscreenAd method ENDS  here..... >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    ///==============================================
    ///==============================================


    ///==============================================
    ///==============================================


    ///==============================================
    ///==============================================

    private void makeListView() {

        ListView listView = new ListView(MainActivity.this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 10);
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        listView.setBackgroundColor(Color.WHITE);
        listView.setLayoutParams(layoutParams);

        //Adding ListView into our view
        layoutContainer.addView(listView);
        //------------
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        //-----------


        try {
            setListViewHeightBasedOnChildren(listView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        layoutContainer.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in));

    }

    public void onPaused() {
        //updateLog("onPaused()");

        if (imgPlayPause != null) {
            imgPlayPause.setImageResource(R.drawable.icon_play);
            imgPlayPause.setTag("PAUSED");
        }

        //Toast.makeText(getApplicationContext(), "Paused", Toast.LENGTH_SHORT).show();
    }

    public void onPlaying() {

        if (imgPlayPause != null) {
            imgPlayPause.setImageResource(R.drawable.icon_pause);
            imgPlayPause.setTag("PLAYING");
        }

    }

    //==============================================
    private void showInterstitial() {
        // Show the ad if it's ready.
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        }
    }

    // loadFullscreenAd method starts here.....
    private void loadFullscreenAd() {

        //Requesting for a fullscreen Ad
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, getString(R.string.admob_INTERSTITIAL_UNIT_ID), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;

                //Fullscreen callback || Requesting again when an ad is shown already
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when fullscreen content is dismissed.
                        //User dismissed the previous ad. So we are requesting a new ad here
                        loadFullscreenAd();

                        if (playingVideo && jPlayer != null && !jPlayer.isPlaying()) {

                            Handler handler = new Handler(Looper.getMainLooper());

                            handler.postDelayed(() -> {

                                jPlayer.play();
                                playingVideo = false;

                            }, 500);

                        }


                    }


                }); // FullScreen Callback Ends here


            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                mInterstitialAd = null;
            }


        });

    }

    //================================================
    private void playVideo(String video_id) {

        if (jPlayer != null) {
            layPlayer.setVisibility(View.VISIBLE);
            layPlayer.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in));
            jPlayer.loadVideo(video_id);
            jPlayer.play();
            playingVideo = true;
        } else {
            Toast.makeText(MainActivity.this, "Please wait...", Toast.LENGTH_LONG).show();
        }
    }

    //*******************************************************************


    //=================================================================

    //================================================
    private void closePlayer() {
        if (jPlayer != null && jPlayer.isPlaying()) jPlayer.pause();
        layPlayer.setVisibility(View.GONE);
        layPlayer.clearAnimation();
    }
    //==============================================================

    //=================================================
    private void playNextVideo() {
        if (PLAYING_NOW >= (arrayList.size() - 1)) PLAYING_NOW = 0;
        else PLAYING_NOW++;

        HashMap<String, String> hashMap = arrayList.get(PLAYING_NOW);
        String vdo_id = hashMap.get("vdo_id");
        playVideo(vdo_id);
    }


    private void playPreviousVideo() {
        if (PLAYING_NOW > 0) {
            PLAYING_NOW--;
            HashMap<String, String> hashMap = arrayList.get(PLAYING_NOW);
            String vdo_id = hashMap.get("vdo_id");
            playVideo(vdo_id);
        } else {
            Toast.makeText(MainActivity.this, "Playing the first video", Toast.LENGTH_LONG).show();
        }

    }


    ///==============================================
    ///==============================================
    //===================================================


    //==========================================================================
//==========================================================================

    // When user click bakpress button this method is called
    @Override
    public void onBackPressed() {
        // When user press back button

        if (layPlayer.getVisibility() == View.GONE) {
            if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) super.onBackPressed();
            else Toast.makeText(getBaseContext(), "Press again to exit", Toast.LENGTH_SHORT).show();
            mBackPressed = System.currentTimeMillis();
        } else closePlayer();

    } // end of onBackpressed method

    protected boolean isAppInstalled(String packageName) {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage(packageName);
        return mIntent != null;
    }

    //=======================================================
    //method to show a dialog in android
    private void showYoutubeInsallDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Install Youtube App");
        alertDialog.setMessage(getString(R.string.app_name) + " will not work if you don't have youtube official app installed on your device");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Install NOW", (dialog, which) -> {
            //dialog.dismiss();
            openStoreIntent();
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Exit App", (dialog, which) -> {
            //Exit App
            finishAndRemoveTask();
        });

        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    //=================================================
    ///==============================================
    ///==============================================
    ///==============================================
    //try to download youtube app from app stores
    private void openStoreIntent() {
        String url;
        Intent storeintent;
        try {
            url = "market://details?id=" + "com.google.android.youtube";
            storeintent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            storeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            startActivity(storeintent);
        } catch (final Exception e) {
            url = "https://play.google.com/store/apps/details?id=" + "com.google.android.youtube";
            storeintent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            storeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            startActivity(storeintent);
        }

    }

    //#############################################################################################

    private class MyAdapter extends BaseAdapter {
        private final LayoutInflater inflater;

        public MyAdapter() {
            this.inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.video_item, parent, false);

            TextView tvTitle = convertView.findViewById(R.id.tvTitle);
            TextView tvDescription = convertView.findViewById(R.id.tvDescription);
            ImageView imgThumb = convertView.findViewById(R.id.imgThumb);
            RelativeLayout layItem = convertView.findViewById(R.id.layItem);

            HashMap<String, String> hashMap = arrayList.get(position);
            String vdo_id = hashMap.get("vdo_id");
            String vdo_title = hashMap.get("vdo_title");
            String vdo_desciption = hashMap.get("vdo_desciption");

            tvTitle.setText(vdo_title);
            tvDescription.setText(vdo_desciption);

            // Youtube thumnail link is like
            //https://i.ytimg.com/vi/<VIDEO ID>/0.jpg
            String thumb_link = "https://i.ytimg.com/vi/" + vdo_id + "/0.jpg";
            Picasso.get().load(thumb_link).placeholder(R.mipmap.ic_launcher).into(imgThumb);

            layItem.setOnClickListener(v -> {

                fabButton.setVisibility(View.GONE);

                //Play Video
                PLAYING_NOW = position;
                playVideo(vdo_id);
                showInterstitial();


            });


            return convertView;
        }
    }

}