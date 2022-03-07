package com.cn.calculator.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<BD: ViewBinding>: Fragment() {

    protected val binding by lazy { getInflater(layoutInflater) }
    private var sender: MessageSender? = null

    protected abstract val getInflater: (LayoutInflater) -> BD

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MessageSender) {
            sender = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    protected fun send(destination: String, data: Any) {
        sender?.send(destination, data)
    }

    protected open fun initUI() {}
}