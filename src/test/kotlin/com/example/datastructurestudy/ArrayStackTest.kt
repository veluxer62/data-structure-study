package com.example.datastructurestudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*
import kotlin.system.measureTimeMillis

internal class ArrayStackTest {
    lateinit var sut: ArrayStack<Int>

    @BeforeEach
    fun setUp() {
        sut = ArrayStack()
    }

    @Test
    fun pop_method_will_return_last_stack_and_remove_it() {
        sut.push(1)
        sut.push(2)
        sut.push(3)

        assertEquals(3, sut.pop())
        assertEquals(2, sut.pop())
        assertEquals(1, sut.pop())
    }

    @Test
    fun pop_method_will_return_throw_exception_if_empty_stack() {
        assertThrows<EmptyStackException> {
            sut.pop()
        }
    }

    @Test
    fun pop_method_will_return_throw_exception_if_call_pop_more_than_stack() {
        sut.push(1)
        sut.push(2)
        sut.push(3)

        assertThrows<EmptyStackException> {
            sut.pop()
            sut.pop()
            sut.pop()
            sut.pop()
        }
    }

    @Test
    fun peek_method_will_return_last_stack() {
        sut.push(1)
        sut.push(2)
        sut.push(3)

        assertEquals(3, sut.peek())
        assertEquals(3, sut.peek())
    }

    @Test
    fun peek_method_will_return_throw_exception_if_empty_stack() {
        assertThrows<EmptyStackException> {
            sut.peek()
        }
    }

    @Test
    fun speed_test() {
        val elapsed = measureTimeMillis {
            (1..999999999).forEach {
                sut.push(it)
                sut.peek()
                sut.pop()
            }
        }

        println(elapsed)
    }
}