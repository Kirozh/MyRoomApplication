package com.example.kirozh.myroomapplication.data_base

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.lang.IllegalStateException
import java.util.*

/**
 * @author Kirill Ozhigin on 03.09.2021
 */

private const val DATABASE_NAME = " contact-database"
class ContactRepository (private val contactDao: ContactDao){

    val getContacts: LiveData<List<Contact>> = contactDao.getContacts()

    fun getContact(id: UUID) : LiveData<Contact?> = contactDao.getContact(id)

    suspend fun addContact(contact: Contact) {
        contactDao.addContact(contact)
    }



}