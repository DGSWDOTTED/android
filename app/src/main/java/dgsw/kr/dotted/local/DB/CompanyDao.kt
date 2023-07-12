package dgsw.kr.dotted.local.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface CompanyDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(company : CompanyEntity)

    @Query("SELECT * FROM Company")
    suspend fun getAllCompany() : List<CompanyEntity>


    @Query("SELECT * FROM Company WHERE companyTitle Like :keyword")
    suspend fun searchCompany(keyword : String): List<CompanyEntity>

    @Query("DELETE from Company")
    suspend fun deleteAll()
}