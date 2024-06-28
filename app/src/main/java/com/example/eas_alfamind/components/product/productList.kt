package com.example.eas_alfamind.components.product

import DiscountItem
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
import androidx.navigation.NavController
import com.example.eas_alfamind.data.Category
import com.example.eas_alfamind.components.category.CategoryItem
import com.example.eas_alfamind.R.drawable
import com.example.eas_alfamind.data.Product
import com.example.eas_alfamind.viewModels.ProdcutVM
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProductList(category_id:Int, navController: NavController){
    val productViewModel : ProdcutVM = viewModel()
    val products = productViewModel.getProductByCategoryId(category_id)

    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        items(products.chunked(4)) { rowCategories ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                rowCategories.forEach { prod ->
                    ProductItem(product = prod) {
                        navController.navigate("product_detail/${prod.id}")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }


}
