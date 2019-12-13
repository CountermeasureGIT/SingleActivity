package lc.deck.daggermax.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment.*
import lc.deck.daggermax.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class Fragment1 : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment

    private val viewModel: ViewModel1 by viewModel {
        parametersOf(1, scopeName)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.someText.observe(this, Observer<String> { textView.text = it })
        nextButton.setOnClickListener { viewModel.onNextPressed() }
    }

    override fun onBackPressed() {
        viewModel.onBackPressed()
    }
}

/*
@Component(dependencies = [FlowComponent::class])
@FragmentScope
interface Fragment1Component {

    fun viewModel(): ViewModel1

    @Component.Factory
    interface Factory {
        fun create(
                flowComponent: FlowComponent,
                @BindsInstance @Named("Some Id") someId: PrimitiveWrapper<Int>
        ): Fragment1Component
    }
}
*/
