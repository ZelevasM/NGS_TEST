package com.example.ngs_test_login.LoginActivity.Data.Web

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.ngs_test_login.BuildConfig
import com.example.ngs_test_login.LoginActivity.Domain.Models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.InputStreamReader

import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.util.Base64

class AsyncGet
{
    //TODO EXP
    fun searchEmail(email: User): Boolean = runBlocking{
        var result: Boolean = false

        val job = GlobalScope.launch(Dispatchers.IO) {
            val em: String = email.e
            var reqParam: String = "email=$em"

            Log.d("MyLog","\n\n$reqParam")

            val mURL = URL(BuildConfig.SEARCH_USER_KEY)

            with(mURL.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "POST"

                val wr = OutputStreamWriter(getOutputStream());
                wr.write(reqParam);
                wr.flush();


                Log.d("MyLog","Conn1")
                Log.d("MyLog","URL : $url")
                Log.d("MyLog","Response Code : $responseCode")
                Log.d("MyLog","Conn2")

                if(responseCode in 200..299)
                {
                    result = true
                    BufferedReader(InputStreamReader(inputStream)).use {
                        var inputLine = it.readLine()
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun signIn(password: User): Boolean = runBlocking{
        var result: Boolean = false
        val job = GlobalScope.launch(Dispatchers.IO) {

            val email: String = password.e
            val pass: String = password.p

            val encodedPass = Base64.getEncoder().encodeToString(pass.toByteArray())
            val decodedPass = String(Base64.getDecoder().decode(encodedPass))

            Log.d("MyLog","\nPass: $pass")
            Log.d("MyLog","\nEncode: $encodedPass")
            Log.d("MyLog","\nDecode: $decodedPass\n")

            var reqParam: String = "email=$email&password=$encodedPass"

            Log.d("MyLog","\n\n$reqParam")

            val mURL = URL(BuildConfig.SIGN_IN_KEY)

            with(mURL.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "POST"

                val wr = OutputStreamWriter(getOutputStream());
                wr.write(reqParam);
                wr.flush();


                Log.d("MyLog","Conn1")
                Log.d("MyLog","URL : $url")
                Log.d("MyLog","Response Code : $responseCode")
                Log.d("MyLog","Conn2")

                if(responseCode in 200..299)
                {
                    result = true
                    BufferedReader(InputStreamReader(inputStream)).use {
                        var inputLine = it.readLine()
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


    @RequiresApi(Build.VERSION_CODES.O)
    fun signUp(user: User): Boolean = runBlocking {
        var result: Boolean = false
        val job = GlobalScope.launch(Dispatchers.IO) {

            val email: String = user.e
            val pass: String = user.p
            val name: String = user.n

            val encodedPass = Base64.getEncoder().encodeToString(pass.toByteArray())
            val decodedPass = String(Base64.getDecoder().decode(encodedPass))

            Log.d("MyLog","\nPass: $pass")
            Log.d("MyLog","\nEncode: $encodedPass")
            Log.d("MyLog","\nDecode: $decodedPass\n")

            var reqParam: String = "name=$name&email=$email&password=$encodedPass"

            Log.d("MyLog","\n\n$reqParam")

            val mURL = URL(BuildConfig.SIGN_UP_KEY)

            with(mURL.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "POST"

                val wr = OutputStreamWriter(getOutputStream());
                wr.write(reqParam);
                wr.flush();


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