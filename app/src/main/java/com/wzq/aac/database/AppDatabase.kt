package com.wzq.aac.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.wzq.aac.ThreadUtils
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

@Database(entities = [Order::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getOrderDao(): OrderDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context)
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "wzq_test")
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            ThreadUtils.getInitIO().execute {
                                Thread.sleep(3000)
                                getInstance(context).getOrderDao().addOrders(MutableList(10) { index ->
                                        Order(index, "o-$index", "address~~$index")
                                    })
                            }
                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                            println("database open")
                        }
                    })
                    .allowMainThreadQueries()
                    .build()
        }
    }
}