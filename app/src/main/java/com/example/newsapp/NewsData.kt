package com.example.newsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsData(
    val newsCompany: String,
    val newsCompanyLogo: Int,
    val newsTitle: String,
    val newsTitleImage: Int,
    val newsArticle: String,
    val newsWriter: String,
    val newsAddDate: String,
) : Parcelable
