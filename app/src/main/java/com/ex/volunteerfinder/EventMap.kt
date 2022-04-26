package com.ex.volunteerfinder

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.ex.volunteerfinder.util.rememberMapViewWithLifecycle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.compose.*
import com.google.maps.android.ktx.awaitMap
import com.google.maps.android.ktx.model.markerOptions
import kotlinx.coroutines.launch
import java.util.*

//For any reference watch https://www.youtube.com/watch?v=qDSLJ0ZNRkE
@Composable
fun EventMap(){
    Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
        GoogleMap()
        ListEvents()
    }





        //lazyColumn
//
//        LazyColumn(
//            verticalArrangement = Arrangement.Bottom,
//            contentPadding = PaddingValues(all=20.dp),
//
//        ){
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(20.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.spacedBy(12.dp)
//            ) {
//                Text(text = "Sample Event 1",
//                    color=Color.Black,
//                    fontWeight = FontWeight.Bold
//
//                )
//                Text(text = "Sample event 2",
//                color= Color.Black,
//                fontWeight = FontWeight.Bold
//                )
//
//            }
//        }
    }


@Composable
fun GoogleMap(){
    val mapView= rememberMapViewWithLifecycle()
    val coroutineScope= rememberCoroutineScope()
    val location=LatLng(41.88,-87.63)//ChicagoDefault location to be pinned initially.
    val locName="Chicago"

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

                map.moveCamera(
                    CameraUpdateFactory.newLatLngZoom(location,10f)
                )

                val markerOptions= MarkerOptions()
                    .title("Welcome to ${locName}")
                    .position(location)
                map.addMarker(markerOptions)

                setMapLongClick(map=map,startLoc=location)
            }
        }

    }
}

private fun setMapLongClick(
    map: GoogleMap,
    startLoc:LatLng,
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

        //For ref : https://www.youtube.com/watch?v=2tu-hNbyViU 10:30
        map.addPolyline(
            PolylineOptions().add(
                startLoc,
                latlng
            )
        ).color=R.color.purple_500 //Polyline color
    }
}

//@Composable
//fun ListEvents(){
//    var title:String
//    var items by remember {
//        mutableStateOf((1..5).map{
//            title= "Sample Event $it"
//        }
//        )
//    }
//
//    Box(modifier = Modifier
//        .fillMaxWidth(),
//
//    ){
//
//        LazyColumn(
//            verticalArrangement = Arrangement.Bottom,
//            contentPadding = PaddingValues(all=20.dp),
//
//
//
//        ){
//            items(items.size){
//                    i->
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(20.dp),
//                    verticalAlignment = Alignment.Bottom,
//                    horizontalArrangement = Arrangement.spacedBy(12.dp)
//                ) {
//                    Text(text = "event $i")
//
//                }
//
//            }
//
//
//        }
//
//
//
//    }
//
//
//
//    }


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListEvents(){

    val scope = rememberCoroutineScope()
    val drawerState = rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)

    BottomDrawer(
        gesturesEnabled = true, // making scrollable to fit screen
        drawerState = drawerState,
        drawerBackgroundColor = Color.Transparent, // transparent background
        drawerContent = {

            Button(onClick = { scope.launch { drawerState.close() } }) {
                Text("CloseX")
            }

//            Spacer(modifier = Modifier.height(16.dp)) // some padding

            BottomDrawerSurface()

        },
        content = {
            // outside content
//            Button(onClick = { scope.launch { drawerState.open() } }) {
//                Text("Open BottomDrawer")
 //           }
        }
    )
}

@Composable
fun BottomDrawerSurface() {

    var title: String
    var items by remember {
        mutableStateOf((1..5).map {
            title = "Sample Event $it"
        }
        )
    }

    Surface(
        color = Color.White,
        shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp)
    ) {
        // your design..

        Box(
            modifier = Modifier
                .fillMaxWidth(),

            ) {

            LazyColumn(
                verticalArrangement = Arrangement.Bottom,
                contentPadding = PaddingValues(all = 20.dp),


                ) {
                items(items.size) { i ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(text = "event $i")

                    }

                }


            }


        }
    }
}



