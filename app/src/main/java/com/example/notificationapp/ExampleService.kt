package com.example.notificationapp

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.annotation.Nullable
import androidx.core.app.NotificationCompat.Builder
import com.example.notificationapp.App.Companion.CHANNEL_ID

class ExampleService: Service() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val input = intent.getStringExtra("inputExtra")
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,
                                                      0, notificationIntent, 0)
        val notification = Builder(this, CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(pendingIntent)
                .build()

        startForeground(1, notification)

        //do heavy work on a background thread
        //stopSelf();
        return START_NOT_STICKY
    }

    // override fun onDestroy() {
    //     super.onDestroy()
    // }

    @Nullable
    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}