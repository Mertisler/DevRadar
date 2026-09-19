package com.loc.devradar.data.mapper

import com.loc.devradar.data.local.entity.ArticleEntity
import com.loc.devradar.data.remote.dto.ArticleDto

// Tek bir DTO'yu Entity'ye çeviren fonksiyon
fun ArticleDto.toEntity(): ArticleEntity {
    return ArticleEntity(
        id = this.id,
        title = this.title,
        url = this.url,
        coverImage = this.coverImage,
        // UserDto içindeki alanları doğrudan Entity'nin alanlarına eşitliyoruz (Düzleştirme)
        authorName = this.user.name,
        authorImage = this.user.profileImage
    )
}

// Bir DTO listesini (API'den dönen liste) Entity listesine çeviren fonksiyon
fun List<ArticleDto>.toEntityList(): List<ArticleEntity> {
    return this.map { it.toEntity() }
}