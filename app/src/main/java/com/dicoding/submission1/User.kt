package com.dicoding.submission1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    var name: String? = null,
    var company: String? = null,
    var username: String? = null,
    var image: Int,
    var location: String? = null,
    var following: String? = null,
    var follower: String? = null,
    var repository: String? = null,
): Parcelable
