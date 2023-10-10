package com.dzaigames.dzaiquiz.ui.mainMenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dzaigames.dzaiquiz.data.model.QuestionDto
import com.dzaigames.dzaiquiz.data.repository.QuestionsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class MainMenuViewModel @Inject constructor(
    questionsRepository: QuestionsRepository
): ViewModel() {
//    lateinit
    var questions: StateFlow<List<QuestionDto>> = questionsRepository
        .getQuestions()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = listOf()
        )
//    = MutableStateFlow(
//        listOf()
//    ) //LiveData<List<QuestionDto>>

//    init {
////        loadQuestions()
//    }

//    private fun loadQuestions() {
//        viewModelScope.launch {
//            questions =
//                questionsRepository.getQuestions().stateIn(viewModelScope)
//        //.asLiveData(Dispatchers.IO)
////            questionsRepository.getQuestions()
////                .catch {
////                    // error handling
////                }
////                .collect { questions ->
////                    this.questions = questions
////                }
//        }
//    }

}