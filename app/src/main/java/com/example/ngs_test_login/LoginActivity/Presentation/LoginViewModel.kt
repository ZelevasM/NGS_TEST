package com.example.ngs_test_login.LoginActivity.Presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ngs_test_login.LoginActivity.Data.LoginInterfaceImpl
import com.example.ngs_test_login.LoginActivity.Domain.Email.CheckEmailUseCase
import com.example.ngs_test_login.LoginActivity.Domain.Email.CheckPassUseCase
import com.example.ngs_test_login.LoginActivity.Domain.Email.CreateAccUseCase
import com.example.ngs_test_login.LoginActivity.Domain.Models.UserFromLogin

/**
 * LoginViewModel is a ViewModel that provides a layer between UI components and other layers.
 * Basically, it prevents direct communication between UI components,
 * and back-end of the application,
 * providing better flexibility of UI controlling
 */
class LoginViewModel : ViewModel()
{
    /// variable that holds all implementations for each of the UseCases
    var loginInterfaceImpl = LoginInterfaceImpl()
    /// variable user is used to get the data incoming from the classes that utilize the ViewModel through its methods,
    /// and then hold the data, that can be accessed when required
    var userFromLogin = UserFromLogin(email = "", name = "", password = "")
    val resultLive = MutableLiveData<Boolean>()

    /**
     * fun emailCheck performs the checking of the input email, sending the data in the following path:
     * emailCheck -> checkEmailUseCase(loginInterfaceImpl).execute -> LoginInterfaceImpl.emailCheck -> AsyncGet.searchEmail,
     * and returning the boolean value, that it has received from the above mentioned path but in the reverse,
     * to variable resultLive
     * @param email: String
     */
    fun emailCheck(email: String)
    {
        resultLive.value = false
        userFromLogin.e = email
        val checkEmailUseCase = CheckEmailUseCase(loginInterfaceImpl)
        resultLive.value = checkEmailUseCase.execute(userFromLogin)
        Log.d("MyLog","VMemail: ${resultLive.value}")
    }

    /**
     * fun emailPassCheck performs the checking of the input password, sending the data in the following path:
     * emailPassCheck -> checkPassUseCase(loginInterfaceImpl).execute -> LoginInterfaceImpl.emailPassCheck -> AsyncGet.signIn,
     * and returning the boolean value, that it has received from the above mentioned path but in the reverse,
     * to variable resultLive
     * @param password: String
     */
    fun emailPassCheck(password: String)
    {
        resultLive.value = false
        userFromLogin.p = password
        val checkPassUseCase = CheckPassUseCase(loginInterfaceImpl)
        resultLive.value = checkPassUseCase.execute(userFromLogin)
        Log.d("MyLog","VMpass: ${resultLive.value}")
    }

    /**
     * fun emailPassCheck performs the checking of the input password, sending the data in the following path:
     * emailPassCheck -> checkPassUseCase(loginInterfaceImpl).execute -> LoginInterfaceImpl.emailPassCheck -> AsyncGet.signIn,
     * and returning the boolean value, that it has received from the above mentioned path but in the reverse,
     * to variable resultLive
     * @param name: String
     * @param password: String
     */
    fun emailSignUp(name: String, password: String)
    {
        resultLive.value = false
        userFromLogin.n = name
        userFromLogin.p = password
        val createAccCheckPassUseCase = CreateAccUseCase(loginInterfaceImpl)
        resultLive.value = createAccCheckPassUseCase.execute(userFromLogin)
        Log.d("MyLog","VMpass: ${resultLive.value}")
    }

    fun privacy()
    {

    }

    fun terms()
    {

    }


}