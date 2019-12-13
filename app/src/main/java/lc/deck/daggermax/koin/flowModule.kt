package lc.deck.daggermax.koin

import lc.deck.daggermax.FlowRouter
import lc.deck.daggermax.ui.ViewModel1
import lc.deck.daggermax.ui.ViewModel2
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

val flowModule = module {

    scope(named("FlowScope")) {
        scoped<FlowRouter> { FlowRouter(get() as Router) }

        scoped<Cicerone<FlowRouter>> { Cicerone.create(get() as FlowRouter) }

        scoped<NavigatorHolder>(named("FlowNavigatorHolder")) { (get() as Cicerone<FlowRouter>).navigatorHolder }
    }
}

