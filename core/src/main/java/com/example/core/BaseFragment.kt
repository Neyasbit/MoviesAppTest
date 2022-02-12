package com.example.core


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.navigation.Navigation
import moxy.MvpAppCompatFragment

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : MvpAppCompatFragment() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    protected var navigator : Navigation = Navigation.Empty()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = context as Navigation
    }

    override fun onDetach() {
        super.onDetach()
        navigator = Navigation.Empty()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
