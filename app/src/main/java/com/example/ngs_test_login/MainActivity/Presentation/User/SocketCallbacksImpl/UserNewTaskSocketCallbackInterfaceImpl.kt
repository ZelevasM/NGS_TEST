package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNewTaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserNewTaskUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.SaveLocalUserNewTaskUseCase

class UserNewTaskSocketCallbackInterfaceImpl(private val userNewTaskData: MutableLiveData<String?>,
                                        private val userRepository: UserRepository):
    UserNewTaskSocketCallbackInterface
{
    override fun onChanged(newTask: String?)
    {
        SaveLocalUserNewTaskUseCase(userRepository).execute(newTask)
        userNewTaskData.postValue(GetLocalUserNewTaskUseCase(userRepository).execute())
    }
}