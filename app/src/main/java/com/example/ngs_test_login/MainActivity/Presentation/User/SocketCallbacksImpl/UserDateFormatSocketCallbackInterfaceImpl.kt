package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserDateFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserDateFormatUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.SaveLocalUserDateFormatUseCase

class UserDateFormatSocketCallbackInterfaceImpl(private val dateFormatData: MutableLiveData<String?>,
                                                private val userRepository: UserRepository):
    UserDateFormatSocketCallbackInterface
{
    override fun onChanged(date: String?)
    {
        SaveLocalUserDateFormatUseCase(userRepository).execute(date)
        dateFormatData.postValue(GetLocalUserDateFormatUseCase(userRepository).execute())
    }
}