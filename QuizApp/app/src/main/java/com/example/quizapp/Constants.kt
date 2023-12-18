package com.example.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        //1
        val qnOne = Question(
            1,
            "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Germany",
            "Australia",
            "Kuwait",
            1
        )

        questionList.add(qnOne)

        //2
        val qnTwo = Question(
            2,
            "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Germany",
            "Australia",
            "France",
            3
        )

        questionList.add(qnTwo)

        //3
        val qnThree = Question(
            3,
            "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Germany",
            "Australia",
            "Kuwait",
            1
        )

        questionList.add(qnThree)

        val qnFour = Question(
            4,
            "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "Denmark",
            "Australia",
            "Kuwait",
            2
        )

        questionList.add(qnFour)
//5
        val qnFive = Question(
            5,
            "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_india,
            "India",
            "France",
            "Australia",
            "Kuwait",
            1
        )

        questionList.add(qnFive)
//6
        val qnSix = Question(
            6,
            "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "Brazil",
            "Denmark",
            "Kuwait",
            2
        )

        questionList.add(qnSix)
//7
        val qnSeven = Question(
            7,
            "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_germany,
            "Argentina",
            "Germany",
            "Australia",
            "Kuwait",
            2
        )

        questionList.add(qnSeven)
//8
        val qnEight = Question(
            8,
            "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "Germany",
            "Australia",
            "New Zealand",
            4
        )

        questionList.add(qnOne)
//9
        val qnNine = Question(
            9,
            "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina",
            "Germany",
            "Australia",
            "Kuwait",
            4
        )

        questionList.add(qnNine)
//        //10
//        val qnTen = Question(
//            10,
//            "Which country does this flag belongs to?",
//            R.drawable.ic_flag_of_fiji,
//            "Argentina",
//            "Fiji",
//            "Australia",
//            "Kuwait",
//            2
//        )

//        questionList.add(qnTen)
        return questionList

    }
}