package com.example.ngs_test_login.LoginActivity.Data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentTransaction
import com.example.ngs_test_login.LoginActivity.Data.Web.AsyncGet
import com.example.ngs_test_login.LoginActivity.Domain.LoginInterface
import com.example.ngs_test_login.LoginActivity.Domain.Models.User


class LoginInterfaceImpl : LoginInterface
{
    override fun emailCheck(email: User): Boolean
    {
        var checkEmail = AsyncGet()
        return checkEmail.searchEmail(email)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun emailPassCheck(password: User): Boolean
    {
        var checkPass = AsyncGet()
        return checkPass.signIn(password)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun emailSignUp(user: User): Boolean
    {
        var createAcc = AsyncGet()
        return createAcc.signUp(user)
    }

    override fun privacy()
    {
        TODO("Not yet implemented")
    }

    override fun terms()
    {
        TODO("Not yet implemented")
    }

    override fun googleCont()
    {
        TODO("Not yet implemented")
    }

    override fun appleCont()
    {
        TODO("Not yet implemented")
    }

    override fun fbCont()
    {
        TODO("Not yet implemented")
    }
}