package com.dzaigames.dzaiquiz.ui.mainMenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dzaigames.dzaiquiz.data.repository.QuestionsRepository
import javax.inject.Inject

class MainMenuViewModelFactory @Inject constructor(private val repository: QuestionsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainMenuViewModel(questionsRepository = repository) as T
    }
}