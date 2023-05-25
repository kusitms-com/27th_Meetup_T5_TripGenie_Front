package com.kusitms.ovengers.data

data class ResponseSignUp (

    val isSuccess : Boolean,
    val status : Int,
    val code : Int,
    val message : String,
    val attribute: Attributes,
)

data class Attributes(
    val accessToken: String,
    val refreshToken: Any,
)