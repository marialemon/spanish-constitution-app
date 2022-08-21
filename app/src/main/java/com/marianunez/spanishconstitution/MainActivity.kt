package com.marianunez.spanishconstitution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marianunez.spanishconstitution.data.datasource.local.ArticleProvider
import com.marianunez.spanishconstitution.ui.ARTICLE_DETAIL
import com.marianunez.spanishconstitution.ui.ArticleDetail
import com.marianunez.spanishconstitution.ui.HOME
import com.marianunez.spanishconstitution.ui.MainView
import com.marianunez.spanishconstitution.ui.theme.SpanishConstitutionTheme
import com.marianunez.spanishconstitution.ui.theme.dimenDefault

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NavigationHost() }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    SpanishConstitutionTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimenDefault),
            color = MaterialTheme.colorScheme.background,
        ) {
            NavHost(navController = navController, startDestination = HOME) {

                composable(route = HOME) {
                    MainView(navController)
                }

                composable(route = "$ARTICLE_DETAIL{number}") {
                    val articleNumberString = it.arguments?.getString("number") ?: "1"
                    val articleNumber = articleNumberString.toInt()
                    val article = ArticleProvider.getArticlesBy(articleNumber)
                    ArticleDetail(navController, article!!)
                }
            }
        }
    }
}