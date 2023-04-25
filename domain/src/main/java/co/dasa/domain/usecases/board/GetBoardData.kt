package co.dasa.domain.usecases.board

import co.dasa.domain.base.UseCase
import co.dasa.domain.repository.GetBoardRepository
import co.dasa.domain.util.Resource
import java.util.concurrent.Flow
import javax.inject.Inject

class GetBoardData @Inject constructor(
    private val getBoardRepository: GetBoardRepository
): UseCase<Int, >() {
        override fun invoke(page: Int): Flow<Resource<>> = execute {

        }
}