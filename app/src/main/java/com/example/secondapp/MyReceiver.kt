package com.example.secondapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        var serviceIntent = Intent(context, MyService::class.java)
        Toast.makeText(context, intent.getStringExtra("productID"),Toast.LENGTH_SHORT).show()
//      serviceIntent.putExtra("productID", intent.getStringExtra("productID") )
        serviceIntent.putExtra("productName", intent.getStringExtra("productName") )

        context.startForegroundService(serviceIntent)
    }


}


