package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNameSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserNameUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.SaveLocalUserNameUseCase

class UserNameSocketCallbackInterfaceImpl(private val userName: MutableLiveData<String?>,
                                          private val userRepository: UserRepository):
    UserNameSocketCallbackInterface
{
    override fun onChanged(name: String?)
    {
        SaveLocalUserNameUseCase(userRepository).execute(name)
        userName.postValue(GetLocalUserNameUseCase(userRepository).execute())
    }
}