package com.example.android_graphql.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment

abstract class BaseComposeFragment : Fragment() {

    private var toast: Toast? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(setCompositionStrategy())
            setContent {
                SetMainUI()
            }
        }
    }


    @Composable
    protected abstract fun SetMainUI()

    protected open fun setCompositionStrategy(): ViewCompositionStrategy {
        return ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
    }

    protected fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        toast?.cancel()
        toast = Toast.makeText(requireContext(), message, duration)
        toast?.show()
    }

}