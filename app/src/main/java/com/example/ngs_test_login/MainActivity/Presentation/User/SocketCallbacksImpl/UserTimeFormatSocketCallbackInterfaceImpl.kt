package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserTimeFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserTimeFormatUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.SaveLocalUserTimeFormatUseCase

class UserTimeFormatSocketCallbackInterfaceImpl(private val userTimeFormatData: MutableLiveData<String?>,
                                                private val userRepository: UserRepository):
    UserTimeFormatSocketCallbackInterface
{
    override fun onChanged(timeFormat: String?)
    {
        SaveLocalUserTimeFormatUseCase(userRepository).execute(timeFormat)
        userTimeFormatData.postValue(GetLocalUserTimeFormatUseCase(userRepository).execute())
    }
}