package com.example.ssafybus

import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_new_route.*
import java.util.*

class NewRouteActivity : AppCompatActivity() {
    private var locationManager: LocationManager? = null
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_route)

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?

        fab.setOnClickListener {
            Start()
        }
    }

    fun Start() {
        var second: TimerTask = object : TimerTask() {
            override fun run() {
                Update()
            }
        }

        var timer = Timer()
        timer.schedule(second, 0, 1000)
    }

    fun Update() {
        var updater = Runnable {
            try {
                // Request location updates
                locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)
            } catch (ex: SecurityException) {
                Log.d("myTag", "Security Exception, no location available");
            }
        }
        handler.post(updater)
    }

    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            loc_x.setText("$location.latitude")
            loc_y.setText("$location.longitude")
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

}
