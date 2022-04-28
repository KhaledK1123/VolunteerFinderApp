package com.ex.volunteerfinder.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.viewmodel.ApiEventViewModel

class ConversationViewModelFactory: ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConversationViewModelFactory() as T

    }
}