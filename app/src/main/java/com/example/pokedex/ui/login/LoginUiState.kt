package com.example.pokedex.ui.login

sealed class LoginUiState {
    data object Initial: LoginUiState()
    data object LoggingIn: LoginUiState()
    data object LoggedIn: LoginUiState()
    data object Error: LoginUiState()

}