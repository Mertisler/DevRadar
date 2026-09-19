package com.loc.devradar.data.local.dao

// data/local/dao/ArticleDao.kt

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.loc.devradar.data.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    // Veritabanındaki tüm makaleleri getirir. Dönüş tipi Flow olduğu için,
    // tabloya yeni bir satır eklendiğinde bu fonksiyon otomatik olarak yeni listeyi fırlatır.
    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    // API'den çektiğimiz yeni makaleleri tabloya ekler.
    // Çakışma olursa (aynı ID gelirse) eskisini günceller (REPLACE).
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<ArticleEntity>)

}