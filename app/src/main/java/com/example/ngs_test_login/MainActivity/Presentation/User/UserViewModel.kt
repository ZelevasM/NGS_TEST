package com.example.ngs_test_login.MainActivity.Presentation.User

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.User.UserRepositoryImpl
import com.example.ngs_test_login.MainActivity.Domain.Base.Models.MainData
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.LocalUserDbCloseUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.LocalUserDbInitUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.AddLocalUserUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.GetLocalUserUseCase
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases.*
import com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl.*
import com.example.ngs_test_login.MainActivity.Presentation.User.Validators.ShortcutValidator
import com.example.ngs_test_login.MainActivity.Presentation.ViewModelInterface
import io.socket.client.Socket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel(), ViewModelInterface
{
    private val userInterfaceImpl: UserRepositoryImpl = UserRepositoryImpl()

    //USER INFO SETTINGS
    private val userNameData = MutableLiveData<String?>()
    val userNameLiveData: LiveData<String?> = userNameData

    private val userEmailData = MutableLiveData<String?>()
    val userEmailLiveData: LiveData<String?> = userEmailData

    //GENERAL SETTINGS
    private val userLanguageData = MutableLiveData<String?>()
    val userLanguageLiveData: LiveData<String?> = userLanguageData

    private val userHomepageData = MutableLiveData<String?>()
    val userHomepageLiveData: LiveData<String?> = userHomepageData

    private val userSubtaskData = MutableLiveData<String?>()
    val userSubtaskLiveData: LiveData<String?> = userSubtaskData

    private val userNewTaskData = MutableLiveData<String?>()
    val userNewTaskLiveData: LiveData<String?> = userNewTaskData

    //DATE FORMAT SETTINGS
    private val userDateFormatData = MutableLiveData<String?>()
    val userDateFormatLiveData: LiveData<String?> = userDateFormatData

    private val userTimeFormatData = MutableLiveData<String?>()
    val userTimeFormatLiveData: LiveData<String?> = userTimeFormatData

    private val userWeekStartData = MutableLiveData<String?>()
    val userWeekStartLiveData: LiveData<String?> = userWeekStartData

    //SHORTCUTS' SETTINGS
    private val shortcutsData = MutableLiveData<ArrayList<Shortcut?>?>()
    val shortcutsLiveData: LiveData<ArrayList<Shortcut?>?> = shortcutsData


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
        val user: User? = getLocalUserAtomic()
        val shortcuts: ArrayList<Shortcut?>? = user?.shortcuts
        if (ShortcutValidator().validateIncomingShortcut(shortcuts))
        {
            shortcutsData.postValue(shortcuts)
            //load user settings
            userNameData.postValue(user?.name)
            userEmailData.postValue(user?.email)
            //load general settings
            userLanguageData.postValue(user?.language)
            userHomepageData.postValue(user?.homepage?.type)
            userDateFormatData.postValue(user?.dateFormat?.date)
            userTimeFormatData.postValue(user?.dateFormat?.time)
            userWeekStartData.postValue(user?.dateFormat?.startOfTheWeek)
            userSubtaskData.postValue(user?.expandSubtask)
            userNewTaskData.postValue(user?.newTask)
            //userLocalDbProvider.getDiskSpace(db=null)
            //write data to local storage
        }
    }

    fun addLocalUserAtomic(mainData: MainData?)
    {
        val user: com.example.ngs_test_login.MainActivity.Domain.User.Models.User? = mainData?.user
        val addLocalUserUseCase: AddLocalUserUseCase = AddLocalUserUseCase(userInterfaceImpl)
        addLocalUserUseCase.execute(user)
    }

    fun getLocalUserAtomic(): User?
    {
        val getLocalUserUseCase: GetLocalUserUseCase = GetLocalUserUseCase(userInterfaceImpl)
        val user: User? = getLocalUserUseCase.execute()
        return user
    }

    //Socket's Methods

    override fun socketInit(vararg bSocket: Socket)
    {
        val userSocketInitUseCase = UserSocketInitUseCase(userInterfaceImpl)
        userSocketInitUseCase.execute(bSocket[0])
        invokeSocketListeners()
    }


    //USER INFO SETTINGS

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
            val userName = UserNameSocketCallbackInterfaceImpl(userNameData, userInterfaceImpl)
            OnChangedNameUseCase(userInterfaceImpl).execute(userName)
        }
    }

    fun changeEmail(email: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { ChangeEmailUseCase(userInterfaceImpl).execute(email) }
    }

    fun onChangedEmail()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val userEmail = UserEmailSocketCallbackInterfaceImpl(userEmailData, userInterfaceImpl)
            OnChangedEmailUseCase(userInterfaceImpl).execute(userEmail) }
    }

    fun changePassword()
    {
        viewModelScope.launch(Dispatchers.IO) { ChangePasswordUseCase(userInterfaceImpl).execute() }
    }

    fun onChangedPassword()
    {}


    //GENERAL SETTINGS

    fun changeLanguage()
    {}

    fun onChangedLanguage()
    {
        viewModelScope.launch(Dispatchers.IO) { val userLang = UserLanguageSocketCallbackInterfaceImpl() }
    }

    fun changeHomepage(homepage: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { ChangeHomepageUseCase(userInterfaceImpl).execute(homepage) }
    }

    fun onChangedHomepage()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val userHomepageSocketCallback = UserHomepageSocketCallbackInterfaceImpl(homepageData = userHomepageData, userInterfaceImpl)
            OnChangedHomepageUseCase(userInterfaceImpl).execute(userHomepageSocketCallback) }
    }

    fun changeExpandSubtask(expandSubtask: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { ChangeExpandSubtaskUseCase(userInterfaceImpl).execute(expandSubtask) }
    }

    fun onChangedExpandSubtask()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val subtask = UserSubtaskSocketCallbackInterfaceImpl(userSubtaskData, userInterfaceImpl)
            OnChangedExpandSubtaskUseCase(userInterfaceImpl).execute(subtask) }
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
            val newTask = UserNewTaskSocketCallbackInterfaceImpl(userNewTaskData, userInterfaceImpl)
            OnChangedNewTaskUseCase(userInterfaceImpl).execute(newTask) }
    }

    //DATE FORMAT SETTINGS

    fun changeDateFormat(dateFormat: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { ChangeDateFormatUseCase(userInterfaceImpl).execute(dateFormat) }
    }

    fun onChangedDateFormat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val dateFormat = UserDateFormatSocketCallbackInterfaceImpl(userDateFormatData, userInterfaceImpl)
            OnChangedDateFormatUseCase(userInterfaceImpl).execute(dateFormat)
        }
    }

    fun changeTimeFormat(timeFormat: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { ChangeTimeFormatUseCase(userInterfaceImpl).execute(timeFormat) }
    }

    fun onChangedTimeFormat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val timeFormat = UserTimeFormatSocketCallbackInterfaceImpl(userTimeFormatData, userInterfaceImpl)
            OnChangedTimeFormatUseCase(userInterfaceImpl).execute(timeFormat)
        }
    }

    fun changeStartOfWeek(startOfWeek: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { ChangeStartOfWeekUseCase(userInterfaceImpl).execute(startOfWeek) }
    }

    fun onChangedStartOfWeek()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val startOfWeek = UserStartOfWeekSocketCallbackInterfaceImpl(userWeekStartData, userInterfaceImpl)
            val onStartOfWeek = OnChangedStartOfWeekUseCase(userInterfaceImpl)
            onStartOfWeek.execute(startOfWeek)
        }
    }

    //SHORTCUTS' SETTINGS

    fun changeShortcut(shortcuts: ArrayList<Shortcut?>?)
    {
        viewModelScope.launch(Dispatchers.IO) {ChangeShortcutUseCase(userInterfaceImpl).execute(shortcuts)}
    }

    fun onChangedShortcut()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val userShortcutCallbackInterfaceImpl = UserShortcutsSocketCallbackImpl(shortcutsData, userInterfaceImpl)
            OnChangedShortcutsUseCase(userInterfaceImpl).execute(userShortcutCallbackInterfaceImpl)
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
        onChangedShortcut()
    }
}