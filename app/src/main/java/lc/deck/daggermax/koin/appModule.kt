package lc.deck.daggermax.koin

import lc.deck.daggermax.ui.ViewModel1
import lc.deck.daggermax.ui.ViewModel2
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.ScopeID
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

val appModule = module {

    single<Cicerone<Router>> { Cicerone.create() } bind (Cicerone::class)

    single<Router> { (get() as Cicerone<Router>).router }

    single<NavigatorHolder> { (get() as Cicerone<Router>).navigatorHolder }

    viewModel { (id: Int, scopeId: ScopeID) -> ViewModel1(id, getScope(scopeId).get()) }

    viewModel { (someString: String, scopeId: ScopeID) -> ViewModel2(someString, getScope(scopeId).get()) }
}