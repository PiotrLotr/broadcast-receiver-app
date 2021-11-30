package com.example.secondapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var notificationService = MyService()

        notificationService.startService(intent)
    }

}


