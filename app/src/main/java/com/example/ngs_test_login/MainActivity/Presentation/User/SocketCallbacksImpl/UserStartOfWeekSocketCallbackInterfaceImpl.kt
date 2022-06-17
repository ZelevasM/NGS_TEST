package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserStartOfWeekSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserStartOfWeekUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.SaveLocalUserStartOfWeekUseCase

class UserStartOfWeekSocketCallbackInterfaceImpl(private val startOfWeekData: MutableLiveData<String?>,
                                            private val userRepository: UserRepository):
    UserStartOfWeekSocketCallbackInterface
{
    override fun onChanged(startOfWeek: String?)
    {
        SaveLocalUserStartOfWeekUseCase(userRepository).execute(startOfWeek)
        startOfWeekData.postValue(GetLocalUserStartOfWeekUseCase(userRepository).execute())
    }
}