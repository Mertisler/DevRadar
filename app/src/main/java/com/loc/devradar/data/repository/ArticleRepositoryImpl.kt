package com.loc.devradar.data.repository

// data/repository/ArticleRepositoryImpl.kt

import com.loc.devradar.data.local.dao.ArticleDao
import com.loc.devradar.data.local.entity.ArticleEntity
import com.loc.devradar.data.mapper.toEntityList
import com.loc.devradar.data.remote.api.DevToApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val devToApi: DevToApi,
    private val articleDao: ArticleDao
)
    {
    // 1. Dış dünyaya SADECE Room'daki veriyi canlı akış (Flow) olarak açıyoruz.
    val articles: Flow<List<ArticleEntity>> = articleDao.getAllArticles()

    // 2. Arka planda çalışacak senkronizasyon fonksiyonu
    suspend fun syncArticles() {
        try {
            // API'den yeni veriyi çek
            val remoteArticles = devToApi.getArticles(page = 1, perPage = 20)

            // Entity modeline dönüştür
            val entities = remoteArticles.toEntityList()

            // Room veri tabanına kaydet (Bu işlem yukarıdaki 'articles' Flow'unu tetikleyecektir)
            articleDao.insertArticles(entities)
        } catch (e: Exception) {
            // İnternet yoksa veya API çökerse buraya düşer.
            // Hata loglanabilir ancak uygulamanın çökmesi engellenir.
        }
    }
}