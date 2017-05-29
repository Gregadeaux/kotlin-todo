package com.rkkn.kotlinapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rkkn.kotlinapp.R
import com.rkkn.kotlinapp.controllers.TodoController
import com.rkkn.kotlinapp.data.Todo
import kotlinx.android.synthetic.main.item_todo.view.*

/**
 * Created by greg on 5/28/17.
 */
public class TodoAdapter : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    // Lateinit basically means this variable won't have a value until the constructor is called
    private lateinit var todos : List<Todo>

    // Constructor
    init {
        // Somehow, Kotlin didn't get Java 8's functional interfaces that would allow you to skip these first 2 lines of boilerplate
        val listener = object : TodoController.TodoSubscriber {
            override fun listUpdated(todoList: List<Todo>) {
                todos = todoList
                notifyDataSetChanged()
            }
        }

        TodoController.let {
            todos = it.todos()
            it.subscribe(listener)
        }
    }

    // Awesome easy method declarations though
    override fun getItemCount() = todos.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(todos[position])

    // Also shorthand constructor and super calls
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todo: Todo) = itemView.itemText.setText(todo.content)
    }
}