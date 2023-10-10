package com.dzaigames.dzaiquiz.ui.mainMenu

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.dzaigames.dzaiquiz.data.model.QuestionDto

@Composable
fun MainMenuScreen(
//    navController: NavController,
    viewModel: MainMenuViewModel
) {
    val questions = viewModel.questions.collectAsState() //.observeAsState().value

    ItemsColumn(questions = questions.value)
}

@Composable
fun ItemsColumn(
    questions: List<QuestionDto>
) {
    LazyColumn {
        item {
            Text(
                text = "DzaiQuestions"
            )
        }

        if (questions.isNotEmpty())
            items(
                questions.size
            ) {
                Text(text = questions[it].toString())
            }
    }
}