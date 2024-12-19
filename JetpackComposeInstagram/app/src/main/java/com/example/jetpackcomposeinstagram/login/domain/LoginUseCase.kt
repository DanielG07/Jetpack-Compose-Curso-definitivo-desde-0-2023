package com.example.jetpackcomposeinstagram.login.domain

import com.example.jetpackcomposeinstagram.login.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
){

    suspend operator fun invoke(user: String, password: String): Boolean {
        return loginRepository.doLogin(user, password)
    }
}