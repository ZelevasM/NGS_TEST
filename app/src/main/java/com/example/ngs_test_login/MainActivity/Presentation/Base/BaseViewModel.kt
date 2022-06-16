package com.example.ngs_test_login.MainActivity.Presentation.Base

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.Base.BaseRepositoryImpl
import com.example.ngs_test_login.MainActivity.Domain.Base.UseCases.BaseSocketInitUseCase
import com.example.ngs_test_login.MainActivity.Domain.Base.UseCases.GetDataUseCase
import com.example.ngs_test_login.MainActivity.Domain.Base.Models.MainData
import com.example.ngs_test_login.MainActivity.Presentation.Base.SocketCallbacksImpl.BaseSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.MainActivity.Presentation.User.UserViewModel
import com.example.ngs_test_login.MainActivity.Presentation.ViewModelInterface
import io.socket.client.Socket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BaseViewModel(private val mainViewModel: MainViewModel,
                    private val userViewModel: UserViewModel): ViewModel(), ViewModelInterface
{
    private val responseData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val responseLiveData: LiveData<Boolean> = responseData

    private val baseInterfaceImpl: BaseRepositoryImpl = BaseRepositoryImpl()

    private fun baseSocketInit()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val baseSocketCallbackImpl: BaseSocketCallbackImpl = BaseSocketCallbackImpl(responseData)
            val baseSocketInitUseCase: BaseSocketInitUseCase = BaseSocketInitUseCase(baseInterfaceImpl)
            val bSocket: Socket = baseSocketInitUseCase.execute(baseSocketCallbackImpl)
            mainViewModel.socketInit(bSocket)
            userViewModel.socketInit(bSocket)
        }
    }

    override fun socketInit(vararg bSocket: Socket)
    {
        baseSocketInit()
    }

    override fun localDbInit(context: Context)
    {
        //1. init local dbs and display res
        mainViewModel.localDbInit(context)
        userViewModel.localDbInit(context)
    }

    override fun localDbClose()
    {
        mainViewModel.localDbClose()
        userViewModel.localDbClose()
    }

    fun init(context: Context)
    {
        viewModelScope.launch(Dispatchers.IO) {
            localDbInit(context)
            socketInit()
        }
    }

    fun getDataFromRest()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val getDataUseCase = GetDataUseCase(baseInterfaceImpl)
            val mainData: MainData? = getDataUseCase.execute()
            //change or delete
            mainViewModel.addLocalListsAtomic(mainData)
            mainViewModel.addLocalChatsAtomic(mainData)
            mainViewModel.dataAtomicAssigner()

            userViewModel.addLocalUserAtomic(mainData)
            userViewModel.dataAtomicAssigner()
        }
    }
}