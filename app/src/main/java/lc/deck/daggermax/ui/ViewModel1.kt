package lc.deck.daggermax.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lc.deck.daggermax.FlowRouter
import lc.deck.daggermax.Screens

class ViewModel1(
        someId: Int,
        private val router: FlowRouter
) : ViewModel() {

    val someText = MutableLiveData<String>().apply { value = someId.toString() }

    fun onBackPressed() {
        router.exit()
    }

    fun onNextPressed() {
        router.navigateTo(Screens.Two)
    }
}