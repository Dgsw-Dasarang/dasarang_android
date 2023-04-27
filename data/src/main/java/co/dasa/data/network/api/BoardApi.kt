package co.dasa.data.network.api

import co.dasa.data.network.url.DasaUrl
import co.dasa.domain.model.education.BoardDatas
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BoardApi {
    @GET(DasaUrl.EDUCATAON_BOARD_ACADEMY)
    suspend fun getEducationByAcademyNum(
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Path("aca-number") acaNumber: String
    ): BoardDatas
}