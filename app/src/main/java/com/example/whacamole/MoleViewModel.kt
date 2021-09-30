package com.example.whacamole

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whacamole.db.Mole
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MoleViewModel @Inject constructor(
    private val repository: MoleRepository
) : ViewModel() {


    fun insertValues() = runBlocking {
        repository.insertValues()
    }

    fun moleScore(): Int = runBlocking {
        repository.moleScore()
    }

    private fun update(item: Mole) = runBlocking {
        repository.update(item)
    }


    fun updateMole(score: Int) {
        val newScore = Mole(
            id = 1,
            score = score
        )
        update(newScore)
    }
}
