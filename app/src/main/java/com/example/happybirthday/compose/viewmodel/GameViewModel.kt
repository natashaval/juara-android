package com.example.happybirthday.compose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.happybirthday.compose.ui.GameUiState
import com.example.happybirthday.unscramble.ui.MAX_NO_OF_WORDS
import com.example.happybirthday.unscramble.ui.SCORE_INCREASE
import com.example.happybirthday.unscramble.ui.allWordsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by natasha.santoso on 25/10/22.
 */

class GameViewModel : ViewModel() {
  // Game UI state
  private val _uiState = MutableStateFlow(GameUiState())
  // Backing property to avoid state updates from other classes
  val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

  private lateinit var currentWord: String
  // Set of words used in the game
  private var usedWords: MutableSet<String> = mutableSetOf()
  var userGuess by mutableStateOf("")
    private set

  init {
    resetGame()
  }

  private fun pickRandomWordAndShuffle(): String {
    // Continue picking up a new random word until you get one that hasn't been used before
    currentWord = allWordsList.random()
    if (usedWords.contains(currentWord)) {
      return pickRandomWordAndShuffle()
    } else {
      usedWords.add(currentWord)
      return shuffleCurrentWord(currentWord)
    }
  }

  private fun shuffleCurrentWord(word: String): String {
    val tempWord = word.toCharArray()
    // Scramble the word
    tempWord.shuffle()
    while (String(tempWord).equals(word)) {
      tempWord.shuffle()
    }
    return String(tempWord)
  }

  fun resetGame() {
    usedWords.clear()
    _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
  }

  fun updateUserGuess(guessedWord: String) {
    userGuess = guessedWord
  }

  fun checkUserGuess() {
    if (userGuess.equals(currentWord, ignoreCase = true)) {
      // User's guess is correct, increase the score
      // and call updateGameState() to prepare the game for next round
      val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
      updateGameState(updatedScore)
    } else {
      // User's guess is wrong, show an error
      _uiState.update { currentState ->
        currentState.copy(isGuessedWordWrong = true)
      }
    }
    // Reset user guess
    updateUserGuess("")
  }

  private fun updateGameState(updatedScore: Int) {
    if (usedWords.size == MAX_NO_OF_WORDS) {
      _uiState.update { currentState ->
        currentState.copy(
          isGuessedWordWrong = false,
          score = updatedScore,
          isGameOver = true
        )
      }
    } else {
      _uiState.update { currentState ->
        currentState.copy(
          isGuessedWordWrong = false,
          currentScrambledWord = pickRandomWordAndShuffle(),
          score = updatedScore,
          currentWordCount = currentState.currentWordCount.inc()
        )
      }
    }
  }

  fun skipWord() {
    updateGameState(_uiState.value.score)
    updateUserGuess("")
  }
}