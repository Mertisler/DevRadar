package com.loc.devradar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.loc.devradar.data.local.dao.ArticleDao
import com.loc.devradar.data.local.entity.ArticleEntity

// Veritabanındaki tabloları (entities) ve versiyonu belirtiyoruz.
@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    // Hilt'in DatabaseModule içinde çağırabilmesi için DAO'yu dışa açıyoruz.
    abstract fun articleDao(): ArticleDao

}