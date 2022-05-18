package com.example.vjezba.data

data class QueryResponse(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val items: List<RepositoriesResponse>
)
