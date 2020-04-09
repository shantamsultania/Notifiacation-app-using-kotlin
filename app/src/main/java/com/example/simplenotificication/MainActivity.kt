package com.example.simplenotificication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // for notifications we use three basic things
    // notification channel,notification builder , notification builder

   // lateinit var builder: Notification.Builder
   // lateinit var notificationManager : NotificationManager
   // lateinit var notificationChannel : NotificationChannel
    private  var channel_id : String = "com.example.simplenotificication"
    private var channel_name: String = "com.example.simplenotificication"
    private var channel_des : String = "this is a test channel in kotlin"



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channel_id,channel_name,NotificationManager.IMPORTANCE_DEFAULT).apply {
                description=channel_des
            }
            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }
        send_btn.setOnClickListener {
            displayNotification()
        }
    }





    private fun displayNotification () {

            var builder = NotificationCompat.Builder(this, channel_id)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Notification")
                .setContentText("this is your first notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

           var notification : NotificationManagerCompat = NotificationManagerCompat.from(this)
            notification.notify(123,builder.build())

    }

}
