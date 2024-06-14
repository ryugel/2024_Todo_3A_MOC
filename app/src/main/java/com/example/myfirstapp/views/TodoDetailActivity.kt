package com.example.myfirstapp.views

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.R

class TodoDetailActivity : AppCompatActivity() {

    lateinit var todoTitleTextView: TextView
    lateinit var todoDateTextView: TextView
    lateinit var todoDescriptionTextView: TextView

    lateinit var deleteImageView: ImageView
    lateinit var updateImageView: ImageView
    lateinit var validateTodoButton: Button

    // Data from intent
    private lateinit var todoDetailTitle: String
    private lateinit var todoDetailDesc: String
    private lateinit var todoDetailDate: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_detail)

        this.getIntentExtraData()

        this.setupViews()
        this.handleButtonObservation()
    }


    private fun getIntentExtraData() {
        if (this.intent.hasExtra("TODO_TITLE_TEXT") &&
            this.intent.hasExtra("TODO_DESC_TEXT") &&
            this.intent.hasExtra("TODO_DATE_TEXT")) {

            this.todoDetailTitle = intent.getStringExtra("TODO_TITLE_TEXT")!!
            this.todoDetailDesc = intent.getStringExtra("TODO_DESC_TEXT")!!
            this.todoDetailDate = intent.getStringExtra("TODO_DATE_TEXT")!!
        }
    }
    private fun setupViews() {
        this.todoTitleTextView = findViewById(R.id.todo_detail_title_text_view)
        this.todoTitleTextView.text = this.todoDetailTitle

        this.todoDateTextView = findViewById(R.id.todo_detail_date_text_view)
        this.todoDateTextView.text = this.todoDetailDate

        this.todoDescriptionTextView = findViewById(R.id.todo_detail_description_text_view)
        this.todoDescriptionTextView.text = this.todoDetailDesc

        this.deleteImageView = findViewById(R.id.delete_todo_image_view)
        this.updateImageView = findViewById(R.id.edit_todo_image_view)
        this.validateTodoButton = findViewById(R.id.validate_todo_button)
    }

    private fun handleButtonObservation() {
        this.handleTodoDeleting()
        this.handleTodoEditing()
        this.handleTodoValidating()
    }

    private fun handleTodoDeleting(){
        this.updateImageView.setOnClickListener {
            Log.d("Update TODO", "Updating TODO")
        }
    }

    private fun handleTodoEditing(){
        this.deleteImageView.setOnClickListener {
            Log.d("Delete TODO", "Deleting TODO")
        }
    }

    private fun handleTodoValidating(){
        this.validateTodoButton.setOnClickListener {
            Log.d("Validate TODO", "Validating TODO")
        }
    }
}