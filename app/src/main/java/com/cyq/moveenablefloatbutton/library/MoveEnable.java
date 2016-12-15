package com.cyq.moveenablefloatbutton.library;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by win7 on 2016/12/15.
 */

public class MoveEnable {
    private static final String TAG = MoveEnable.class.getSimpleName();
    //移动位置用
    private int mLastX;
    private int mLastY;
    private int mDownX;

    private int mDownY;
    private final int ADAPTER_VALUE = 25;

    public void setMoveEnable(final View view){
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x = (int) motionEvent.getRawX();
                int y = (int) motionEvent.getRawY();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        mDownX = (int) motionEvent.getRawX();
                        mDownY = (int) motionEvent.getRawY();
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        int deltaX = x - mLastX;
                        int deltaY = y - mLastY;
                        Log.d(TAG, "move, deltaX:" + deltaX + " deltaY:" + deltaY);

                        int translationX = (int) view.getTranslationX() + deltaX;
                        int translationY = (int) view.getTranslationY() + deltaY;
                        view.setTranslationX(translationX);
                        view.setTranslationY(translationY);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        if (DataUtils.rangeInDefined(mDownX, (int) motionEvent.getRawX() - ADAPTER_VALUE, (int) motionEvent.getRawX() + ADAPTER_VALUE)) {
                            if (DataUtils.rangeInDefined(mDownY, (int) motionEvent.getRawY() - ADAPTER_VALUE, (int) motionEvent.getRawY() + ADAPTER_VALUE)) {
                                view.callOnClick();
                            }
                        }
                        break;
                    }
                    default:
                        break;
                }

                mLastX = x;
                mLastY = y;
                return true;
            }
        });
    }
}
