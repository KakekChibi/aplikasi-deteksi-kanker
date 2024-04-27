package com.dicoding.asclepius.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.dicoding.asclepius.data.History
import com.dicoding.asclepius.data.HistoryDao
import com.dicoding.asclepius.data.HistoryDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class HistoryRepository(application: Application) {
    private val mHistoryDao: HistoryDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = HistoryDatabase.getDatabase(application)
        mHistoryDao = db.historyDao()
    }

    fun getAllNotes(): LiveData<List<History>> = mHistoryDao.getAll()
    fun insert(history: History) {
        executorService.execute { mHistoryDao.insert(history) }
    }

}