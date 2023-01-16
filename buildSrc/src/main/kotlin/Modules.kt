import java.util.*

object Modules {
    const val ANDROID = ":android"
    const val IOS = ":iosApp"
    const val COMPOSE_UI = ":shared"
}

fun String.name() = drop(1)
fun String.dotted() = "." + this.toLowerCase(Locale.getDefault())
fun location(moduleName: String) = Configuration.Android.id + moduleName.name().dotted().replace("-", "")
