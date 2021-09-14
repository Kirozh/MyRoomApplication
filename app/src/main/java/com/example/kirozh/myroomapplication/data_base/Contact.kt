package com.example.kirozh.myroomapplication.data_base

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

import java.util.*

/**
 * @author Kirill Ozhigin on 02.09.2021
 */
@Parcelize
@Entity
data class Contact(@PrimaryKey(autoGenerate = true) val id: Int,
                                var name: String = "",
                                var surname: String = "",
                                var telephoneNumber: String = ""
): Parcelable