package com.example.socialfeedbacksample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.web.MyWebChromeClient;
import com.example.web.MyWebViewClient;

public class MainActivity extends Activity
	implements OnClickListener
{
	private final String GREE_SHARE_URL = "http://gree.jp/?mode=share&act=write&url=";
	private final String GREE_SHARE_TYPE = "&type=2&height=20";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Activityにプログレスバーを表示可能にする。
        requestWindowFeature(Window.FEATURE_PROGRESS);

        setContentView(R.layout.main);

        ImageButton btn = (ImageButton)findViewById(R.id.btnGree);
        btn.setOnClickListener(this);

        WebView webview = (WebView)findViewById(R.id.webview);
        //JavaScriptを有効に。
        webview.getSettings().setJavaScriptEnabled(true);

        //入力フォームを有効に。
        webview.requestFocus(View.FOCUS_DOWN);

        //importしたwebパッケージを有効に。
        webview.setWebViewClient(new MyWebViewClient(this));
        webview.setWebChromeClient(new MyWebChromeClient(this));
    }

    public void onClick(View v)
    {
    	int id = v.getId();
    	if(id == R.id.btnGree)
    	{
    		EditText edit = (EditText)findViewById(R.id.editurl);
    		String strEditUrl = edit.getText().toString();

    		WebView webview = (WebView)findViewById(R.id.webview);
    		webview.loadUrl(GREE_SHARE_URL + Uri.encode(strEditUrl) + GREE_SHARE_TYPE);
    	}

    }
}