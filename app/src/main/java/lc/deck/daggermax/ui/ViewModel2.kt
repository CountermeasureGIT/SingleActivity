package lc.deck.daggermax.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lc.deck.daggermax.FlowRouter
import lc.deck.daggermax.Screens

class ViewModel2(
        someString: String,
        private val router: FlowRouter
) : ViewModel() {

    val someText = MutableLiveData<String>().apply { value = someString }

    fun onBackPressed() {
        router.exit()
    }

    fun onNextPressed() {
        router.navigateTo(Screens.Three)
    }
}