package com.example.ngs_test_login.LoginActivity.Data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentTransaction
import com.example.ngs_test_login.LoginActivity.Data.Web.AsyncGet
import com.example.ngs_test_login.LoginActivity.Domain.LoginInterface
import com.example.ngs_test_login.LoginActivity.Domain.Models.User

/**
 * LoginInterfaceImpl implements LoginInterface,
 * and serves as a holder of implementations of the abstract methods in LoginInterface
 */
class LoginInterfaceImpl : LoginInterface
{
    /**
     * overridden fun emailCheck receives email:User,
     * then creates an instance of AsyncGet, where all 'dirty job' is done,
     * and returns returned from AsyncGet.searchEmail(email) boolean value
     * @param email: User
     * @return boolean
     */
    override fun emailCheck(email: User): Boolean
    {
        val checkEmail = AsyncGet()
        return checkEmail.searchEmail(email)
    }

    /**
     * overridden fun emailPassCheck receives password:User,
     * then creates an instance of AsyncGet, where all 'dirty job' is done,
     * and returns returned from AsyncGet.signIn(password) boolean value
     * @param password: User
     * @return boolean
     */
    @RequiresApi(Build.VERSION_CODES.O)
    override fun emailPassCheck(password: User): Boolean
    {
        val checkPass = AsyncGet()
        return checkPass.signIn(password)
    }

    /**
     * overridden fun emailSignUp receives user:User,
     * then creates an instance of AsyncGet, where all 'dirty job' is done,
     * and returns returned from AsyncGet.emailSignUp(user) boolean value
     * @param user: User
     * @return boolean
     */
    @RequiresApi(Build.VERSION_CODES.O)
    override fun emailSignUp(user: User): Boolean
    {
        val createAcc = AsyncGet()
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