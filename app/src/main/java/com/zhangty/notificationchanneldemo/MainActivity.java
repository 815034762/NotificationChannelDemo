package com.zhangty.notificationchanneldemo;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationHelper notificationHelper;
    private static final int NOTI_PRIMARY1 = 1100;
    private static final int NOTI_PRIMARY2 = 1101;
    private static final int NOTI_SECONDARY1 = 1200;
    private static final int NOTI_SECONDARY2 = 1201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationHelper = new NotificationHelper(this);
        notificationHelper.crateNotification(NotificationHelper.PRIMARY_CHANNEL, "创建第一条通知");
        notificationHelper.crateNotification(NotificationHelper.SECONDARY_CHANNEL, "创建第二条通知");

        findViewById(R.id.tv_send_notify1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationHelper.sendNotifycation("第一条通知的标题", "第一条通知的内容", NotificationHelper.PRIMARY_CHANNEL, NOTI_PRIMARY1);
            }
        });

        findViewById(R.id.tv_send_notify2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notificationHelper.sendNotifycation("第二条通知的标题", "第二条通知的内容", NotificationHelper.PRIMARY_CHANNEL, NOTI_PRIMARY2);
            }
        });

        findViewById(R.id.tv_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                i.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                startActivity(i);
            }
        });


    }
}
