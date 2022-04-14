package com.ex.volunteerfinder.model.data

import com.ex.volunteerfinder.R

object DummyDonation {
    val dummy = EventImg.EventImg(
        images = listOf<Int>(R.drawable.mercedes, R.drawable.mercedes1, R.drawable.mercedes2)//Kotlin will print the name of the data and not the data
    )
    val dummy1 = EventImg.EventImg(

        images = listOf<Int>(R.drawable.iphone, R.drawable.iphone1, R.drawable.iphone2, R.drawable.iphone3)//Kotlin will print the name of the data and not the data
    )
    val dummyList:List<EventImg.EventImg> = listOf(dummy, dummy1)
}