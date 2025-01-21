package com.example.bininfoapp.data.model

data class BinResponse(
    val scheme: String?,
    val type: String?,
    val bank: Bank?,
    val country: Country?
)

data class Bank(
    val name: String?,
    val url: String?,
    val phone: String?,
    val city: String?
)

data class Country(
    val name: String?,
    val latitude: Double?,
    val longitude: Double?
)
