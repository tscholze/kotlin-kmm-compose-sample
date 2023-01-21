package io.github.tscholze.cmpsample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform