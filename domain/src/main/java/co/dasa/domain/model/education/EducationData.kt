package co.dasa.domain.model.education

import java.io.Serializable

data class EducationData(
    val academyName: String,
    val admstZoneName: String,
    val courseName: String,
    val createdAt: String,
    val roadAddress: String,
    val status: String,
    val totalSeats: Int,
    val tuitions: List<Tuition>
) : Serializable
