package com.cn.calculator

import android.view.LayoutInflater
import com.cn.calculator.core.BaseActivity
import com.cn.calculator.core.MessageListener
import com.cn.calculator.core.MessageSender
import com.cn.calculator.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(), MessageSender {

    override val getInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    companion object {
        const val KEYBOARD_TAG = "keyboard"
        const val SCREEN_TAG = "screen"
    }

    override fun initUI() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frm_keyboard, KeyboardFragment(), KEYBOARD_TAG)
        transaction.add(R.id.frm_screen, ScreenFragment(), SCREEN_TAG)
        transaction.commit()
    }

    override fun send(destination: String, data: Any) {
        val fragment = supportFragmentManager.findFragmentByTag(destination)
        if (fragment is MessageListener) {
            (fragment as MessageListener).onReceiveMessage(data)
        }
    }
}