package lc.deck.daggermax.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment.*
import lc.deck.daggermax.FlowRouter
import lc.deck.daggermax.R

class Fragment3 : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment

    private val router: FlowRouter by lazy { (parentFragment as FlowFragment).flowScope.get<FlowRouter>() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        textView.text = javaClass.canonicalName
        nextButton.visibility = View.GONE
    }

    override fun onBackPressed() {
        router.exit()
    }
}