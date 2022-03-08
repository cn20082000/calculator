package com.cn.calculator

import android.view.LayoutInflater
import android.widget.Toast
import com.cn.calculator.core.BaseFragment
import com.cn.calculator.core.MessageListener
import com.cn.calculator.databinding.FragmentScreenBinding

class ScreenFragment : BaseFragment<FragmentScreenBinding>(), MessageListener {

    override val getInflater: (LayoutInflater) -> FragmentScreenBinding =
        FragmentScreenBinding::inflate

    override fun onReceiveMessage(data: Any) {
        when (val s = data as String) {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                binding.tvCurrent.text.let {
                    if (it.length < 9 || (it.contains(".") && it.length < 10)) {
                        binding.tvCurrent.text = "${it}$s"
                    }
                }
            }
            "." -> {
                binding.tvCurrent.text.let {
                    checkEmpty()
                    if (!it.contains(".") && it.length < 9) {
                        binding.tvCurrent.text = "$it."
                    }
                }
            }
            "+", "-", "*", "/" -> {
                checkEmpty()
                binding.tvPrev.text = "${binding.tvCurrent.text}$s"
                binding.tvCurrent.text = ""
            }
            "%" -> {
                checkEmpty()
                val num = binding.tvCurrent.text.toString().toDouble()
                binding.tvPrev.text = "$num%"
                binding.tvCurrent.text = "${num / 100}"
            }
            "=" -> {
                checkEmpty()
                if (binding.tvPrev.text.isNotEmpty()) {
                    binding.tvPrev.text.let { it.subSequence(0, it.length - 1) }.toString()
                        .toDoubleOrNull()?.let { num1 ->
                            val num2 = binding.tvCurrent.text.toString().toDouble()
                            val type = binding.tvPrev.text[binding.tvPrev.length() - 1].toString()
                            if (num2 == 0.0 && type == "/") {
                                Toast.makeText(context, "undefined", Toast.LENGTH_SHORT).show()
                                return
                            }
                            binding.tvPrev.text = "${binding.tvPrev.text}${binding.tvCurrent.text}="
                            binding.tvCurrent.text = "${calc(num1, num2, type)}"
                        }
                }
            }
            "+-" -> {
                binding.tvCurrent.text.let {
                    if (it.isNotEmpty()) {
                        if (it[0] == '-') {
                            binding.tvCurrent.text = it.substring(0, it.length - 1)
                        }
                        else {
                            binding.tvCurrent.text = "-$it"
                        }
                    }
                }
            }
            "del" -> {
                binding.tvCurrent.text.let {
                    if (it.isNotEmpty()) {
                        binding.tvCurrent.text = it.subSequence(0, it.length - 1)
                    }
                }
            }
            "c" -> {
                binding.tvCurrent.text = ""
                binding.tvPrev.text = ""
            }
        }
    }

    private fun checkEmpty() {
        if (binding.tvCurrent.text.isEmpty()) {
            binding.tvCurrent.text = "0"
        }
    }

    private fun calc(num1: Double, num2: Double, type: String): Double {
        return when (type) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            else -> num1 / num2
        }
    }
}