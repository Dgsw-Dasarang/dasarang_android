package co.dasa.domain.usecases.board

import android.util.Log
import co.dasa.domain.base.UseCase
import co.dasa.domain.model.education.BoardDatas
import co.dasa.domain.repository.BoardRepository
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBoardData @Inject constructor(
    private val boardRepository: BoardRepository
) : UseCase<GetBoardData.Params, BoardDatas>() {
    override fun invoke(params: Params): Flow<Resource<BoardDatas>> = execute {
        boardRepository.getEducationByAcademyNum(params)
    }

    data class Params(
        val page: Int,
        val size: Int,
        val aca_num: String
    )
}