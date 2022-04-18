package com.ex.volunteerfinder

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun EventMap(){
    Box(modifier = Modifier.fillMaxSize()){
        //GoogleMapView()
    }
}

@Composable
fun GoogleMapView(
    modifier: Modifier,
    cameraPositionState: CameraPositionState,
    onMapLoaded:()->Unit,
){
    val OmahaPos=LatLng(41.292032,-96.2213322)
    val omaha= Marker(position = OmahaPos)

    val context= LocalContext.current
    var uiSettings by remember{ mutableStateOf(MapUiSettings(compassEnabled = true))}
    var mapProperties by remember{ mutableStateOf(MapProperties(mapType=MapType.SATELLITE))}
    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
        properties = mapProperties,
        uiSettings = uiSettings,
        onMapLoaded = onMapLoaded,
        onPOIClick = {
            Toast.makeText(context,"Map Clicked:${it.name}",Toast.LENGTH_LONG).show()
        }
    )
}