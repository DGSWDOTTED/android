package dgsw.kr.dotted.local.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CompanyEntity::class],version = 2, exportSchema = false)

abstract class CompanyDatabase : RoomDatabase() {

    abstract fun companyDao() : CompanyDao

    companion object {

        private var instance : CompanyDatabase? = null

        @Synchronized
        fun getInstance(context : Context):CompanyDatabase?{

            if (instance == null ){

                synchronized(CompanyDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,CompanyDatabase::class.java,"company_database"
                    ).build()

                }
            }
            return instance

        }
    }

}