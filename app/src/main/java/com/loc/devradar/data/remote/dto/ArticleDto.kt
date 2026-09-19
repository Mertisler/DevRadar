package com.loc.devradar.data.remote.dto


import com.google.gson.annotations.SerializedName

// Gelen JSON dizisindeki her bir makale objesini temsil eder
data class ArticleDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("cover_image")
    val coverImage: String?, // Bazı makalelerde kapak fotoğrafı olmayabilir, bu yüzden nullable (?) yapıyoruz

    @SerializedName("user")
    val user: UserDto // Yazar bilgisi ayrı bir JSON objesi olduğu için iç içe sınıf kullanıyoruz
)

// Makaleyi yazan kullanıcının bilgilerini temsil eder
data class UserDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("profile_image")
    val profileImage: String?
)
