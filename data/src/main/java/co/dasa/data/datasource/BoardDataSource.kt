package co.dasa.data.datasource

import co.dasa.data.base.BaseDataSource
import co.dasa.data.network.remote.BoardRemote
import co.dasa.domain.model.education.BoardDatas
import co.dasa.domain.usecases.board.GetBoardData.Params
import javax.inject.Inject

class BoardDataSource @Inject constructor(
    override val remote: BoardRemote,
    override val cache: Any
) : BaseDataSource<BoardRemote, Any> {
    suspend fun getEducationByAcademyNum(params: Params): BoardDatas = remote.getEducationByAcademyNum(params)
}
