package com.example.weather.helpers


import android.Manifest
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.example.weather.fragments.GPSFragmentInterface


class LocationByGPS(val gps: GPSFragmentInterface): Application(),LocationListener {
    private lateinit var locationManager: LocationManager
    private val locationPermissionCode = 2
    fun getLocation(activity:Activity) {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
    }

    override fun onLocationChanged(p0: Location) {
        gps.setLatAndLon(p0.latitude,p0.longitude)
    }



}