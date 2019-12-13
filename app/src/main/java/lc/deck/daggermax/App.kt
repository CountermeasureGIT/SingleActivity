package lc.deck.daggermax

import android.app.Application
import lc.deck.daggermax.koin.appModule
import lc.deck.daggermax.koin.flowModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.scope.Scope

class App : Application() {

//    private val flowComponentMap = HashMap<String, Scope>()

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, flowModule))
        }
    }

/*    fun getFlowComponent(fragmentScopeName: String): Scope {
        if (flowComponentMap[fragmentScopeName] == null) {
            val flowComponent = DaggerFlowComponent.factory().create(appComponent)
            flowComponentMap[fragmentScopeName] = flowComponent
        }
        return flowComponentMap[fragmentScopeName]!!
    }

    fun closeFlowComponent(fragmentScopeName: String) {
        flowComponentMap.remove(fragmentScopeName)
    }*/
}