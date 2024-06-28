package com.example.eas_alfamind.components.category

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.eas_alfamind.data.Category
import com.example.eas_alfamind.components.category.CategoryItem
import com.example.eas_alfamind.R.drawable
import com.example.eas_alfamind.viewModels.ProdcutVM
import com.example.eas_alfamind.viewModels.categoryVM

@Composable
fun CategoryList(navController: NavController){
    val categoryViewModel : categoryVM = viewModel()
    val categories = categoryViewModel.getAllCategory()


    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        items(categories.chunked(4)) { rowCategories ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                rowCategories.forEach { cat ->
                    CategoryItem(category = cat) {
                        navController.navigate("product_category/${cat.id}")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
