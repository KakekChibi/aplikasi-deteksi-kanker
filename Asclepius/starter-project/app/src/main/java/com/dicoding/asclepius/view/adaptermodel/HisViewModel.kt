package com.dicoding.asclepius.view.adaptermodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.dicoding.asclepius.data.History
import com.dicoding.asclepius.data.repository.HistoryRepository

class HisViewModel(application: Application) : ViewModel() {
    private val mHistoryRepository: HistoryRepository = HistoryRepository(application)

    fun insert(history: History) {
        mHistoryRepository.insert(history)
    }


}