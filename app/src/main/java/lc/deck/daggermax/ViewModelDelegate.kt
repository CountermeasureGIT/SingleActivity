package lc.deck.daggermax

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


inline fun <reified VM : ViewModel> viewModelProvider(crossinline viewModel: () -> VM): ReadWriteProperty<Fragment, VM> =
        ViewModelDelegate { thisRef ->
            val vmf = object : ViewModelProvider.NewInstanceFactory() {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")
                    return viewModel.invoke() as T
                }
            }
            ViewModelProvider(thisRef, vmf)[VM::class.java]
        }

class ViewModelDelegate<R, T>(private val initializer: (R) -> T) : ReadWriteProperty<R, T> {

    private object EMPTY

    private var value: Any? = EMPTY

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        this.value = value
    }

    override fun getValue(thisRef: R, property: KProperty<*>): T {
        if (value == EMPTY) {
            value = initializer(thisRef)
        }
        @Suppress("UNCHECKED_CAST")
        return value as T
    }
}
