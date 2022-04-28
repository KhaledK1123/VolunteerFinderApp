package com.ex.volunteerfinder

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
//import com.example.instatask.ui.app.screens.Screens
//import com.example.instatask.viewmodel.TheViewModel
import com.google.android.gms.dynamic.IObjectWrapper
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
//import com.google.gson.annotations.SerializedName
import com.google.maps.android.compose.*





//var cameraPositionState:CameraPositionState?=null

val caliMuseum = LatLng(34.05, -118.24)
val toyDistrict = LatLng(34.047, -118.243)
val brew = LatLng(34.051, -118.234)
val dodgerS = LatLng(34.073, -118.241)
val church = LatLng(34.05693923331048, -118.23957346932366)
var lat:Double = 37.4198
var lng:Double = -122.0788
val googleHQ = LatLng(lat, lng)

val googlePosition =    CameraPosition.fromLatLngZoom(
    LatLng(37.4198,  -122.0788), 14f)

var cameraPositionState:CameraPositionState =  CameraPositionState(position = CameraPosition.fromLatLngZoom(googleHQ, 14f))

/*display respective board's markers
 * mode == 1 is job board, mode==2 is skill board, mode == 3 NO marker
 *
 * on any list updates
 * */

