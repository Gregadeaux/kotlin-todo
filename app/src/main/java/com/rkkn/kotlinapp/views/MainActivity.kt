package com.rkkn.kotlinapp.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.rkkn.kotlinapp.R
import com.rkkn.kotlinapp.adapters.TodoAdapter
import com.rkkn.kotlinapp.controllers.TodoController
import com.rkkn.kotlinapp.data.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Kotlin's Android Extension Library adds your view's UI elements as instance variables on the view
        // So you don't need to do findViewById(R.id.todoList), you can just use todoList
        this.todoList.layoutManager = LinearLayoutManager(this)
        this.todoList.adapter = TodoAdapter()

        TodoController.addTodo(Todo("FINISH APP"))

    }

}
