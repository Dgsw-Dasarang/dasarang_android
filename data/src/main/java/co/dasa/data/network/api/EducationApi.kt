package co.dasa.data.network.api

import co.dasa.domain.model.education.EducationDatas
import co.dasa.data.network.url.DasaUrl
import retrofit2.http.GET
import retrofit2.http.Query

interface EducationApi {

    @GET(DasaUrl.EDUCATION_ALL)
    suspend fun getEducationAll(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): EducationDatas

}