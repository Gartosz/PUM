package com.example.lista1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class CheatActivity : AppCompatActivity() {

    private var index: Int = 0
    private var points: Int = 0
    private val question: TextView by lazy {findViewById(R.id.question_cheat)}
    private val answer: TextView by lazy {findViewById(R.id.show_answer)}
    private val buttonYes: Button by lazy {findViewById(R.id.button_yes_cheat)}
    private val buttonNo: Button by lazy {findViewById(R.id.button_no_cheat)}
    private val buttonBack: Button by lazy {findViewById(R.id.button_back)}
    private val questions by lazy {resources.getStringArray(R.array.questions)}
    private val answers by lazy {resources.getStringArray(R.array.answers)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
        setValues()
        question.text = questions[index]

        buttonNo.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        buttonYes.setOnClickListener {
            changeButtonsVisibility()
            revealAnswer()
        }

        buttonBack.setOnClickListener {
            subtractPoints()
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

    private fun subtractPoints()
    {


    }

    private fun changeButtonsVisibility()
    {
        buttonYes.visibility = View.INVISIBLE
        buttonNo.visibility = View.INVISIBLE
        buttonBack.visibility = View.VISIBLE
    }

    private fun revealAnswer()
    {
        answer.text = "Prawidłowa odpowiedź: " + answers[index]
    }

    private fun setValues()
    {
        val i = intent
        val data = i.getBundleExtra("values")
        if (data != null) {
            index = data.getInt("index")
            points = data.getInt("points")
        }
    }


}