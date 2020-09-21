package com.example.datastructurestudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

internal class IntStackTest {
    lateinit var sut: IntStack

    @BeforeEach
    fun setUp() {
        sut = IntStack()
    }

    @Test
    fun print_method_will_show_stack_trace() {
        sut.push(1)
        sut.push(2)
        sut.push(3)

        val actual = sut.print()

        assertEquals("[1, 2, 3]", actual)
    }

    @Test
    fun pop_method_will_return_last_stack_and_remove_it() {
        sut.push(1)
        sut.push(2)
        sut.push(3)

        val actual = sut.pop()

        assertEquals(3, actual)
        assertEquals("[1, 2]", sut.print())
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

        val actual = sut.peek()

        assertEquals(3, actual)
        assertEquals("[1, 2, 3]", sut.print())
    }

    @Test
    fun peek_method_will_return_same_data_if_call_many_time() {
        sut.push(1)
        sut.push(2)
        sut.push(3)

        val first = sut.peek()
        val second = sut.peek()

        assertTrue {
            first == second
        }
    }

    @Test
    fun peek_method_will_return_throw_exception_if_empty_stack() {
        assertThrows<EmptyStackException> {
            sut.peek()
        }
    }
}