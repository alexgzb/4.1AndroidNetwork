package com.gezelbom.app41;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayoutYoutubeLinks);
        TextView[] youtubeLinks = new TextView[ll.getChildCount()];
        for (int i = 0; i < ll.getChildCount(); i++){
            View v = ll.getChildAt(i);
            if (v instanceof TextView) {
                youtubeLinks[i] = (TextView)v;
                youtubeLinks[i].setMovementMethod(LinkMovementMethod.getInstance());
                //Log.d(TAG,"TextView " +  i + " = " + ((TextView) v).getText());
            }
        }

    }

    public void youtubeLink(View v) {
        TextView tv = (TextView)v;
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + tv.getText() ));
        startActivity(i);
    }

    public void browserLink(View v) {
        TextView tv = (TextView)v;
        Intent i = new Intent(getApplicationContext(),BrowserActivity.class);

        //Log.d(TAG, "The url normal " + tv.getText());
        //Log.d(TAG,"The url with html.fromthml " + Html.fromHtml(tv.getText().toString()));

        // Double cast by purpose, for some reason it sends a spannableString if not double cast
        i.putExtra("url", (String)tv.getText().toString());
        startActivity(i);
    }
}
