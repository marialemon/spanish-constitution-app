package com.marianunez.spanishconstitution.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.marianunez.spanishconstitution.domain.model.ArticleModel
import com.marianunez.spanishconstitution.ui.theme.dimenXS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetail(navController: NavController, articleModel: ArticleModel) {
    Scaffold(
        topBar = {
            CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
                navController.navigate(HOME) {
                    launchSingleTop = true // si ya hay una home, no generes una nueva
                    popUpTo(HOME) /* esto es para que no levante una nueva screen */
                }
            }
        },
        content = { innerPadding -> // esto es para que la topbar no tape el contenido
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(dimenXS)
            ) {
                Text(
                    style = MaterialTheme.typography.titleLarge,
                    text = "Artículo ${articleModel.number}"
                )

                articleModel.description.forEach {
                    Text(
                        style = MaterialTheme.typography.bodyMedium,
                        text = it
                    )
                }
            }
        }
    )
}