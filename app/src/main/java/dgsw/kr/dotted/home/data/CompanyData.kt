package dgsw.kr.dotted.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
open class CompanyData(
    val idx: Int,
    val name : String,
    val address : String,
    val employ : String,
) : Parcelable
