package co.dasa.data.base

import android.app.Application
import co.dasa.data.database.RoomDatabase

open class BaseCache(application: Application) {
    protected val database = RoomDatabase.getInstance(application)!!
}
