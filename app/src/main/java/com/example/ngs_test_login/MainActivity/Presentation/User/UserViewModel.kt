package com.example.ngs_test_login.MainActivity.Presentation.User

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.User.UserInterfaceImpl
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalUserDbCloseUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalUserDbInitUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.AddLocalUserUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.GetLocalUserUseCase
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.*
import com.example.ngs_test_login.MainActivity.Presentation.ViewModelInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel(), ViewModelInterface
{
    private val userInterfaceImpl: UserInterfaceImpl = UserInterfaceImpl()

    override fun socketInit()
    {

    }

    override fun localDbInit(context: Context)
    {
        val localUserDbInitUseCase: LocalUserDbInitUseCase = LocalUserDbInitUseCase(userInterfaceImpl)
        localUserDbInitUseCase.execute(context)
    }

    override fun localDbClose()
    {
        val localUserDbCloseUseCase: LocalUserDbCloseUseCase = LocalUserDbCloseUseCase(userInterfaceImpl)
        localUserDbCloseUseCase.execute()
    }

    fun localDbSaveAll()
    {

    }

    fun addLocalUser(context: Context,user: User?)
    {
        val addLocalUserUseCase: AddLocalUserUseCase = AddLocalUserUseCase(userInterfaceImpl)
        addLocalUserUseCase.execute(context, user)
    }

    fun getLocalUser(): User?
    {
        val getLocalUserUseCase: GetLocalUserUseCase = GetLocalUserUseCase(userInterfaceImpl)
        val user: User? = getLocalUserUseCase.execute()
        return user
    }

    fun changeNotifications()
    {
        //send change to socket -> receive answer from socket -> store answer from socket locally
        // -> show answer from socket in UI
    }

    fun changeName()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeNameUseCase: ChangeNameUseCase = ChangeNameUseCase(userInterfaceImpl)
            changeNameUseCase.execute()
        }
    }

    fun changeEmail()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeEmailUseCase: ChangeEmailUseCase = ChangeEmailUseCase(userInterfaceImpl)
            changeEmailUseCase.execute()
        }
    }

    fun changePassword()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changePasswordUseCase: ChangePasswordUseCase = ChangePasswordUseCase(userInterfaceImpl)
            changePasswordUseCase.execute()
        }
    }

    fun changeLanguage()
    {}

    fun changeHomepage()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeHomepageUseCase: ChangeHomepageUseCase = ChangeHomepageUseCase(userInterfaceImpl)
            changeHomepageUseCase.execute()
        }
    }

    fun changeDateFormat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changedDateFormatUseCase: ChangeDateFormatUseCase = ChangeDateFormatUseCase(userInterfaceImpl)
            changedDateFormatUseCase.execute()
        }
    }

    fun changeTimeFormat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeTimeFormatUseCase: ChangeTimeFormatUseCase = ChangeTimeFormatUseCase(userInterfaceImpl)
            changeTimeFormatUseCase.execute()
        }
    }

    fun changeStartOfWeek()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeStartOfWeekUseCase: ChangeStartOfWeekUseCase = ChangeStartOfWeekUseCase(userInterfaceImpl)
            changeStartOfWeekUseCase.execute()
        }
    }

    fun changeExpandSubtask()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeExpandSubtaskUseCaseUseCase: ChangeExpandSubtaskUseCase = ChangeExpandSubtaskUseCase(userInterfaceImpl)
            changeExpandSubtaskUseCaseUseCase.execute()
        }
    }

    fun changeNewTask()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeNewTaskUseCase: ChangeNewTaskUseCase = ChangeNewTaskUseCase(userInterfaceImpl)
            changeNewTaskUseCase.execute()
        }
    }

    fun getLocalShortcuts()
    {}
}