package co.dasa.domain.model.education

import java.io.Serializable

data class BoardData(
    val academyName: String,
    val content: String,
    val images: List<Image>,
    val postId: Int,
    val title: String
) : Serializable