package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserEmailSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserEmailUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.SaveLocalUserEmailUseCase

class UserEmailSocketCallbackInterfaceImpl(private val userMail: MutableLiveData<String?>,
                                            private val userRepository: UserRepository):
    UserEmailSocketCallbackInterface
{
    override fun onChanged(email: String?)
    {
        SaveLocalUserEmailUseCase(userRepository).execute(email)
        userMail.postValue(GetLocalUserEmailUseCase(userRepository).execute())
    }
}