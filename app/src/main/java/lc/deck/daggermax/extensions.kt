package lc.deck.daggermax

import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace

fun Any.objectScopeName() = "${javaClass.simpleName}_${hashCode()}"

fun Navigator.setLaunchScreen(screen: SupportAppScreen) {
    applyCommands(
            arrayOf(
                    BackTo(null),
                    Replace(screen)
            )
    )
}


fun main() {
    val str: String = "123"
    val str1: String = "1234"

    println(str.javaClass.toString())
    println(str1.objectScopeName())
}