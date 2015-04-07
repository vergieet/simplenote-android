package com.automattic.simplenote.widget;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.automattic.simplenote.R;

/**
 * Template for widget configuration activity.  By default this closes autmatically after
 * 3 seconds.
 *
 * TODO: graphic designers may decide that no configuration is necessary.  Delete this class if so.
 * <p/>
 * Created by richard on 8/30/14.
 */
public class ConfigureWidget extends Activity {

    private static final String TAG = ConfigureWidget.class.getSimpleName();
    private int mWidgetId;

    private Handler mHandler = new Handler();

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.widget_configure_layout);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);

        }

        setResult(RESULT_CANCELED);
        mHandler.postDelayed(new Runnable() {
            public void run() {
                Intent resultValue = new Intent();
                resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mWidgetId);
                setResult(RESULT_OK, resultValue);
                finish();
            }
        }, 3000);

    }
}
