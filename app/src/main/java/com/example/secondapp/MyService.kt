package com.example.secondapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MyService : Service() {

    // class variables:
    private val channelName = "channel_name"
    private val channelID = 1
    private val notificationChannelDescription = "notification_description"
    var id = 0
//  val requestCode = 1

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        createNotificationChannel()
        var productName = intent.getStringExtra("productName")

        Toast.makeText(
            this,
            "Receiver odebrał: "+ intent.getStringExtra("str1"),
            Toast.LENGTH_SHORT
        ).show()

        // permissions:
//        val pendingIntent = PendingIntent.getActivity(
//            this,
//            requestCode,
//            intent,
//        PendingIntent.FLAG_UPDATE_CURRENT
//        )

        val notification = NotificationCompat.Builder(this, channelID.toString())
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Added product: "+productName)
            .setContentText("Click to edit...")
//          .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(id++, notification)

        return START_STICKY
    }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            return
        val notificationChannel = NotificationChannel(
            channelID.toString(),
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationChannel.description = notificationChannelDescription
        val  notificationManager  = NotificationManagerCompat.from(this)
        notificationManager.createNotificationChannel(notificationChannel)
    }

}