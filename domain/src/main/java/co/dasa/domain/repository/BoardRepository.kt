package co.dasa.domain.repository

import co.dasa.domain.model.education.BoardDatas
import co.dasa.domain.usecases.board.GetBoardData

interface BoardRepository {


    suspend fun getEducationByAcademyNum(params: GetBoardData.Params): BoardDatas
}
