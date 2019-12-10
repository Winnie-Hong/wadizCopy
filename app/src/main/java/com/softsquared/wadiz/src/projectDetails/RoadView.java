package com.softsquared.wadiz.src.projectDetails;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

public class RoadView extends WebView {

    public RoadView(Context context) {
        super(context);
    }

    public RoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoadView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(event);
    }
}
