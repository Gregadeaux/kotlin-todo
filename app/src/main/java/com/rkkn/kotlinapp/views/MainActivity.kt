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

        todoList.layoutManager = LinearLayoutManager(this)
        todoList.adapter = TodoAdapter()

        TodoController.instance.addTodo(Todo("FINISH APP"))

    }

}
