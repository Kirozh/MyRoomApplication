package com.example.kirozh.myroomapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.kirozh.myroomapplication.R
import com.example.kirozh.myroomapplication.data_base.Contact
import com.example.kirozh.myroomapplication.data_base.ContactListViewModel


class AddContactFragment : Fragment() {
    private lateinit var mButton: Button
    private lateinit var mNameEt: EditText
    private lateinit var mSurnameEt: EditText
    private lateinit var mNumberEt: EditText
    private lateinit var mContactViewModel: ContactListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_contact, container, false)

        mContactViewModel = ViewModelProvider(this).get(ContactListViewModel::class.java)

        mNameEt = view.findViewById(R.id.nameEt)
        mSurnameEt = view.findViewById(R.id.surnameEt)
        mNumberEt = view.findViewById(R.id.numberEt)

        mButton = view.findViewById(R.id.addButton)
        mButton.setOnClickListener {
            insertDataToDatabase()
            val fragment = ContactListFragment()
            val fm = activity?.supportFragmentManager
            fm?.beginTransaction()
                ?.replace(R.id.container, fragment)
                ?.addToBackStack(null)
                ?.commit()
        }
        return view
    }

    private fun insertDataToDatabase(){
        val name = mNameEt.text.toString()
        val surname = mSurnameEt.text.toString()
        val number = mNumberEt.text.toString()

        if (name.isNotEmpty() && surname.isNotEmpty() && number.isNotEmpty()){
            val contact = Contact(0, name, surname, number)
            mContactViewModel.addContact(contact)
        }
    }


}