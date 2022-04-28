package com.ex.volunteerfinder

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.widget.Toast

import com.google.android.gms.maps.model.LatLng
import java.io.IOException
import java.util.*

fun reverseGeocoder(context: Context, lat:Double, lng:Double):String{

    val mGeocoder = Geocoder(context, Locale.getDefault())
    var addressString= ""

    // Reverse-Geocoding starts
    try {
        val addressList: List<Address> = mGeocoder.getFromLocation(lat, lng, 1)

        // use your lat, long value here
        if (addressList != null && addressList.isNotEmpty()) {
            val address = addressList[0]


            return address.getAddressLine(0)


        }
    } catch (e: IOException) {
        Toast.makeText(context,"Unable connect to Geocoder ${e.message}", Toast.LENGTH_LONG).show()
    }

    // Finally, the address string is posted in the textView with LatLng.
    return addressString

}

fun Geocoder(context: Context, address:String):LatLng{

    val mGeocoder = Geocoder(context, Locale.getDefault())

    var loc = LatLng(googleHQ.latitude, googleHQ.longitude)

    // Reverse-Geocoding starts
    try {
        val location = mGeocoder.getFromLocationName(address, 1)

        // use your lat, long value here
        if (location != null ) {

            loc = LatLng(location[0].latitude, location[0].longitude)

        }
    } catch (e: IOException) {
        Toast.makeText(context,"Unable connect to Geocoder ${e.message}", Toast.LENGTH_LONG).show()
    }
    catch (e: Exception) {

    }

    // Finally, the address string is posted in the textView with LatLng.
    return loc

}
