package com.example.mylayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/11/2212:38
 * desc   :
 * package: Text:
 */
public class MyViewPager extends ViewGroup {
    private int lastX;
    private int lastY;
    private Scroller scroller;
    private int childWidth = 0;
    private int currentIndex = 0;
    private int currentX = 0;
    private int curretY = 0;

    private VelocityTracker tracker;


    public MyViewPager(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        scroller = new Scroller(context);
        tracker = VelocityTracker.obtain();
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int lefe = 0;
        View child;
        for (int i = 0; i < childCount; i++) {
            child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                childWidth = child.getMeasuredWidth();
                child.layout(lefe, 0, lefe + childWidth, child.getMeasuredHeight());
                lefe += childWidth;
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizewid = MeasureSpec.getSize(widthMeasureSpec);
        int modewid = MeasureSpec.getMode(widthMeasureSpec);
        int modehei = MeasureSpec.getMode(heightMeasureSpec);
        int sizehei = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        } else if (modewid == MeasureSpec.AT_MOST && modehei == MeasureSpec.AT_MOST) {
            View childAt = getChildAt(0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            //子类的高度
            setMeasuredDimension(getChildCount() * measuredWidth, measuredHeight);

        } else if (modewid == MeasureSpec.AT_MOST) {
            View childAt = getChildAt(0);
            int measuredWidth = childAt.getMeasuredWidth();
            //xml的高度
            setMeasuredDimension(measuredWidth * getChildCount(), sizehei);
        } else if (modehei == MeasureSpec.AT_MOST) {
            View childAt = getChildAt(0);
            int measuredHeight = childAt.getMeasuredHeight();
            //高度是子类的高度
            setMeasuredDimension(sizewid, measuredHeight);
        }


    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercrpt = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int delatX = x - lastX;
                int delatY = y - lastY;
                if (Math.abs(delatX) > Math.abs(delatY)) {
                    intercrpt = true;
                }
                break;
        }
        lastY = y;
        lastX = x;

        return intercrpt;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int delaX = x - lastX;
                int delaY = y - lastY;
                scrollBy(-delaX, 0);
                break;
            case MotionEvent.ACTION_UP:
                //此次滑动的距离
                int distance = getScrollX() - childWidth * currentIndex;
                if (Math.abs(distance) > childWidth / 2) {
                    if (distance > 0) {
                        currentIndex++;
                    } else {
                        currentIndex--;
                    }
                } else {
                    //获得当时滑动sulv
                    tracker.computeCurrentVelocity(1000);
                    float xV = tracker.getXVelocity();
                    if (Math.abs(xV) > 50) {
                        currentIndex++;
                    } else {
                        currentIndex--;
                    }
                }
                //三目连用
                currentIndex = currentIndex < 0 ? 0 : currentIndex > getChildCount() - 1 ? getChildCount() - 1 : currentIndex;
                smoothScrollTo(currentIndex * childWidth, 0);
                tracker.clear();
        }
        lastX = x;
        lastY = y;
        return true;
    }

    private void smoothScrollTo(int destX, int destY) {

        scroller.startScroll(getScrollX(), getScrollY(), destX - getScrollX(), destY - getScrollY(), 1000);
        invalidate();

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }
}
