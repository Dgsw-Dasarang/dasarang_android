package co.dasa.dasarang.features.myInfo.state

import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.user.UserInfo

data class AcademyNumState(
    val isUpdate: Boolean = false,
    val result: String? = null,
    val error: String = ""
)
