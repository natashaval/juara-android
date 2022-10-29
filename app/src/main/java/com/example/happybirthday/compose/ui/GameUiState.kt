package com.example.happybirthday.compose.ui

/**
 * Created by natasha.santoso on 25/10/22.
 */
data class GameUiState(
  val currentScrambledWord: String = "",
  val isGuessedWordWrong: Boolean = false,
  val score: Int = 0,
  val currentWordCount: Int = 0,
  val isGameOver: Boolean = false
)
