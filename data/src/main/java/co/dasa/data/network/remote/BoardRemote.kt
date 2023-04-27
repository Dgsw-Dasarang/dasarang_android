package co.dasa.data.network.remote

import android.util.Log
import co.dasa.data.base.remote.RetrofitRemote
import co.dasa.data.network.api.BoardApi
import co.dasa.domain.model.education.BoardDatas
import co.dasa.domain.usecases.board.GetBoardData.Params

class BoardRemote : RetrofitRemote<BoardApi>() {
    override val api: BoardApi
        get() = createApi(BoardApi::class.java)

    suspend fun getEducationByAcademyNum(params: Params): BoardDatas {
        return api.getEducationByAcademyNum(params.page, params.size, params.aca_num)
    }
}
