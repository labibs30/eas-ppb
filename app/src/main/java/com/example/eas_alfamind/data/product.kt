package com.example.eas_alfamind.data

data class Product(
    val id:Int,
    val name:String,
    val imageRes:Int,
    val price: Int,
    val description: String,
    val category_id:Int,
)