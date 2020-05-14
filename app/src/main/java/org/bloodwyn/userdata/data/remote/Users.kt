package org.bloodwyn.userdata.data.remote

import com.google.gson.annotations.SerializedName

data class Users(@SerializedName("results") val results: Array<NetworkUser>)