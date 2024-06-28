package com.example.eas_alfamind.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.eas_alfamind.data.Product
import com.example.eas_alfamind.R.drawable
import kotlin.collections.List
import kotlin.random.Random
class ProdcutVM : ViewModel(){
    var products = mutableStateListOf<Product>()
        private set

    val productNames = listOf(
        "iPhone 11",
        "Samsung Galaxy S20",
        "Google Pixel 5",
        "OnePlus 8",
        "Huawei P40",
        "Sony Xperia 1",
        "Xiaomi Mi 10",
        "Oppo Find X2",
        "Nokia 8.3",
        "LG Velvet"
    )

    val productDescriptions = listOf(
        "Generasi Terbaru dengan Fitur Canggih",
        "Performa Tinggi dengan Desain Menawan",
        "Kamera Unggulan dan Baterai Tahan Lama",
        "Layar Super AMOLED dan Snapdragon 865",
        "Desain Elegan dengan Kualitas Premium",
        "Pengalaman Fotografi Luar Biasa",
        "Smartphone Andalan dengan Teknologi Terkini",
        "Kualitas Gambar Jernih dan Resolusi Tinggi",
        "Kinerja Cepat dan Penyimpanan Besar",
        "Teknologi AI Canggih dalam Genggaman Anda"
    )

    init {
        products.addAll(
            List(40) { i ->
                val randomName = productNames.random()
                val randomDescription = productDescriptions.random()
                val randomDrawable = drawable.ic_launcher_foreground
                val randomPrice = 1000000
                val randomRating = Random.nextInt(1, 6)
                Product(i + 1, randomName, randomDrawable, randomPrice, randomDescription, randomRating)
            }
        )
    }


    fun getProductByCategoryId(id: Int): List<Product> {
        return products.filter { it.category_id == id }
    }

    fun getProductById(id:Int):Product?{
        return products.find{it.id == id}
    }

    fun getRandomProducts(count: Int = 6): List<Product> {
        return products.shuffled().take(count)
    }
}