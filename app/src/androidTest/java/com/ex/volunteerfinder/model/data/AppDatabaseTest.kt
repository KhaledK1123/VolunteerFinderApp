package com.ex.volunteerfinder.model.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ex.volunteerfinder.dao.EventDao
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest : TestCase(){


    private lateinit var db:AppDatabase
    private lateinit var dao:EventDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,AppDatabase::class.java).build()
        dao = db.eventDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    //runBlocking is used because insertEvent is a suspend function
    @Test
    fun writeAndReadEvent() = runBlocking{
        val event = MyEvent(name = "Football",
            sponsor = "Khaled",
            leadership = "Micah",
            address = "75 Clover Road",
            city = "Phenix City",
            state = "Alabama",
            zipCode = 36868,
            time = "5:08 PM",
            date = "7/12/2022"
        )
        dao.insertEvent(event)

//        val fetch = dao.fetchAllEvents()
//        assertTrue(fetch.value!!.contains(event))
    }
}