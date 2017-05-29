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
    private lateinit var todos : List<Todo>

    init {
        val listener = object : TodoController.TodoSubscriber {
            override fun listUpdated(todoList: List<Todo>) {
                todos = todoList
                notifyDataSetChanged()
            }
        }

        TodoController.instance.let {
            todos = it.todos()
            it.subscribe(listener)
        }
    }

    override fun getItemCount() = todos.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(todos[position])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todo: Todo) = itemView.itemText.setText(todo.content)
    }
}