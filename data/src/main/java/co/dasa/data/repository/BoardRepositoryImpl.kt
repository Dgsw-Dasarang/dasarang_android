package co.dasa.data.repository

import android.util.Log
import co.dasa.data.datasource.BoardDataSource
import co.dasa.domain.model.education.BoardDatas
import co.dasa.domain.repository.BoardRepository
import co.dasa.domain.usecases.board.GetBoardData.Params
import javax.inject.Inject

class BoardRepositoryImpl @Inject constructor(
    private val boardDataSource: BoardDataSource
) : BoardRepository {

    override suspend fun getEducationByAcademyNum(params: Params): BoardDatas {
        return boardDataSource.getEducationByAcademyNum(params)
    }


}
