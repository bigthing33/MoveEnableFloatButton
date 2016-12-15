package com.cyq.moveenablefloatbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.cyq.moveenablefloatbutton.library.FloatingActionWidget;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionWidget floatingActionWidget = new FloatingActionWidget(this);
        SubActionButton button1 = floatingActionWidget.buildSubActionButton(android.R.drawable.ic_menu_edit, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "你点到我了1", Toast.LENGTH_LONG).show();
            }
        });
        floatingActionWidget.addSubButton(button1);
        SubActionButton button2 = floatingActionWidget.buildSubActionButton(android.R.drawable.ic_menu_edit, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "你点到我了2", Toast.LENGTH_LONG).show();
            }
        });
        ;
        floatingActionWidget.addSubButton(button2);
        floatingActionWidget.setMainButtonIcon(R.mipmap.ic_launcher);
        floatingActionWidget.build();
    }
}
