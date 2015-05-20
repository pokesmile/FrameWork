package com.pokesmile.framework;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Norbert on 2015.05.20..
 */
public class WebAppInterface {
    Context mContext;
    Activity activity;
    WebView webView;

    /**
     * Instantiate the interface and set the context
     */
    WebAppInterface(Context c, WebView w) {
        mContext = c;
        activity = (Activity) c;
        webView = w;
    }

    public void javascriptCall(String method, String string) {

        final String webUrl = "javascript:" + method + "('" + string + "');";
        // Add this to avoid android.view.windowmanager$badtokenexception unable to add window
        if (!activity.isFinishing())
            // loadurl on UI main thread
            activity.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    webView.loadUrl(webUrl);
                }
            });
    }

    @JavascriptInterface
    public void callBack() {
        javascriptCall("callback", "Test message");
    }

    /**
     * Show Toast Message
     *
     * @param toast
     */

    @JavascriptInterface
    public void makeToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show Dialog
     *
     * @param dialogMsg
     */
    @JavascriptInterface
    public void makeDialog(String dialogMsg) {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();

        // Setting Dialog Title
        alertDialog.setTitle("JS triggered Dialog");

        // Setting Dialog Message
        alertDialog.setMessage(dialogMsg);

        // Setting alert dialog icon
        //alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mContext, "Dialog dismissed!", Toast.LENGTH_SHORT).show();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
}
