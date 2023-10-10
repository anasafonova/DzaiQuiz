package com.dzaigames.dzaiquiz.ui.mainMenu

data class MainMenuUiState(
    val questions: QuestionsUiState,
    val isRefreshing: Boolean,
    val isError: Boolean
)