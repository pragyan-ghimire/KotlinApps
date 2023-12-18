package com.example.jettriviaapp.repository

import com.example.jettriviaapp.model.QuestionItem
import com.example.jettriviaapp.network.QuestionApi
import javax.inject.Inject


class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val listOfQuestions = ArrayList<QuestionItem>(emptyList())
}