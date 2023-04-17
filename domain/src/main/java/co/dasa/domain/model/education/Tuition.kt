package co.dasa.domain.model.education

import java.io.Serializable

data class Tuition(
    val price: Int,
    val title: String
) : Serializable
