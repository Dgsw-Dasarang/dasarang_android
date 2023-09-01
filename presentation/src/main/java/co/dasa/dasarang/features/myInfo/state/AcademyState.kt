package co.dasa.dasarang.features.myInfo.state

import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.user.UserInfo

data class AcademyState(
    val isUpdate: Boolean = false,
    val result: EducationData? = null,
    val error: String = ""
)
