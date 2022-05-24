package com.example.ngs_test_login.MainActivity.Presentation.Base

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.Base.BaseInterfaceImpl
import com.example.ngs_test_login.MainActivity.Domain.Base.UseCases.BaseSocketInitUseCase
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.MainActivity.Presentation.Base.SocketCallbacksImpl.BaseSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.ViewModelInterface
import io.socket.client.Socket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BaseViewModel: ViewModel(), ViewModelInterface
{
    private val responseData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val responseLiveData: LiveData<Boolean> = responseData

    private val baseInterfaceImpl: BaseInterfaceImpl = BaseInterfaceImpl()

    override fun socketInit()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val baseSocketCallbackImpl: BaseSocketCallbackImpl = BaseSocketCallbackImpl(responseData)
            val baseSocketInitUseCase: BaseSocketInitUseCase = BaseSocketInitUseCase(baseInterfaceImpl)
            val bSocket: Socket? = baseSocketInitUseCase.execute(baseSocketCallbackImpl)
        }
    }

    override fun localDbInit(context: Context)
    {
        TODO("Not yet implemented")
    }

    override fun localDbClose()
    {
        TODO("Not yet implemented")
    }

    fun localDbDisplay()
    {

    }
}