package co.dasa.data.network.api

import co.dasa.data.network.url.DasaUrl
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.news.NewsListData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface EducationApi {

    @GET(DasaUrl.EDUCATION_ALL)
    suspend fun getEducationAll(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): EducationDatas

    @GET(DasaUrl.EDUCATION_NUM)
    suspend fun getEducationByNum(
        @Header("Authorization") token: String,
        @Path("academy-number") academyNumber: String
    ): EducationData
}
