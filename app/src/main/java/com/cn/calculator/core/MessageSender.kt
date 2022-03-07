package com.cn.calculator.core

interface MessageSender {
    fun send(destination: String, data: Any)
}