package com.cyq.moveenablefloatbutton.library;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

/**
 * Created by win7 on 2016/12/15.
 */

public class FloatingActionWidget {
    private static final String TAG = FloatingActionWidget.class.getSimpleName();
    private Activity mActivity;
    private FloatingActionButton.Builder mFloatingActionButtonBuilder;
    private FloatingActionMenu.Builder mFloatingActionMenuBuilder;

    private FloatingActionButton mFloatingActionButton;


    public FloatingActionWidget(Activity activity) {
        mActivity = activity;
        mFloatingActionButtonBuilder = new FloatingActionButton.Builder(activity);
        mFloatingActionMenuBuilder = new FloatingActionMenu.Builder(activity);
    }

    public void addSubButton(SubActionButton buildSubActionButton) {
        mFloatingActionMenuBuilder.addSubActionView(buildSubActionButton);
    }

    public void build() {
        setMoveByFinger();
        mFloatingActionMenuBuilder.attachTo(mFloatingActionButton);
        mFloatingActionMenuBuilder.build();
    }

    public void setMainButtonIcon(int resourceId) {
        ImageView icon = new ImageView(mActivity); // Create an icon
        icon.setImageResource(resourceId);
        mFloatingActionButtonBuilder.setContentView(icon);
    }


    public SubActionButton buildSubActionButton(int iconResourceId, View.OnClickListener listener) {
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(mActivity);
        ImageView itemIcon = new ImageView(mActivity);
        itemIcon.setImageResource(iconResourceId);
        SubActionButton build = itemBuilder.setContentView(itemIcon).build();
        build.setOnClickListener(listener);
        return build;
    }

    public FloatingActionButton getFloatingActionButton() {
        return mFloatingActionButton;
    }

    public void setFloatingActionButton(FloatingActionButton floatingActionButton) {
        mFloatingActionButton = floatingActionButton;
    }

    /**
     * 设置随手指滑动移动按钮
     */
    private void setMoveByFinger() {
        mFloatingActionButton = mFloatingActionButtonBuilder.build();
        MoveEnable moveEnable = new MoveEnable();
        moveEnable.setMoveEnable(mFloatingActionButton);
    }
}
