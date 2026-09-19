package com.loc.devradar.data.local.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

// Bu sınıf veritabanındaki "articles" isimli tabloya karşılık gelir
@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey
    val id: Int, // API'den gelen benzersiz ID'yi primary key yapıyoruz ki çakışma olmasın

    val title: String,
    val url: String,
    val coverImage: String?,

    // Yazar bilgileri API'de ayrı bir objedeydi,
    // burada doğrudan tablonun sütunları olarak düzleştiriyoruz
    val authorName: String,
    val authorImage: String?
)
