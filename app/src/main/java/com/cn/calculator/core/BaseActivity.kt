package com.cn.calculator.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<BD: ViewBinding>: AppCompatActivity() {

    protected val binding by lazy { getInflater(layoutInflater) }

    protected abstract val getInflater: (LayoutInflater) -> BD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUI()
    }

    protected open fun initUI() {}
}