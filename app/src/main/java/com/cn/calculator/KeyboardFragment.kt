package com.cn.calculator

import android.view.LayoutInflater
import com.cn.calculator.core.BaseFragment
import com.cn.calculator.databinding.FragmentKeyboardBinding

class KeyboardFragment: BaseFragment<FragmentKeyboardBinding>() {

    override val getInflater: (LayoutInflater) -> FragmentKeyboardBinding =
        FragmentKeyboardBinding::inflate

    override fun initUI() {
        buttonEvent()
    }

    private fun buttonEvent() {
        binding.btnNum0.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "0")
        }
        binding.btnNum1.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "1")
        }
        binding.btnNum2.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "2")
        }
        binding.btnNum3.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "3")
        }
        binding.btnNum4.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "4")
        }
        binding.btnNum5.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "5")
        }
        binding.btnNum6.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "6")
        }
        binding.btnNum7.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "7")
        }
        binding.btnNum8.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "8")
        }
        binding.btnNum9.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "9")
        }
        binding.btnDel.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "del")
        }
        binding.btnClear.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "c")
        }
        binding.btnDot.setOnClickListener {
            send(MainActivity.SCREEN_TAG, ".")
        }
        binding.btnPlus.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "+")
        }
        binding.btnSubtract.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "-")
        }
        binding.btnMulti.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "*")
        }
        binding.btnDivide.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "/")
        }
        binding.btnResult.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "=")
        }
        binding.btnPercent.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "%")
        }
        binding.btnReverse.setOnClickListener {
            send(MainActivity.SCREEN_TAG, "+-")
        }
    }
}