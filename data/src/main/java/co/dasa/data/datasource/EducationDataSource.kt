package co.dasa.data.datasource

import co.dasa.data.base.BaseDataSource
import co.dasa.data.network.remote.EducationRemote
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.education.EducationDatas
import javax.inject.Inject

class EducationDataSource @Inject constructor(
    override val remote: EducationRemote,
    override val cache: Any
) : BaseDataSource<EducationRemote, Any> {

    suspend fun getEducationAll(page: Int): EducationDatas = remote.getEducationAll(page)

    suspend fun getEducationByNum(num: String, token: String): EducationData = remote.getEducationByNum(num, token)
}
