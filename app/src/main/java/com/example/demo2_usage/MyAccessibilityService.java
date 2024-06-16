package com.example.demo2_usage;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MyAccessibilityService extends AccessibilityService {
//    TextView textView;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
//         textView = textView.findViewById(R.id.textView123);

        List<String> keywords = Arrays.asList("love","nude");
//        UsageStatsManager usageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);


        final int eventType = event.getEventType();
        final  int packageevent = event.getEventType();
        String eventText = null;
        String packagename = null;


        switch(eventType) {

            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
                eventText = "Typed: ";
                break;
        }
        eventText = eventText + event.getText();
        packagename = String.valueOf(event.getPackageName());

        System.out.println("ACCESSIBILITY SERVICE : "+packagename+"Typed TEXT"+eventText);
//        Toast.makeText(this, "ACCESSIBILITY SERVICE "+eventText, Toast.LENGTH_SHORT).show();
//        textView.setText(eventText);
        for( String keyword : keywords)
        {
            if (eventText.toString().toLowerCase().contains(keyword.toLowerCase()))
            {
                System.out.println("ALEREt");
                break;
            }
        }
    }
    @Override
    public void onInterrupt() {

    }

    @Override
    public void onServiceConnected() {
        AccessibilityServiceInfo info=getServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;
        info.notificationTimeout = 100;
        this.setServiceInfo(info);
    }

}