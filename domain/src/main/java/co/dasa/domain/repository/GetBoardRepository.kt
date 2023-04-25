package co.dasa.domain.repository

interface GetBoardRepository {

    suspend fun getBoardData(page: Int)
}