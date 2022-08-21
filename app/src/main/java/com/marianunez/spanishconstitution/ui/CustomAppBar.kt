package com.marianunez.spanishconstitution.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    title: String? = null,
    navigationIcon: ImageVector? = null,
    navigationAction: () -> Unit?
) {
    val articleTitle = title ?: ""

    if (navigationIcon != null) {
        SmallTopAppBar(
            title = { Text(text = articleTitle) },
            navigationIcon = {
                IconButton(onClick = {
                    navigationAction()
                }) {
                    Icon(navigationIcon, null)
                }
            }
        )
    } else {
        SmallTopAppBar(
            title = { Text(text = articleTitle) },
        )
    }
}