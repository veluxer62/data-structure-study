package com.example.datastructurestudy

import java.util.*

interface Stack<T> {
    fun push(data: T)
    fun pop(): T
    fun peek(): T
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
}

class NodeStack<T> : Stack<T> {
    private inner class Node<T>(val data: T) {
        var next: Node<T>? = null
    }

    private var top: Node<T>? = null

    override fun push(data: T) {
        val node = Node(data)
        node.next = top
        top = node
    }

    override fun pop(): T {
        val result = peek()
        top = top?.next

        return result
    }

    override fun peek(): T {
        return top?.data ?: throw EmptyStackException()
    }
}