package com.example.datastructurestudy

import java.util.*

interface Stack<T> {
    fun push(data: T)
    fun pop(): T
    fun peek(): T
    fun print(): String
}

class IntStack : Stack<Int> {
    private var top = -1
    private val stack = mutableListOf<Int>()

    override fun push(data: Int) {
        stack.add(++top, data)
    }

    override fun pop(): Int {
        val result = peek()
        stack.removeAt(top)
        top--

        return result
    }

    override fun peek(): Int {
        if (top < 0) throw EmptyStackException()

        return stack[top]
    }

    override fun print(): String {
        return stack.toString()
    }
}