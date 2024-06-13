package com.example.myfirstapp.network

import com.example.myfirstapp.model.TodoDto
import retrofit2.Call

class TodosRepository(private val todoService: TodoServices) {

    fun fetchTodos(): Call<List<TodoDto>> {
        return todoService.getTodos()
    }
}