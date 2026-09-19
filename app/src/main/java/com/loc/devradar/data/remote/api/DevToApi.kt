package com.loc.devradar.data.remote.api

import com.loc.devradar.data.remote.dto.ArticleDto
import retrofit2.http.GET
import retrofit2.http.Query

interface DevToApi {

    // Dev.to'nun base URL'sinin (https://dev.to/api/) sonuna "articles" eklenir.
    @GET("articles")
    suspend fun getArticles(
        // Sayfalama için kaçıncı sayfayı çekeceğimizi belirtir
        @Query("page") page: Int,

        // Bir sayfada kaç makale olacağını belirtir (Örn: 20)
        @Query("per_page") perPage: Int
    ): List<ArticleDto>

}