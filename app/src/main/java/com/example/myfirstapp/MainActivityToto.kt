package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivityToto: AppCompatActivity(), TodoOnClickLListener {

    private lateinit var todoListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setUpActivityViews()
    }

    private fun setUpActivityViews() {
        this.todoListRecyclerView = findViewById(R.id.todo_list_recycler_view)

        // Setup RV Adapter
        val todoAdapter = TodoListAdapter(arrayListOf(
            TodoModel("La note de Rishi", "17/05/2024", false),
            TodoModel("La note de Gilles", "17/05/2024", true),
            TodoModel("La note de Yanis", "17/05/2024", false),
            TodoModel("La note de Gilberto", "17/05/2024", true),
            TodoModel("La note de Cedric", "17/05/2024", false),
            TodoModel("La note de Alexis", "17/05/2024", true),
            TodoModel("La note de Augustin", "17/05/2024", false),
        ), this)

        // Setup Linear layout manager
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation  = LinearLayoutManager.VERTICAL

        this.todoListRecyclerView.layoutManager = linearLayoutManager
        this.todoListRecyclerView.setAdapter(todoAdapter)
    }

    override fun displayTodoDetail(todo: TodoModel) {
        Intent(this, TodoDetailActivity::class.java).also {
            startActivity(it)
        }
    }

    // A function that starts new activity with the selected todomodel
}

interface TodoOnClickLListener {
    fun displayTodoDetail(todo: TodoModel)
}