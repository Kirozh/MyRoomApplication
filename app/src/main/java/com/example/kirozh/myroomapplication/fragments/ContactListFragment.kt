package com.example.kirozh.myroomapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kirozh.myroomapplication.R
import com.example.kirozh.myroomapplication.data_base.ContactListViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * @author Kirill Ozhigin on 03.09.2021
 */


class ContactListFragment: Fragment() {
    private lateinit var mFloatingActionButton: FloatingActionButton
    private lateinit var mContactViewModel: ContactListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recycler_view, container, false)

        mFloatingActionButton = view.findViewById(R.id.floatingActionButton)
        mFloatingActionButton.setOnClickListener {
            val fragment = AddContactFragment()
            val fm = activity?.supportFragmentManager
            fm?.beginTransaction()
                ?.replace(R.id.container, fragment)
                ?.addToBackStack(null)
                ?.commit()
        }

        val adapter = ListAdapter()
        val mRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)


        mContactViewModel = ViewModelProvider(this).get(ContactListViewModel::class.java)
        mContactViewModel.getContacts.observe(viewLifecycleOwner, Observer{user ->
            adapter.setData(user)
        })

        return view
    }
}