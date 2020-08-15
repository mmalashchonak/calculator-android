package com.itrestum.calculator.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itrestum.calculator.History
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class SearchViewModel(private val repository: MainRepository) : ViewModel() {

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    private val _history = MutableLiveData<String>()
    val history: LiveData<String> = _history

    private val _histories = MutableLiveData<List<History>>()
    val histories: LiveData<List<History>> = _histories

    fun calculate(str: String) {
        try {
            val ex = ExpressionBuilder(str).build()
            val result = ex.evaluate()

            val longres = result.toLong()

            val displayedResult = if (result == longres.toDouble()) longres.toString()
            else result.toString()

            _data.value = displayedResult
            _history.value = "$str = $displayedResult"

            viewModelScope.launch {
                repository.insertAll(History("$str = $displayedResult"))
            }
        } catch (e: Exception) {
            Log.d("Error!", "Message: ${e.message}")
        }

    }

    fun onClearHistory() {
        viewModelScope.launch {
            repository.onClearHistory()
        }
    }

    fun getHistories() {
        viewModelScope.launch {
            _histories.value = repository.getAll()
        }
    }

}