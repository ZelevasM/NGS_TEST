package com.example.ngs_test_login.LoginActivity.Presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ngs_test_login.LoginActivity.Data.LoginInterfaceImpl
import com.example.ngs_test_login.LoginActivity.Domain.Email.CheckEmailUseCase
import com.example.ngs_test_login.LoginActivity.Domain.Email.CheckPassUseCase
import com.example.ngs_test_login.LoginActivity.Domain.Email.CreateAccUseCase
import com.example.ngs_test_login.LoginActivity.Domain.Models.User

class LoginViewModel : ViewModel()
{
    var loginInterfaceImpl = LoginInterfaceImpl()
    var user = User(email = "", name = "", password = "")
    val resultLive = MutableLiveData<Boolean>()

    fun emailCheck(email: String)
    {
        resultLive.value = false
        user.e = email
        val checkEmailUseCase = CheckEmailUseCase(loginInterfaceImpl)
        resultLive.value = checkEmailUseCase.execute(user)
        Log.d("MyLog","VMemail: ${resultLive.value}")
    }

    fun emailPassCheck(password: String)
    {
        resultLive.value = false
        user.p = password
        val checkPassUseCase = CheckPassUseCase(loginInterfaceImpl)
        resultLive.value = checkPassUseCase.execute(user)
        Log.d("MyLog","VMpass: ${resultLive.value}")

    }

    fun emailSignUp(name: String, password: String)
    {
        resultLive.value = false
        user.n = name
        user.p = password
        val createAcccheckPassUseCase = CreateAccUseCase(loginInterfaceImpl)
        resultLive.value = createAcccheckPassUseCase.execute(user)
        Log.d("MyLog","VMpass: ${resultLive.value}")
    }

    fun privacy()
    {

    }

    fun terms()
    {

    }


}