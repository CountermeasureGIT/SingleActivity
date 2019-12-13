package lc.deck.daggermax

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import lc.deck.daggermax.ui.BaseFragment
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class AppActivity : AppCompatActivity() {
    private val navigator: Navigator =
            object : SupportAppNavigator(this, supportFragmentManager, R.id.layoutContainer) {
                override fun setupFragmentTransaction(
                        command: Command?,
                        currentFragment: Fragment?,
                        nextFragment: Fragment?,
                        fragmentTransaction: FragmentTransaction
                ) {
                    //fix incorrect order lifecycle callback of MainFragment
                    fragmentTransaction.setReorderingAllowed(true)
                }
            }


    private val currentFragment
        get() = supportFragmentManager.findFragmentById(R.id.layoutContainer) as? BaseFragment

    private val navigatorHolder: NavigatorHolder by inject()

    private val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_container)
        if (savedInstanceState == null) {
            router.newRootScreen(Screens.Flow)
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }
}