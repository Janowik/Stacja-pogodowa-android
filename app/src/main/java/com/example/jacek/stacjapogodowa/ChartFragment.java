package com.example.jacek.stacjapogodowa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class ChartFragment extends Fragment {


    public ChartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        final WebView webView1 = (WebView) view.findViewById(R.id.chart_webView1);
        webView1.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        //wlaczamy obsluge JavaScript
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.loadUrl("http://stacja-pogodowa.cba.pl/android_chart.html");
        return view;
    }
}