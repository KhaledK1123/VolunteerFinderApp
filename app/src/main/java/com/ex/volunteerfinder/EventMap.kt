package com.ex.volunteerfinder

import android.content.ContentValues.TAG
import android.content.Context
import android.location.Address
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.ex.volunteerfinder.util.rememberMapViewWithLifecycle
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.UserViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.*
import com.google.maps.android.compose.*
import com.google.maps.android.ktx.awaitMap
import com.google.maps.android.ktx.model.markerOptions
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.*



class EventMapLoc : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val TheViewModel = ViewModelProvider(this).get(TheViewModel::class.java)
        val theViewModel= ViewModelProvider(this).get(UserViewModel::class.java)
        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        //EventMapLoc()

                    }
                }
            }
        }
    }
}

//For any reference watch https://www.youtube.com/watch?v=qDSLJ0ZNRkE
@Composable
fun EventMap(){
    Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {

//        val usersInfoState=usersInfoViewModel.usersInfoState.value
//        val glaces=GoogleLocsViewModel = hiltViewModel()

//        GoogleMapView(
//                modifier = Modifier.fillMaxSize(),
//                onMapLoaded = {
//                    var isMapLoaded = true
//                },
//                users = usersInfoState.usersInfo,
//                googlePlacesInfoViewModel = glaces
//            )

        GoogleMap()
       ListEvents()
       // Text(text = "hello")
    }



    @Composable
    fun MakeGoogleMap(
        makeMarker: Boolean = false,
        vModel:UserViewModel,
        mode:Int = 0,
        navController: NavController
    ) {
        cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(googleHQ, 14f)
        }


        var uiSettings by remember {
            mutableStateOf(
                MapUiSettings(
                    compassEnabled = true,
                    myLocationButtonEnabled = true,
                    mapToolbarEnabled = true
                )
            )
        }

        var properties by remember {
            mutableStateOf(MapProperties(mapType = MapType.NORMAL))
        }



        Box(Modifier.fillMaxSize())
        {
            GoogleMap(
                modifier = Modifier.matchParentSize(),
                cameraPositionState = cameraPositionState!!,
                uiSettings = uiSettings,
                properties= properties,


                onPOIClick = {
                    Log.d(TAG, "POI clicked: ${it.name}")
                },

                onMapLongClick = {
//
//            cameraPositionState!!.position =
//                CameraPosition.fromLatLngZoom(
//                    userCurrentLocation,
//                    15f
//                )


                }
            )
            //        {
//            Log.d("Big map", "Big Map")
//            //default mode 0, don't create markers
//            if(mode!=0) {
//                if(mode==1) {
//                    createMarkers(vModel, mode = mode, navController=navController)
//                }
//                else if(mode==2){
//                    createMarkers(vModel, mode = mode, navController=navController)
//                }
//            }
//        }
//        Switch(
//            checked = uiSettings.mapToolbarEnabled,
//            onCheckedChange = {
//                uiSettings = uiSettings.copy(mapToolbarEnabled = it)
//            }
//        )


//    LaunchedEffect(){
//
//    }

        }
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
fun MakeGoogleMap() {
    TODO("Not yet implemented")
}


//fun GoogleMapView(modifier: Modifier, onMapLoaded: () -> Unit, users:  List<UserInfo>, googlePlacesInfoViewModel:GooglePlacesInfoViewModel) {
//    val singapore = LatLng(1.35, 103.87)
//    val singapore2 = LatLng(1.40, 103.77)
//
//
//
//
//
//    var pos by remember {
//        mutableStateOf(LatLng(singapore.latitude, singapore.longitude))
//    }
//
//
//
//
//    var poi by remember {
//        mutableStateOf("")
//    }
//    val _makerList: MutableList<LatLng> =   mutableListOf<LatLng>()
//
//    _makerList.add(singapore)
//    _makerList.add(singapore2)
//
//    var pos2 by remember {
//        mutableStateOf(_makerList)
//    }
//
//    val cameraPositionState = rememberCameraPositionState {
//        position = CameraPosition.fromLatLngZoom(singapore, 11f)
//    }
//
//    var mapProperties by remember {
//        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
//    }
//    var uiSettings by remember {
//        mutableStateOf(
//            MapUiSettings(compassEnabled = false)
//        )
//    }
//
//    com.ex.volunteerfinder.GoogleMap(
//        modifier = modifier,
//        cameraPositionState = cameraPositionState,
//        properties = mapProperties,
//        uiSettings = uiSettings,
//        onMapLoaded = onMapLoaded,
//        googleMapOptionsFactory = {
//            GoogleMapOptions().camera(
//                CameraPosition.fromLatLngZoom(
//                    singapore,
//                    11f
//                )
//            )
//        },
//        onMapClick = {
//            Log.d(TAG, "Coordinate clicked: $it")
//            pos2.add(it)
//            pos = it
//        },
//        onPOIClick = {
//            Log.d(TAG, "POI clicked: ${it.name}")
//            poi = it.name
////            it.latLng.latitude
//
//            googlePlacesInfoViewModel.getDirection(
//                origin = "${singapore.latitude}, ${singapore.longitude}",
//                destination = "${it.latLng.latitude}, ${it.latLng.longitude}",
//                key = MapKey.KEY
//            )
//
////            val gPlaceInfoState = googlePlacesInfoViewModel.googlePlacesInfoState.value
//
//
//        }
//    ) {
//        // Drawing on the map is accomplished with a child-based API
//        val markerClick: (Marker) -> Boolean = {
//            Log.d(TAG, "${it.title} was clicked")
//            false
//        }
//        pos2.forEach { posistion ->
//
//            Marker(
//                position = posistion,
//                title = "Singapore ",
//                snippet = "Marker in Singapore ${posistion.latitude}, ${posistion.longitude}",
//                onClick = markerClick,
//                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)
//            )
//        }
//
//        Polyline(points = googlePlacesInfoViewModel.polyLinesPoints.value, onClick = {
//            Log.d(TAG, "${it.points} was clicked")
//        })
////        Marker(
////            position = singapore2,
////            title = "Singapore",
////            snippet = "Marker in Singapore"
////        )
////        Circle(
////            center = singapore,
////            fillColor = MaterialTheme.colors.secondary,
////            strokeColor = MaterialTheme.colors.secondaryVariant,
////            radius = 1000.0,
////        )
//
//    }
////    Column(modifier = Modifier.padding(10.dp))
////    {
////        CustomNaveBar(poi=poi)
////        Spacer(modifier = Modifier.height(LocalConfiguration.current.screenWidthDp.dp))
////        LazyRow {
////            items(count = users.size) { user ->
////                UserInfoRow(user = users[user], onItemClicked = {} )
////            }
////        }
////    }
//
//
//
//}
//
//













@Composable
fun GoogleMap(){
    val mapView= rememberMapViewWithLifecycle()
    val coroutineScope= rememberCoroutineScope()
    //val location=LatLng(41.88,-87.63)//ChicagoDefault location to be pinned initially.
    val loc1=LatLng(43.633282258601064, -89.7563158465689)
    val loc2=LatLng(43.701480657464906, -89.5552371153938)
    val loc3=LatLng(43.44889725461845, -89.73751946453274)
    val loc4=LatLng(43.42235002602182, -89.7312553854383)
    //val locName="Chicago"

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
                    CameraUpdateFactory.newLatLngZoom(loc1,10f),

                )

                val markerOptions= MarkerOptions()
                   // .title("Welcome to ${locName}")
                    .position(loc1)
                map.addMarker(markerOptions)

                val markerOptions2= MarkerOptions()
                    // .title("Welcome to ${locName}")
                    .position(loc2)
                map.addMarker(markerOptions2)

                val markerOptions3= MarkerOptions()
                    // .title("Welcome to ${locName}")
                    .position(loc3)
                map.addMarker(markerOptions3)

                setMapLongClick(map=map,startLoc=loc1)
            }
        }

    }
}

//
//
//
//
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
VolunteerFinderAppTheme() {


    val scope = rememberCoroutineScope()
    val drawerState = rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)

    BottomDrawer(
        gesturesEnabled = true, // making scrollable to fit screen
        drawerState = drawerState,
        drawerBackgroundColor = Color.Transparent, // transparent background
        drawerContent = {

            Button(onClick = { scope.launch { drawerState.close() } }) {
                Text("Close")
            }

//            Spacer(modifier = Modifier.height(16.dp)) // some padding

            BottomDrawerSurface()

        },
        content = {
            // outside content
//            Button(onClick = { scope.launch { drawerState.open() } }) {
//                Text("Open BottomDrawer")
//            }
        }
    )
}
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
                            .padding(20.dp)
                            .clickable(onClick = {}),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(text = "Event $i")

                    }

                }


            }


        }
    }
}





