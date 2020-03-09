package com.example.wifiapp

import android.content.BroadcastReceiver
import android.content.Context
import android.net.wifi.p2p.WifiP2pManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val manager: WifiP2pManager? by lazy(LazyThreadSafetyMode.NONE){
        getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager?
    }
    var mChannel: WifiP2pManager.Channel? = null
    var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mChannel = manager?.initialize(this, mainLooper, null)
        mChannel?.also {channel -> // confused on WiFiDirectBroadcastReceiver
            receiver = WiFiDirectBroadcastReceiver(manager,channel,this)
        }


    }

    override fun onRecieve(context: Context, intent: Intent){
        val action: String =intent.action
        when(action){
            WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION ->{
                val state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE,-1)
                when (state){
                    WifiP2pManager.WIFI_P2P_STATE_ENABLED -> {

                    }
                    //p2p enabled
                    else -> {

                    }
                }   //p2p disabled
            }

        }
    }
}
