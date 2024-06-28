package com.example.eas_alfamind.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.eas_alfamind.R
import com.example.eas_alfamind.data.Category

class categoryVM : ViewModel(){
    var categories = mutableStateListOf<Category>()
        private set

    init {
        categories.addAll(
            listOf(
                Category(1, "Laptop", R.drawable.ic_launcher_foreground),
                Category(2, "Perabot", R.drawable.ic_launcher_foreground),
                Category(3, "Olahraga", R.drawable.ic_launcher_foreground),
                Category(4, "HP", R.drawable.ic_launcher_foreground),
                Category(5, "Musik", R.drawable.ic_launcher_foreground),
                Category(6, "Buku", R.drawable.ic_launcher_foreground),
                Category(7, "Lifestyle", R.drawable.ic_launcher_foreground),
                Category(8, "Game", R.drawable.ic_launcher_foreground),
            )
        )
    }

    fun getAllCategory(): List<Category> {
        return categories.toList()
    }
    fun getCategoryById(id:Int):Category?{
        return categories.find{it.id == id}
    }
}