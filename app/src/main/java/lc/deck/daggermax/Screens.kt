package lc.deck.daggermax

import androidx.fragment.app.Fragment
import lc.deck.daggermax.ui.FlowFragmentImpl
import lc.deck.daggermax.ui.Fragment1
import lc.deck.daggermax.ui.Fragment2
import lc.deck.daggermax.ui.Fragment3
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object Flow: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FlowFragmentImpl()
        }
    }

    object One: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return Fragment1()
        }
    }
    object Two: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return Fragment2()
        }
    }

    object Three: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return Fragment3()
        }
    }

}