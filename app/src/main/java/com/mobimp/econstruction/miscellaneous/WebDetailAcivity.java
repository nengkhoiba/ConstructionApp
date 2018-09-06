package com.mobimp.econstruction.miscellaneous;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobimp.econstruction.R;

public class WebDetailAcivity extends AppCompatActivity {


     public static String url="";
    TextView share;
    ImageView back;
    ProgressBar webprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_news_web_view);

        share=(TextView) findViewById(R.id.txt_webShare);
        back=(ImageView) findViewById(R.id.img_web_back);
        webprogress=(ProgressBar) findViewById(R.id.progress_bar_web);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareTextUrl(url);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        loadUrlWithWebView(url);
    }

    private void shareTextUrl(String Url) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT,"Share by W2w");
        share.putExtra(Intent.EXTRA_TEXT, Url);

        startActivity(Intent.createChooser(share, "Share Article"));
    }
    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // Loading started for URL
            webprogress.setVisibility(View.VISIBLE);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Redirecting to URL
            loadUrlWithWebView(url);
            return false;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            // Loading finished for URL
            webprogress.setVisibility(View.GONE);
        }
    };

    public void loadUrlWithWebView(String url) {
        WebView webView = (WebView) findViewById(R.id.webViewNews);
        webView.setWebViewClient(webViewClient);
        webView.loadUrl(url);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
