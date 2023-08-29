package co.dasa.domain.model.news

data class NewsListData(
    val currentPage: Int,
    val hasMorePage: Boolean,
    val list: List<OtherNewsData>
)
