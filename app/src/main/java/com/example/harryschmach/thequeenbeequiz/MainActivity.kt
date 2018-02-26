package com.example.harryschmach.thequeenbeequiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.*
import com.example.harryschmach.thequeenbeequiz.R.string.question_three_answer


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wikiTextView = findViewById<View>(R.id.wikipedia_source_tv) as TextView
        wikiTextView.movementMethod = LinkMovementMethod.getInstance()
    }

    fun gradeItAll(view: View){
        var totalRight = 0
        var toastOut = "You got "
        var wrongAnswers = ""
        // Get the response to question 1
        val questionOneCorrectKnob = findViewById<View>(R.id.question_one_correct) as RadioButton
        if (questionOneCorrectKnob.isChecked){
            totalRight += 1
        } else{
            wrongAnswers += "Q1 "
        }

        // Get responses to question 2
        val questionTwoCorrectA = findViewById<View>(R.id.question_two_correct_a) as CheckBox
        val questionTwoCorrectB = findViewById<View>(R.id.question_two_correct_b) as CheckBox
        val questionTwoIncorrect = findViewById<View>(R.id.question_two_incorrect) as CheckBox
        // Check if the incorrect box is checked and increment wrong answers if so
        when {
            questionTwoIncorrect.isChecked -> {
                wrongAnswers += "Q2 "
            }
        // If correct boxes are checked, increment correct tally
            questionTwoCorrectA.isChecked and questionTwoCorrectB.isChecked -> totalRight += 1
            else -> {
                wrongAnswers += "Q2 "
            }
        }
        // Get the third question text
        val questionThreeET = findViewById<View>(R.id.question_three_edit_text) as EditText
        // convert to lowercase for ease
        val responseString = questionThreeET.text.toString().toLowerCase()
        // If the strings match (user should be able to spell peanut correctly), increment right
        if (responseString == "peanut"){
            totalRight += 1
        }else{
            wrongAnswers += ("Q3: $responseString ")
        }

        // Get the fourth question correct Radio
        val questionFourCorrectKnob = findViewById<View>(R.id.question_four_correct) as RadioButton
        if (questionFourCorrectKnob.isChecked){
            totalRight += 1
        } else{
            wrongAnswers += "Q4"
        }

        // Tally total and toast it
        toastOut += totalRight.toString() + "/4 correct."
        val toastScore = Toast.makeText(this, toastOut, Toast.LENGTH_LONG)
        toastScore.show()

        if (totalRight == 4){
            wrongAnswers += "Congrats!"
        }else{
            wrongAnswers += " incorrect :("
        }

        // Report congrats if flawless and wrong questions if incorrect
        val toastSummary = Toast.makeText(this, wrongAnswers, Toast.LENGTH_LONG)
        toastSummary.show()

    }

    fun resetItAll(view: View){
        // Get a handle on all the fields
        val qOneCorrectKnob = findViewById<View>(R.id.question_one_correct) as RadioButton
        val qOneIncorrectKnob = findViewById<View>(R.id.question_one_incorrect) as RadioButton

        val qTwoCorrectA = findViewById<View>(R.id.question_two_correct_a) as CheckBox
        val qTwoCorrectB = findViewById<View>(R.id.question_two_correct_b) as CheckBox
        val qTwoIncorrect = findViewById<View>(R.id.question_two_incorrect) as CheckBox

        val qThreeET = findViewById<View>(R.id.question_three_edit_text) as EditText

        val qFourCorrectKnob = findViewById<View>(R.id.question_four_correct) as RadioButton
        val qFourIncorrectA = findViewById<View>(R.id.question_four_incorrect_a) as RadioButton
        val qFourIncorrectB = findViewById<View>(R.id.question_four_incorrect_b) as RadioButton

        // Clear all the fields
        qOneCorrectKnob.isChecked = false
        qOneIncorrectKnob.isChecked = false

        qTwoCorrectA.isChecked = false
        qTwoCorrectB.isChecked = false
        qTwoIncorrect.isChecked = false

        qThreeET.text.clear()

        qFourCorrectKnob.isChecked = false
        qFourIncorrectA.isChecked = false
        qFourIncorrectB.isChecked = false
    }
}
