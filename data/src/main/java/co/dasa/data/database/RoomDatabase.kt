package co.dasa.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import co.dasa.data.database.dao.AccountDao
import co.dasa.data.database.dao.TokenDao
import co.dasa.data.database.entity.AccountEntity
import co.dasa.data.database.entity.TokenEntity
import java.util.concurrent.Executors

@Database(
    entities = [
        TokenEntity::class, AccountEntity::class,
    ],
    version = 9,
    exportSchema = false
)
abstract class RoomDatabase : androidx.room.RoomDatabase() {

    abstract fun tokenDao(): TokenDao
    abstract fun accountDao(): AccountDao

    companion object {
        private var instance: RoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): RoomDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabase::class.java, "dasa_database"
                )
                    .setQueryCallback({ sqlQuery, bindArgs ->
                        println("SQL Query: $sqlQuery SQL Args: $bindArgs")
                    }, Executors.newSingleThreadExecutor())
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
                return instance
            }
        }
    }
    