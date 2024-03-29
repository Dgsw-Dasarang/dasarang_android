package co.dasa.data.network.remote

import co.dasa.data.network.api.EducationApi
import co.dasa.domain.model.education.EducationDatas
import com.stac.data.base.remote.RetrofitRemote

class EducationRemote : RetrofitRemote<EducationApi>() {
    override val api: EducationApi
        get() = createApi(EducationApi::class.java)

    suspend fun getEducationAll(page: Int): EducationDatas {
        return api.getEducationAll(page, 10)
    }
}
