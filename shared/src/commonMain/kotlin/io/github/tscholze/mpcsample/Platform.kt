package io.github.tscholze.mpcsample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform