package com.marianunez.spanishconstitution.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.marianunez.spanishconstitution.R
import com.marianunez.spanishconstitution.data.datasource.local.ArticleProvider
import com.marianunez.spanishconstitution.domain.model.ArticleModel
import com.marianunez.spanishconstitution.ui.theme.dimenDefault
import com.marianunez.spanishconstitution.ui.theme.dimenS
import com.marianunez.spanishconstitution.ui.theme.dimenXL
import com.marianunez.spanishconstitution.ui.theme.dimenXS
import com.marianunez.spanishconstitution.ui.theme.dimenXXL

typealias Listener = () -> Unit

@Composable
private fun Header(name: String) {
    Column(
        modifier = Modifier.padding(vertical = dimenXL),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_balance),
            contentDescription = "imagen",
            modifier = Modifier.size(dimenXXL)
        )
        Text(
            text = "Constitución $name",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        Text(text = "Legislación consolidada", style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
fun MainView(navController: NavController) {
    val articles = ArticleProvider.getArticles()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header("Española")
        LazyColumn(verticalArrangement = Arrangement.spacedBy(dimenS)) {
            items(articles) { article ->
                ArticleCard(articleModel = article) {
                    navController.navigate("$ARTICLE_DETAIL${article.number}") {
                        launchSingleTop = true
                        // esto hace que si hay una pantalla de detalle ya, no genera una nueva
                    }
                }
            }
        }
    }
}

@Composable
fun ArticleCard(articleModel: ArticleModel, action: Listener) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { action() },
        elevation = CardDefaults.cardElevation(dimenXS),
    ) {
        Column(
            modifier = Modifier.padding(dimenDefault),
            verticalArrangement = Arrangement.spacedBy(dimenXS)

        ) {
            Text(
                style = MaterialTheme.typography.titleLarge,
                text = "Artículo ${articleModel.number}"
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                text = articleModel.description[0]
            )
            Image(
                painter = painterResource(id = R.drawable.ic_favorite_border),
                contentDescription = "Add to favorites",
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}