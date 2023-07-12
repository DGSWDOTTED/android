package dgsw.kr.dotted.home.data

data class Company(
    val idx: Int,
    val jobOpeningDate: String,
    val recruitmentDate: String,
    val name: String,
    val employmentType: EmployType,
    val payType: PayType,
    val pay: Int,
    val joinType: String,
    val requiredCareer: String,
    val requiredEducation: String,
    val major: String?,
    val requiredQualifications: String?,
    val address: String,
    val companyType: String,
    val charge: String,
    val uploadDate: String,
    val phoneNumber: String,
    val profileImage: String
    )
