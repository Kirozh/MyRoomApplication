package com.example.kirozh.myroomapplication.data_base

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.*

/**
 * @author Kirill Ozhigin on 03.09.2021
 */
@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
     fun getContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM contact WHERE id=(:id)")
     fun getContact(id: UUID): LiveData<Contact?>

     @Insert(onConflict = OnConflictStrategy.IGNORE)
      suspend fun addContact(contact: Contact)
}