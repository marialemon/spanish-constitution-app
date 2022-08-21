package com.marianunez.spanishconstitution.domain.model

data class ArticleModel(
    val number: Int = 1,
    val description: List<String> = emptyList()
)