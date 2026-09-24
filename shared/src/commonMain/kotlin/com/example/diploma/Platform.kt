package com.example.diploma

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform