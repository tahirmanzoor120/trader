package com.tahirmanzoor.trader.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tahirmanzoor.trader.dao.ProductDAO
import com.tahirmanzoor.trader.dto.Product

@Database(version = 3, entities = [Product::class], exportSchema = false)
abstract class TraderDatabase : RoomDatabase() {
    abstract val productDAO: ProductDAO

    companion object {

        @Volatile
        private var INSTANCE: TraderDatabase? = null

        fun getInstance(context: Context): TraderDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TraderDatabase::class.java,
                        "trader_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
