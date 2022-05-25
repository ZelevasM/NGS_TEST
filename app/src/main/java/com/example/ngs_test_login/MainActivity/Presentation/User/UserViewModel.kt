package com.example.ngs_test_login.MainActivity.Presentation.User

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.User.UserInterfaceImpl
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.LocalUserDbCloseUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.LocalUserDbInitUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.AddLocalUserUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserUseCase
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases.*
import com.example.ngs_test_login.MainActivity.Presentation.ViewModelInterface
import io.socket.client.Socket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel(), ViewModelInterface
{
    private val userInterfaceImpl: UserInterfaceImpl = UserInterfaceImpl()

    override fun socketInit(vararg bSocket: Socket)
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

    fun onChangedName()
    {}

    fun changeEmail()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeEmailUseCase: ChangeEmailUseCase = ChangeEmailUseCase(userInterfaceImpl)
            changeEmailUseCase.execute()
        }
    }

    fun onChangedEmail()
    {}

    fun changePassword()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changePasswordUseCase: ChangePasswordUseCase = ChangePasswordUseCase(userInterfaceImpl)
            changePasswordUseCase.execute()
        }
    }

    fun onChangedPassword()
    {}

    fun changeLanguage()
    {}

    fun onChangedLanguage()
    {}

    fun changeHomepage()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeHomepageUseCase: ChangeHomepageUseCase = ChangeHomepageUseCase(userInterfaceImpl)
            changeHomepageUseCase.execute()
        }
    }

    fun onChangedHomepage()
    {}

    fun changeDateFormat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changedDateFormatUseCase: ChangeDateFormatUseCase = ChangeDateFormatUseCase(userInterfaceImpl)
            changedDateFormatUseCase.execute()
        }
    }

    fun onChangedDateFormat()
    {}

    fun changeTimeFormat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeTimeFormatUseCase: ChangeTimeFormatUseCase = ChangeTimeFormatUseCase(userInterfaceImpl)
            changeTimeFormatUseCase.execute()
        }
    }

    fun onChangedTimeFormat()
    {}

    fun changeStartOfWeek()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeStartOfWeekUseCase: ChangeStartOfWeekUseCase = ChangeStartOfWeekUseCase(userInterfaceImpl)
            changeStartOfWeekUseCase.execute()
        }
    }

    fun onChangedStartOfWeek()
    {}

    fun changeExpandSubtask()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeExpandSubtaskUseCaseUseCase: ChangeExpandSubtaskUseCase = ChangeExpandSubtaskUseCase(userInterfaceImpl)
            changeExpandSubtaskUseCaseUseCase.execute()
        }
    }

    fun onChangedExpandSubtask()
    {}

    fun changeNewTask()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeNewTaskUseCase: ChangeNewTaskUseCase = ChangeNewTaskUseCase(userInterfaceImpl)
            changeNewTaskUseCase.execute()
        }
    }

    fun onChangedNewTask()
    {}

    fun changedShortcuts()
    {}

    fun onChangedShortcuts()
    {}
}