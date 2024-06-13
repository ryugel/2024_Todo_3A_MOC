package com.example.myfirstapp.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myfirstapp.model.TodoDto
import com.example.myfirstapp.network.TodosRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoViewModel(private val todoRepository: TodosRepository, val context: Context) {
    var todos: MutableLiveData<ArrayList<TodoDto>> = MutableLiveData()

    fun fetchTodoFromRepo() {
        val todosApiResponse = this.todoRepository.fetchTodos()

        todosApiResponse.enqueue(object : Callback<List<TodoDto>> {
            override fun onFailure(p0: Call<List<TodoDto>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(p0: Call<List<TodoDto>>, response: Response<List<TodoDto>>) {
                val responseBody: List<TodoDto>? = response.body()
                todos.value = ArrayList(responseBody ?: listOf())
            }
        })
    }
}