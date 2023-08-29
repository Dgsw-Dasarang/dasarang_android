package co.dasa.domain.usecases.news

data class NewsUseCases(
    val getNewsColumn: GetNewsColumn,
    val getCommentNews: GetCommentNews,
    val writeCommentNews: WriteCommentNews
)
