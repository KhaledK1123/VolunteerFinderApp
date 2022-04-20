package com.ex.volunteerfinder

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.ex.volunteerfinder.util.rememberMapViewWithLifecycle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.compose.*
import com.google.maps.android.ktx.awaitMap
import com.google.maps.android.ktx.model.markerOptions
import kotlinx.coroutines.launch
import java.util.*

//For any reference watch https://www.youtube.com/watch?v=qDSLJ0ZNRkE
@Composable
fun EventMap(){
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center){
        GoogleMap()
//        LazyColumn(
//            verticalArrangement = Arrangement.Bottom
//        ){
//            item { Text(text = "First iitem") }
//            items(50) {i-> Text(text = "Item: $i")  }
//            item { Text(text = "Last iitem") }
//        }
    }
}

@Composable
fun GoogleMap(){
    val mapView= rememberMapViewWithLifecycle()
    val coroutineScope= rememberCoroutineScope()

    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//            .padding(bottom = 36.dp)
    ) {
        AndroidView({mapView}){mapView->
            coroutineScope.launch {
                val map=mapView.awaitMap()
                map.uiSettings.isZoomControlsEnabled=true
                val location=LatLng(41.88,-87.63)
                map.moveCamera(
                    CameraUpdateFactory.newLatLngZoom(location,10f)
                )

                val markerOptions= MarkerOptions()
                    .title("Welcome to Chicago")
                    .position(location)
                map.addMarker(markerOptions)

                setMapLongClick(map=map)
            }
        }

    }
}

private fun setMapLongClick(
    map: GoogleMap
){
    map.setOnMapClickListener { latlng->
        val snippet= String.format(
            Locale.getDefault(),
            "Lat: %1$.2f, Lng %2$.2f",
            latlng.latitude,
            latlng.longitude
        )

        map.addMarker(
            MarkerOptions().position(latlng).title("Clicked Location").snippet(snippet)
        )
    }
}