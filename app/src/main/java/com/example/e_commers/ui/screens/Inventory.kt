package com.example.e_commers.ui.screens

data class Inventory(
    val id: Int,
    val name: String,
    val category: String, //
    val sex: String, // "Men", "Women", "Unisex", etc.
    val price: Double,
    val discount: Double? = null, //the default is null until added
    val starRating: Float,
    val sizes: List<String>, // e.g., ["S", "M", "L", "XL"]
    val colors: List<String>, // e.g., ["Red", "Blue", "Black"]
    val availableQuantity: Int, // Number of items in stock
    val isNewArrival: Boolean? = null, // Defaults to null
    val imageRes: Int // Resource ID for image
)

