package com.allaykhalil.apicallingwithcoroutinesandhilt.models.base

data class ResponseError(
    var statusCode: Int? = null,
    var errorMessage: String? = null
)