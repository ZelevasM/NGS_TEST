package com.example.ngs_test_login.LoginActivity.Data.Web

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.ngs_test_login.BuildConfig
import com.example.ngs_test_login.LoginActivity.Domain.Models.UserFromLogin
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.InputStreamReader

import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.util.Base64

/**
 * AsyncGet is used to contain main methods operating with REST API
 */
@DelicateCoroutinesApi
class AsyncGet
{
    /**
     * fun searchEmail receives email:User,
     * then runs on runBlocking thread its coroutine job,
     * inside of which it sends POST requestMethod to the server,
     * checks connection, and if it is ok, retrieves JSON from the server and makes var result = true,
     * which is returned by the fun at the end of its execution
     * @param email: User
     * @return boolean
     */
    fun searchEmail(email: UserFromLogin): Boolean = runBlocking{
        //// var result which changes its value to true, if the responseCode from the server was between 200 and 299
        var result: Boolean = false

        val job = GlobalScope.launch(Dispatchers.IO) {
            val em: String = email.e
            val reqParam: String = "email=$em"

            Log.d("MyLog","\n\n$reqParam")
            val mURL = URL(BuildConfig.SEARCH_USER_KEY)

            with(mURL.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "POST"

                val wr = OutputStreamWriter(outputStream)
                wr.write(reqParam)
                wr.flush()


                Log.d("MyLog","Conn1")
                Log.d("MyLog","URL : $url")
                Log.d("MyLog","Response Code : $responseCode")
                Log.d("MyLog","Conn2")

                if(responseCode in 200..299)
                {
                    result = true
                    BufferedReader(InputStreamReader(inputStream)).use {
                        val inputLine = it.readLine()
                        Log.d("MyLog","RES: $inputLine")
                    }
                    Log.d("MyLog","returned: $result")
                }
                if (responseCode in 300..400 || responseCode in 400..500)
                {
                    Log.d("MyLog","ERRORCODE")
                }
            }
        }
        job.join()
        return@runBlocking result
    }

    /**
     * fun signIn receives password:User,
     * then runs on runBlocking thread its coroutine job,
     * inside of which it sends POST requestMethod to the server,
     * checks connection, and if it is ok, retrieves JSON from the server and makes var result = true,
     * which is returned by the fun at the end of its execution
     * @param password: User
     * @return boolean
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun signIn(password: UserFromLogin): Boolean = runBlocking{
        //// var result which changes its value to true, if the responseCode from the server was between 200 and 299
        var result: Boolean = false
        val job = GlobalScope.launch(Dispatchers.IO) {

            val email: String = password.e
            val pass: String = password.p

            val encodedPass = Base64.getEncoder().encodeToString(pass.toByteArray())
            val decodedPass = String(Base64.getDecoder().decode(encodedPass))

            Log.d("MyLog","\nPass: $pass")
            Log.d("MyLog","\nEncode: $encodedPass")
            Log.d("MyLog","\nDecode: $decodedPass\n")

            val reqParam: String = "email=$email&password=$encodedPass"

            Log.d("MyLog","\n\n$reqParam")
            val mURL = URL(BuildConfig.SIGN_IN_KEY)

            with(mURL.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "POST"

                val wr = OutputStreamWriter(outputStream)
                wr.write(reqParam)
                wr.flush()


                Log.d("MyLog","Conn1")
                Log.d("MyLog","URL : $url")
                Log.d("MyLog","Response Code : $responseCode")
                Log.d("MyLog","Conn2")

                if(responseCode in 200..299)
                {
                    result = true
                    BufferedReader(InputStreamReader(inputStream)).use {
                        val inputLine = it.readLine()
                        Log.d("MyLog","RES: $inputLine")
                    }
                }
                if (responseCode in 300..400 || responseCode in 400..500)
                {
                    Log.d("MyLog","ERRORCODE")
                }
                Log.d("MyLog","returned: $result")
            }
        }
        job.join()
        return@runBlocking result
    }

    /**
     * fun signUp receives user:User,
     * then runs on runBlocking thread its coroutine job,
     * inside of which it sends POST requestMethod to the server,
     * checks connection, and if it is ok, retrieves JSON from the server and makes var result = true,
     * which is returned by the fun at the end of its execution
     * @param userFromLogin: User
     * @return boolean
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun signUp(userFromLogin: UserFromLogin): Boolean = runBlocking {
        //// var result which changes its value to true, if the responseCode from the server was between 200 and 299
        var result: Boolean = false
        val job = GlobalScope.launch(Dispatchers.IO) {

            val email: String = userFromLogin.e
            val pass: String = userFromLogin.p
            val name: String = userFromLogin.n

            val encodedPass = Base64.getEncoder().encodeToString(pass.toByteArray())
            val decodedPass = String(Base64.getDecoder().decode(encodedPass))

            Log.d("MyLog","\nPass: $pass")
            Log.d("MyLog","\nEncode: $encodedPass")
            Log.d("MyLog","\nDecode: $decodedPass\n")

            val reqParam: String = "name=$name&email=$email&password=$encodedPass"

            Log.d("MyLog","\n\n$reqParam")

            val mURL = URL(BuildConfig.SIGN_UP_KEY)

            with(mURL.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "POST"

                val wr = OutputStreamWriter(outputStream)
                wr.write(reqParam)
                wr.flush()


                Log.d("MyLog","Conn1")
                Log.d("MyLog","URL : $url")
                Log.d("MyLog","Response Code : $responseCode")
                Log.d("MyLog","Conn2")

                if(responseCode in 200..299)
                {
                    result = true
                    BufferedReader(InputStreamReader(inputStream)).use {
                        val inputLine = it.readLine()
                        Log.d("MyLog","RES: $inputLine")
                    }
                }
                if (responseCode in 300..600)
                {

                    Log.d("MyLog","ERRORCODE")
                }
                Log.d("MyLog","returned: $result")
            }
        }
        job.join()
        return@runBlocking result
    }
}