package co.dasa.domain.model.education

data class BoardDatas(
    val currentPage: Int,
    val hasMorePage: Boolean,
    val list: List<BoardData>
)