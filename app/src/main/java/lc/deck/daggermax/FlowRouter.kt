package lc.deck.daggermax

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen

class FlowRouter(private val router: Router) : Router() {

    fun startNewFlow(screen: Screen) {
        router.navigateTo(screen)
    }
}