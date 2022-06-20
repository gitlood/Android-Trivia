package com.example.android.navigation.game

interface QuestionsAnswers {
    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)


    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)
    val questions: MutableList<Question>
        get() = mutableListOf(
            Question(
                text = "What is Android Jetpack?",
                answers = listOf("All of these", "Tools", "Documentation", "Libraries")
            ),
            Question(
                text = "What is the base class for layouts?",
                answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
            ),
            Question(
                text = "What layout do you use for complex screens?",
                answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
            ),
            Question(
                text = "What do you use to push structured data into a layout?",
                answers = listOf("Data binding", "Data pushing", "Set text", "An OnClick method")
            ),
            Question(
                text = "What method do you use to inflate layouts in fragments?",
                answers = listOf(
                    "onCreateView()",
                    "onActivityCreated()",
                    "onCreateLayout()",
                    "onInflateLayout()"
                )
            ),
            Question(
                text = "What's the build system for Android?",
                answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
            ),
            Question(
                text = "Which class do you use to create a vector drawable?",
                answers = listOf(
                    "VectorDrawable",
                    "AndroidVectorDrawable",
                    "DrawableVector",
                    "AndroidVector"
                )
            ),
            Question(
                text = "Which one of these is an Android navigation component?",
                answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
            ),
            Question(
                text = "Which XML element lets you register an activity with the launcher activity?",
                answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
            ),
            Question(
                text = "What do you use to mark a layout for data binding?",
                answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
            )
        )

    data class Question(
        val text: String,
        val answers: List<String>
    )
}