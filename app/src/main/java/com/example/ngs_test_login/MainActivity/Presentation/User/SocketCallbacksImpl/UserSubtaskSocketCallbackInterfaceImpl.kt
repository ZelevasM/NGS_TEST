package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserSubtaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserExpandSubtaskUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.SaveLocalUserExpandSubtaskUseCase

class UserSubtaskSocketCallbackInterfaceImpl(private val expandSubtask: MutableLiveData<String?>,
                                        private val userRepository: UserRepository):
    UserSubtaskSocketCallbackInterface
{
    override fun onChanged(subTask: String?)
    {
        SaveLocalUserExpandSubtaskUseCase(userRepository).execute(subTask)
        expandSubtask.postValue(GetLocalUserExpandSubtaskUseCase(userRepository).execute())
    }
}