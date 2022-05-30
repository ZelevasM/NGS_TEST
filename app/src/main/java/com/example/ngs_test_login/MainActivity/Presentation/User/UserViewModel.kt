package com.example.ngs_test_login.MainActivity.Presentation.User

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.User.UserInterfaceImpl
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData
import com.example.ngs_test_login.MainActivity.Domain.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.LocalUserDbCloseUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.LocalUserDbInitUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.AddLocalUserUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserUseCase
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases.*
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.UserLocalProvider
import com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl.*
import com.example.ngs_test_login.MainActivity.Presentation.User.Validators.ShortcutValidator
import com.example.ngs_test_login.MainActivity.Presentation.ViewModelInterface
import io.socket.client.Socket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel(), ViewModelInterface
{
    private val shortcutsData = MutableLiveData<ArrayList<Shortcut?>?>()
    val shortcutsLiveData: LiveData<ArrayList<Shortcut?>?> = shortcutsData

    //USER SETTINGS
    private val userNameData = MutableLiveData<String?>()
    val userNameLiveData: LiveData<String?> = userNameData

    private val userEmailData = MutableLiveData<String?>()
    val userEmailLiveData: LiveData<String?> = userEmailData

    //USER GENERAL SETTINGS
    private val userLanguageData = MutableLiveData<String?>()
    val userLanguageLiveData: LiveData<String?> = userLanguageData

    private val userHomepageData = MutableLiveData<String?>()
    val userHomepageLiveData: LiveData<String?> = userHomepageData

    private val userDateFormatData = MutableLiveData<String?>()
    val userDateFormatLiveData: LiveData<String?> = userDateFormatData

    private val userTimeFormatData = MutableLiveData<String?>()
    val userTimeFormatLiveData: LiveData<String?> = userTimeFormatData

    private val userWeekStartData = MutableLiveData<String?>()
    val userWeekStartLiveData: LiveData<String?> = userWeekStartData

    private val userSubtaskData = MutableLiveData<String?>()
    val userSubtaskLiveData: LiveData<String?> = userSubtaskData

    private val userNewTaskData = MutableLiveData<String?>()
    val userNewTaskLiveData: LiveData<String?> = userNewTaskData

    private val userInterfaceImpl: UserInterfaceImpl = UserInterfaceImpl()
    private val userLocalDbProvider: UserLocalProvider = UserLocalProvider(userInterfaceImpl)

    override fun socketInit(vararg bSocket: Socket)
    {
        val userSocketInitUseCase = UserSocketInitUseCase(userInterfaceImpl)
        userSocketInitUseCase.execute(bSocket[0])
        invokeSocketListeners()
    }

    override fun localDbInit(context: Context)
    {
        val localUserDbInitUseCase: LocalUserDbInitUseCase = LocalUserDbInitUseCase(userInterfaceImpl)
        localUserDbInitUseCase.execute(context)

        dataAtomicAssigner()
    }

    override fun localDbClose()
    {
        val localUserDbCloseUseCase: LocalUserDbCloseUseCase = LocalUserDbCloseUseCase(userInterfaceImpl)
        localUserDbCloseUseCase.execute()
    }

    fun dataAtomicAssigner()
    {
        Log.d("MyLog","Local User in User: ${getLocalUserAtomic()}")
        val shortcuts: ArrayList<Shortcut?>? = getLocalUserAtomic()?.shortcuts as ArrayList<Shortcut?>?
        if (ShortcutValidator().validateIncomingShortcut(shortcuts))
        {
            shortcutsData.postValue(shortcuts)
            //load user settings
            userNameData.postValue(userLocalDbProvider.getName(db=null))
            userEmailData.postValue(userLocalDbProvider.getEmail(db=null))
            //load general settings
            userLanguageData.postValue(userLocalDbProvider.getLanguage(db=null))
            userHomepageData.postValue(userLocalDbProvider.getHomepage(db=null))
            userDateFormatData.postValue(userLocalDbProvider.getDateFormat(db=null))
            userTimeFormatData.postValue(userLocalDbProvider.getTimeFormat(db=null))
            userWeekStartData.postValue(userLocalDbProvider.getStartOfWeek(db = null))
            userSubtaskData.postValue(userLocalDbProvider.getExpandSubtask(db=null))
            userNewTaskData.postValue(userLocalDbProvider.getNewTask(db=null))
            //userLocalDbProvider.getDiskSpace(db=null)
            //write data to local storage
        }
    }

    fun addLocalUserAtomic(mainData: MainData?)
    {
        val user: User? = mainData?.user
        val addLocalUserUseCase: AddLocalUserUseCase = AddLocalUserUseCase(userInterfaceImpl)
        addLocalUserUseCase.execute(user)
    }

    fun getLocalUserAtomic(): User?
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

    //USER SETTINGS
    fun changeName(name: String?)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeNameUseCase: ChangeNameUseCase = ChangeNameUseCase(userInterfaceImpl)
            changeNameUseCase.execute(name)
        }
    }

    fun onChangedName()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val userName = UserNameSocketCallbackInterfaceImpl(userNameData, userLocalDbProvider)
            val onUserNameUC = OnChangedNameUseCase(userInterfaceImpl)
            onUserNameUC.execute(userName)
        }
    }

    fun changeEmail(email: String?)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeEmailUseCase: ChangeEmailUseCase = ChangeEmailUseCase(userInterfaceImpl)
            changeEmailUseCase.execute(email)
        }
    }

    fun onChangedEmail()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val userEmail = UserEmailSocketCallbackInterfaceImpl(userEmailData, userLocalDbProvider)
            val onEmailUC = OnChangedEmailUseCase(userInterfaceImpl)
            onEmailUC.execute(userEmail)
        }
    }

    fun changePassword()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changePasswordUseCase: ChangePasswordUseCase = ChangePasswordUseCase(userInterfaceImpl)
            changePasswordUseCase.execute()
        }
    }

    fun onChangedPassword()
    {}


    //USER GENERAL SETTINGS

    fun changeLanguage()
    {}

    fun onChangedLanguage()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val userLang = UserLanguageSocketCallbackInterfaceImpl()
        }
    }

    fun changeHomepage(homepage: String?)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeHomepageUseCase: ChangeHomepageUseCase = ChangeHomepageUseCase(userInterfaceImpl)
            changeHomepageUseCase.execute(homepage)
        }
    }

    fun onChangedHomepage()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val userHomepageSocketCallback = UserHomepageSocketCallbackInterfaceImpl(homepageData = userHomepageData,
            userLocalDbProvider)
            val onChangedHomepageUseCase: OnChangedHomepageUseCase =
                OnChangedHomepageUseCase(userInterfaceImpl)
            onChangedHomepageUseCase.execute(userHomepageSocketCallback)
        }
    }

    fun changeDateFormat(dateFormat: String?)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changedDateFormatUseCase: ChangeDateFormatUseCase = ChangeDateFormatUseCase(userInterfaceImpl)
            changedDateFormatUseCase.execute(dateFormat)
        }
    }

    fun onChangedDateFormat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val dateFormat = UserDateFormatSocketCallbackInterfaceImpl(userDateFormatData,
                userLocalDbProvider)
            val onChangedDateFormat = OnChangedDateFormatUseCase(userInterfaceImpl)
            onChangedDateFormat.execute(dateFormat)
        }
    }

    fun changeTimeFormat(timeFormat: String?)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeTimeFormatUseCase: ChangeTimeFormatUseCase = ChangeTimeFormatUseCase(userInterfaceImpl)
            changeTimeFormatUseCase.execute(timeFormat)
        }
    }

    fun onChangedTimeFormat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val timeFormat = UserTimeFormatSocketCallbackInterfaceImpl(userTimeFormatData,
            userLocalDbProvider)
            val onTimeFormat = OnChangedTimeFormatUseCase(userInterfaceImpl)
            onTimeFormat.execute(timeFormat)
        }
    }

    fun changeStartOfWeek(startOfWeek: String?)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeStartOfWeekUseCase: ChangeStartOfWeekUseCase = ChangeStartOfWeekUseCase(userInterfaceImpl)
            changeStartOfWeekUseCase.execute(startOfWeek)
        }
    }

    fun onChangedStartOfWeek()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val startOfWeek = UserStartOfWeekSocketCallbackInterfaceImpl(userWeekStartData,
            userLocalDbProvider)
            val onStartOfWeek = OnChangedStartOfWeekUseCase(userInterfaceImpl)
            onStartOfWeek.execute(startOfWeek)
        }
    }

    fun changeExpandSubtask(expandSubtask: String?)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeExpandSubtaskUseCaseUseCase: ChangeExpandSubtaskUseCase = ChangeExpandSubtaskUseCase(userInterfaceImpl)
            changeExpandSubtaskUseCaseUseCase.execute(expandSubtask)
        }
    }

    fun onChangedExpandSubtask()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val subtask = UserSubtaskSocketCallbackInterfaceImpl(userSubtaskData, userLocalDbProvider)
            val onSubtask = OnChangedExpandSubtaskUseCase(userInterfaceImpl)
            onSubtask.execute(subtask)
        }
    }

    fun changeNewTask(newTask: String?)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val changeNewTaskUseCase: ChangeNewTaskUseCase = ChangeNewTaskUseCase(userInterfaceImpl)
            changeNewTaskUseCase.execute(newTask)
        }
    }

    fun onChangedNewTask()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val newTask = UserNewTaskSocketCallbackInterfaceImpl(userNewTaskData, userLocalDbProvider)
            val onNewTask = OnChangedNewTaskUseCase(userInterfaceImpl)
            onNewTask.execute(newTask)
        }
    }


    //IRRELEVANT

    fun changedShortcuts()
    {}

    fun onChangedShortcuts()
    {}

    fun changeDiskSpace()
    {}

    fun onChangedDiskSpace()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val diskSpace = UserDiskSpaceSocketCallbackInterfaceImpl()
        }
    }

    fun invokeSocketListeners()
    {
        onChangedName()
        onChangedEmail()
        onChangedPassword()

        onChangedLanguage()
        onChangedHomepage()
        onChangedDateFormat()
        onChangedTimeFormat()
        onChangedStartOfWeek()
        onChangedExpandSubtask()
        onChangedNewTask()
    }
}