package com.example.kirozh.myroomapplication.data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.lang.IllegalStateException

/**
 * @author Kirill Ozhigin on 03.09.2021
 */

@Database(entities = [Contact::class], version = 1)
@TypeConverters(ContactTypeConverters::class)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object{
        @Volatile
        private var INSTANCE: ContactDatabase?=null

        fun getDatabase(context: Context):ContactDatabase {
            if (INSTANCE != null)
                return INSTANCE as ContactDatabase
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "CONTACTS_DATABASE"
                ).build()

                INSTANCE = instance
                return INSTANCE as ContactDatabase
            }

        }
    }

}