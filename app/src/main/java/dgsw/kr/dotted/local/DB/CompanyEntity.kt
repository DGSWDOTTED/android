package dgsw.kr.dotted.local.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Company")

class CompanyEntity(

    @PrimaryKey var id: String,
    @ColumnInfo var companyTitle : String,
    @ColumnInfo var jobType : String,
    @ColumnInfo var employ : String,
    @ColumnInfo var payType : String,
    @ColumnInfo var pay : String,
    @ColumnInfo var address : String,
    @ColumnInfo var companyType : String,
    @ColumnInfo var charge : String,
    @ColumnInfo var x : String,
    @ColumnInfo var y : String

)
