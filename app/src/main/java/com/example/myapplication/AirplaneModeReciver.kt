package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast


class AirplaneModeReciver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var  sms = SmsManager.getDefault();
        val bundle = intent!!.extras
        Log.d("SmsReceiver", "senderNum: ; message: ")
        try {
            if (bundle != null) {
                val pdusObj = bundle["pdus"] as Array<Any>?
                for (i in pdusObj!!.indices) {
                    val currentMessage: SmsMessage =
                        SmsMessage.createFromPdu(pdusObj!![i] as ByteArray)
                    val phoneNumber: String = currentMessage.displayOriginatingAddress
                    val message: String = currentMessage.displayMessageBody
                    Log.d("SmsReceiver", "senderNum: $phoneNumber; message: $message")


                    // Show alert
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(
                        context,
                        "senderNum: $phoneNumber, message: $message", duration
                    )
                    toast.show()
                } // end for loop
            } // bundle is null
        } catch (e: Exception) {
            Log.e("SmsReceiver", "Exception smsReceiver$e")
        }
//        if(intent?.action=="com.journaldev.broadcastreceiver.SOME_ACTION"){
//            Toast.makeText(context, "sms received", Toast.LENGTH_LONG).show()
//        }
//        // if getBooleanExtra contains null value,it will directly return back
//        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
//
//        // checking whether airplane mode is enabled or not
//        if (isAirplaneModeEnabled) {
//            // showing the toast message if airplane mode is enabled
//            Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_LONG).show()
//        } else {
//            // showing the toast message if airplane mode is disabled
//            Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_LONG).show()
//        }
    }


}