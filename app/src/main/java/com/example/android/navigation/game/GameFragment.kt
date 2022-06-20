package com.example.android.navigation.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentGameBinding
import kotlin.math.min

class GameFragment : Fragment(), QuestionsAnswers {

    lateinit var currentQuestion: QuestionsAnswers.Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = min((questions.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false
        )

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            playerSubmission(binding, view)
        }
        return binding.root
    }

    private fun playerSubmission(
        binding: FragmentGameBinding,
        view: View
    ) {
        val checkedId = binding.questionRadioGroup.checkedRadioButtonId
        // Do nothing if nothing is checked (id == -1)
        if (-1 != checkedId) {
            var answerIndex = 0
            when (checkedId) {
                R.id.secondAnswerRadioButton -> answerIndex = 1
                R.id.thirdAnswerRadioButton -> answerIndex = 2
                R.id.fourthAnswerRadioButton -> answerIndex = 3
            }
            // The first answer in the original question is always the correct one, so if our
            // answer matches, we have the correct answer.
            if (answers[answerIndex] == currentQuestion.answers[0]) {
                questionIndex++
                // Advance to the next question
                if (questionIndex < numQuestions) {
                    advanceToNextQuestion(binding)
                } else {
                    // We've won!  Navigate to the gameWonFragment.
                    view.findNavController()
                        .navigate(R.id.action_gameFragment_to_gameWonFragment)
                }
            } else {
                // Game over! A wrong answer sends us to the gameOverFragment.
                view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
            }
        }
    }

    private fun advanceToNextQuestion(binding: FragmentGameBinding) {
        currentQuestion = questions[questionIndex]
        setQuestion()
        binding.invalidateAll()
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_android_trivia_question, questionIndex + 1, numQuestions)
    }
}