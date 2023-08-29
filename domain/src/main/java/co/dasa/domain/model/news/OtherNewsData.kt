package co.dasa.domain.model.news

import java.io.Serializable

data class OtherNewsData(
    val category: String,
    val content: String,
    val imageData: List<ImageData>,
    val newsId: Int,
    val title: String
): Serializable