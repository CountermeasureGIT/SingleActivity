package lc.deck.daggermax.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract val layoutRes: Int

    private val viewHandler = Handler()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutRes, container, false)

    // Fix for async views (like swipeToRefresh and RecyclerView)
    // If synchronously call actions on swipeToRefresh in sequence show and hide then swipeToRefresh will not hidden
    protected fun postViewAction(action: () -> Unit) {
        viewHandler.post(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewHandler.removeCallbacksAndMessages(null)
    }

    open fun onBackPressed() {}

    val scopeName: String
        get() = when(parentFragment) {
            is FlowFragment -> (parentFragment as FlowFragment).fragmentScopeName
            is BaseFragment -> (parentFragment as BaseFragment).scopeName
            else -> throw IllegalStateException("There is no FlowFragment in fragment-tree")
        }
}
