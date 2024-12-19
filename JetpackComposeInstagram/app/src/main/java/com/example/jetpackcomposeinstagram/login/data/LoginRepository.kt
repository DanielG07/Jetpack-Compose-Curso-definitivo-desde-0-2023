package com.example.jetpackcomposeinstagram.login.data

import com.example.jetpackcomposeinstagram.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginApi : LoginService
) {

    suspend fun doLogin(user: String, password: String): Boolean{
        return loginApi.doLogin(user, password)
    }
}