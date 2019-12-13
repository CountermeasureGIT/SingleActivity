package lc.deck.daggermax.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment.*
import lc.deck.daggermax.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class Fragment2 : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment

    private val viewModel: ViewModel2 by viewModel { parametersOf("lol", scopeName) }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.someText.observe(this, Observer { textView.text = it })
        nextButton.setOnClickListener { viewModel.onNextPressed() }
    }

    override fun onBackPressed() {
        viewModel.onBackPressed()
    }
}

/*
@Component(dependencies = [FlowRouterProvider::class, AppComponent::class])
@FragmentScope
interface Fragment2Component {

    fun viewModel2(): ViewModel2

    @Component.Factory
    interface Factory {


        fun create(
                flowRouterProvider: FlowRouterProvider,
                appComponent: AppComponent
        ): Fragment2Component
    }
}
*/
