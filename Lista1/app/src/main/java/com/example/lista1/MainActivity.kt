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


class MainActivity : AppCompatActivity() {

    private val buttonYes: Button by lazy {findViewById(R.id.button_yes)}
    private val buttonNo: Button by lazy {findViewById(R.id.button_no)}
    private val buttonCheat: Button by lazy {findViewById(R.id.button_cheat)}
    private val question: TextView by lazy {findViewById(R.id.question)}
    private val questions by lazy {resources.getStringArray(R.array.questions)}
    private val answers by lazy {resources.getStringArray(R.array.answers)}
    private var index: Int = 0
    private var points: Int = 0
    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {

            val data: Intent? = result.data

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question.setText(questions[0])

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

    private fun changeActivity() {
        Log.d("C", "D")

        val changeActivityIntent = Intent(this, CheatActivity::class.java)

        val bundle: Bundle = Bundle()

        bundle.putInt("index", index)
        bundle.putInt("points", points)

        changeActivityIntent.putExtra("values", bundle)

        resultLauncher.launch(changeActivityIntent)
    }

    private fun buttonAction(answer: String) {
        if (index >= 0) {
            if (answers[index] == answer)
                points += 10
            ++index
            nextQuestion()
        }
    }

    private fun nextQuestion()
    {
        if (index == questions.size)
        {
            question.setText("Udało ci sie zdobyć " + points + " punktów!")
            makeButtonsInvisible()
            index = -1
            return
        }
        question.setText(questions[index])
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