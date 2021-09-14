package com.example.kirozh.myroomapplication.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kirozh.myroomapplication.MainActivity
import com.example.kirozh.myroomapplication.R
import com.example.kirozh.myroomapplication.data_base.Contact

/**
 * @author Kirill Ozhigin on 03.09.2021
 */
class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var contactList = emptyList<Contact>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,
                                                                        parent,
                                                             false))
    }

    override fun onBindViewHolder(holder: ListAdapter.MyViewHolder, position: Int) {
        val currentItem = contactList[position]
        holder.apply{
            mNameTv.text = currentItem.name
            mSurnameTv.text = currentItem.surname
            mNumberTv.text = currentItem.telephoneNumber
        }
        holder.itemView.setOnClickListener { 
            val fragment = UpdateContactFragment()
            val fm = (activity as FragmentActivity).supportFragmentManager
            .beginTransaction
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    fun setData(contact: List<Contact>){
        this.contactList = contact
        notifyDataSetChanged()
    }

     inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val mNameTv: TextView = itemView.findViewById(R.id.nameTv)
        val mSurnameTv: TextView = itemView.findViewById(R.id.surnameTv)
        val mNumberTv: TextView = itemView.findViewById(R.id.numberTv)
    }
}