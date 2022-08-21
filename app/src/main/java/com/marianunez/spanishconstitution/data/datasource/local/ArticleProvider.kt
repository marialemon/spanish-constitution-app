package com.marianunez.spanishconstitution.data.datasource.local

import com.marianunez.spanishconstitution.domain.model.ArticleModel

class ArticleProvider {

    companion object {
        fun getArticles(): List<ArticleModel> {
            return articleList
        }

        fun getArticlesBy(number: Int): ArticleModel? {
            val list = getArticles()
            return list.find { it.number == number }
        }

        private val articleList = listOf(
            ArticleModel(
                number = 1,
                description = listOf(
                    "1. España se constituye en un Estado social y democrático de Derecho, que propugna como valores superiores de su ordenamiento jurídico la libertad, la justicia, la igualdad y el" +
                            "pluralismo político.",
                    "2. La soberanía nacional reside en el pueblo español, del que emanan los poderes del Estado.",
                    "3. La forma política del Estado español es la Monarquía parlamentaria."
                )
            ),
            ArticleModel(
                number = 2,
                description = listOf(
                    "La Constitución se fundamenta en la indisoluble unidad de la Nación española, patria común e indivisible de todos los españoles, y reconoce y garantiza el derecho a la autonomía de las nacionalidades y regiones que la integran y la solidaridad entre todas ellas."
                )
            ),
            ArticleModel(
                number = 3,
                description = listOf(
                    "1. El castellano es la lengua española oficial del Estado. Todos los españoles tienen el deber de conocerla y el derecho a usarla.",
                    "2. Las demás lenguas españolas serán también oficiales en las respectivas Comunidades Autónomas de acuerdo con sus Estatutos.",
                    "3. La riqueza de las distintas modalidades lingüísticas de España es un patrimonio cultural que será objeto de especial respeto y protección."
                )
            ),
            ArticleModel(
                number = 4,
                description = listOf(
                    "1. La bandera de España está formada por tres franjas horizontales, roja, amarilla y roja, siendo la amarilla de doble anchura que cada una de las rojas.",
                    "2. Los Estatutos podrán reconocer banderas y enseñas propias de las Comunidades Autónomas. Estas se utilizarán junto a la bandera de España en sus edificios públicos y en sus actos oficiales."
                )
            ),
            ArticleModel(
                number = 5,
                description = listOf("La capital del Estado es la villa de Madrid.")
            )
        )
    }
}