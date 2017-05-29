package com.rkkn.kotlinapp.controllers

import com.rkkn.kotlinapp.data.Todo

/**
 * Created by greg on 5/28/17.
 */
object TodoController{
    private val todos: MutableList<Todo> = mutableListOf()
    private val subscribers: MutableList<TodoSubscriber> = mutableListOf()

    // List is a read-only collection. Not 100% immutable
    fun todos(): List<Todo> = todos.toList()

    fun addTodo(todo: Todo) {
        todos.add(todo)
        subscribers.forEach { it.listUpdated(todos.toList()) }
    }

    fun removeTodo(todo: Todo) {
        todos.remove(todo)
        subscribers.forEach { it.listUpdated(todos.toList()) }
    }

    fun removeAt(index: Int) {
        todos.removeAt(index)
        subscribers.forEach { it.listUpdated(todos.toList()) }
    }

    fun subscribe(sub: TodoSubscriber) = subscribers.add(sub)
    fun unsubscribe(sub: TodoSubscriber) = subscribers.remove(sub)

    interface TodoSubscriber {
        fun listUpdated(todos: List<Todo>)
    }
}