package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserHomepageSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserHomepageUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.SaveLocalUserHomepageUseCase

class UserHomepageSocketCallbackInterfaceImpl(private val homepageData: MutableLiveData<String?>,
                                            private val userRepository: UserRepository)
    : UserHomepageSocketCallbackInterface
{
    override fun onChanged(homepage: String?)
    {
        SaveLocalUserHomepageUseCase(userRepository).execute(homepage)
        homepageData.postValue(GetLocalUserHomepageUseCase(userRepository).execute())
    }
}