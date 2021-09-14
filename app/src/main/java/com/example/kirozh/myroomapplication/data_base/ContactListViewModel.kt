package com.example.kirozh.myroomapplication.data_base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Kirill Ozhigin on 03.09.2021
 */
class ContactListViewModel(application: Application) : AndroidViewModel(application){
     val getContacts: LiveData<List<Contact>>
    private val repository: ContactRepository

    init{
        val contactDao = ContactDatabase.getDatabase(application).contactDao()
        repository = ContactRepository(contactDao)
        getContacts = repository.getContacts
    }

    fun addContact(contact: Contact){
        viewModelScope.launch(Dispatchers.IO){
            repository.addContact(contact)
        }
    }


}