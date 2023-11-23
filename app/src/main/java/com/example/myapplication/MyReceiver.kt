package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("MyReceiver", "received ")
        Toast.makeText(context, "AiDisabled", Toast.LENGTH_LONG).show()

    }
}