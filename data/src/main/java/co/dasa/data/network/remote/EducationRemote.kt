package co.dasa.data.network.remote

import co.dasa.data.network.api.EducationApi
import co.dasa.data.base.remote.RetrofitRemote
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.education.EducationDatas

class EducationRemote : RetrofitRemote<EducationApi>() {
    override val api: EducationApi
        get() = createApi(EducationApi::class.java)

    suspend fun getEducationAll(page: Int): EducationDatas {
        return api.getEducationAll(page, 10)
    }

    suspend fun getEducationByNum(num: String, token: String): EducationData {
        return api.getEducationByNum("Bearer $token", num)
    }
}
