package lc.deck.daggermax.ui

import lc.deck.daggermax.Screens
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FlowFragmentImpl : FlowFragment() {
    override fun getLaunchScreen(): SupportAppScreen {
        return Screens.One
    }
}