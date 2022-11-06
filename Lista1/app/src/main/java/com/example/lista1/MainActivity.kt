package com.example.lista1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KClass


private const val i = 10

class MainActivity : AppCompatActivity() {

    private val buttonYes: Button by lazy {findViewById(R.id.button_yes)}
    private val buttonNo: Button by lazy {findViewById(R.id.button_no)}
    private val buttonCheat: Button by lazy {findViewById(R.id.button_cheat)}
    private val question: TextView by lazy {findViewById(R.id.question)}
    private val questions by lazy {resources.getStringArray(R.array.questions)}
    private val answers by lazy {resources.getStringArray(R.array.answers)}
    private var index: Int = 0
    private var points: Int = 0
    private val correctAnswerPoint = 10
    private val cheatPoints = 15
    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            points -= cheatPoints
            nextQuestion()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("index")
            points = savedInstanceState.getInt("points")
        }

        question.setText(questions[index])

        buttonYes.setOnClickListener {
            buttonAction("Tak")
        }

        buttonNo.setOnClickListener {
            buttonAction("Nie")
        }

        buttonCheat.setOnClickListener {
            changeActivity()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("index", index)
        outState.putInt("points", points)

    }

    private fun changeActivity() {
        val changeActivityIntent = Intent(this, CheatActivity::class.java)

        val bundle: Bundle = Bundle()

        bundle.putInt("index", index)

        changeActivityIntent.putExtra("values", bundle)

        resultLauncher.launch(changeActivityIntent)
    }



    private fun buttonAction(answer: String) {
        if (index >= 0) {
            if (answers[index] == answer)
                points += correctAnswerPoint
            nextQuestion()
        }
    }

    private fun nextQuestion()
    {
        ++index
        if (index == questions.size)
            quizFinished()

        else
            question.setText(questions[index])
    }

    private fun quizFinished() {
        question.setText("Udało ci sie zdobyć " + points + " punktów!")
        makeButtonsInvisible()
        index = -1
        return
    }

    private fun makeButtonsInvisible() {
        buttonNo.visibility = View.INVISIBLE
        buttonYes.visibility = View.INVISIBLE
        buttonCheat.visibility = View.INVISIBLE
    }

    fun getData(): Pair<Int, Int>
    {
        return Pair(index, points)
    }

}