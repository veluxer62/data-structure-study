package com.example.datastructurestudy

import java.util.*

interface Stack<T> {
    fun push(data: T)
    fun pop(): T
    fun peek(): T
}

class ArrayStack<T>(size: Int) : Stack<T> {
    private var top = -1
    private val stack = arrayOfNulls<Any>(size)

    override fun push(data: T) {
        stack[++top] = data
    }

    override fun pop(): T {
        val result = peek()
        top--

        return result
    }

    override fun peek(): T {
        if (top < 0) throw EmptyStackException()

        return stack[top] as T
    }
}

class LinkedListStack<T> : Stack<T> {
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