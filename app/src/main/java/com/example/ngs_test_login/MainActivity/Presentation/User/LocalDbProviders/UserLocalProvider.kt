package com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders

import android.database.sqlite.SQLiteDatabase
import com.example.ngs_test_login.MainActivity.Data.User.UserInterfaceImpl
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.DateFormatLocalProviderInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.*
import com.example.ngs_test_login.MainActivity.Domain.User.UserLocalProviderInterface

class UserLocalProvider(private val userInterfaceImpl: UserInterfaceImpl):
    UserLocalProviderInterface,DateFormatLocalProviderInterface
{
    /*DELETE ?*/
    fun saveAll()
    {}

    fun getAll()
    {}
    /*        */

    /// NO NEED?

    //USER SETTINGS
    override fun saveName(vararg user: User?,db: SQLiteDatabase?,name: String?)
    {
        val saveLocalUserNameUseCase: SaveLocalUserNameUseCase = SaveLocalUserNameUseCase(userInterfaceImpl)
        saveLocalUserNameUseCase.execute(name)
    }

    override fun getName(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserNameUseCase: GetLocalUserNameUseCase = GetLocalUserNameUseCase(userInterfaceImpl)
        return getLocalUserNameUseCase.execute()
    }

    override fun saveEmail(vararg user: User?,db: SQLiteDatabase?,email: String?)
    {
        val saveLocalUserEmailUseCase: SaveLocalUserEmailUseCase = SaveLocalUserEmailUseCase(userInterfaceImpl)
        saveLocalUserEmailUseCase.execute(email)
    }

    override fun getEmail(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserEmailUseCase: GetLocalUserEmailUseCase = GetLocalUserEmailUseCase(userInterfaceImpl)
        return getLocalUserEmailUseCase.execute()
    }

    //USER GENERAL SETTINGS

    override fun saveLanguage(vararg user: User?,db: SQLiteDatabase?,language: String?)
    {
        val saveLocalUserLanguageUseCase: SaveLocalUserLanguageUseCase =
            SaveLocalUserLanguageUseCase(userInterfaceImpl)
        saveLocalUserLanguageUseCase.execute(language)
    }

    override fun getLanguage(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserLanguageUseCase: GetLocalUserLanguageUseCase = GetLocalUserLanguageUseCase(userInterfaceImpl)
        return getLocalUserLanguageUseCase.execute()
    }

    override fun saveHomepage(vararg user: User?,db: SQLiteDatabase?,homepage: String?)
    {
        val saveLocalUserHomepageUseCase: SaveLocalUserHomepageUseCase =
            SaveLocalUserHomepageUseCase(userInterfaceImpl)
        saveLocalUserHomepageUseCase.execute(homepage)
    }

    override fun getHomepage(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserHomepageUseCase: GetLocalUserHomepageUseCase =
            GetLocalUserHomepageUseCase(userInterfaceImpl)
        return getLocalUserHomepageUseCase.execute()
    }

    override fun saveDateFormat(vararg user: User?,db: SQLiteDatabase?,dateFormat: String?)
    {
        val saveLocalUserDateFormatUseCase: SaveLocalUserDateFormatUseCase =
            SaveLocalUserDateFormatUseCase(userInterfaceImpl)
        saveLocalUserDateFormatUseCase.execute(dateFormat)
    }

    override fun getDateFormat(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserDateFormatUseCase: GetLocalUserDateFormatUseCase =
            GetLocalUserDateFormatUseCase(userInterfaceImpl)
        return getLocalUserDateFormatUseCase.execute()
    }

    override fun saveTimeFormat(vararg user: User?,db: SQLiteDatabase?,timeFormat: String?)
    {
        val saveLocalUserTimeFormatUseCase: SaveLocalUserTimeFormatUseCase =
            SaveLocalUserTimeFormatUseCase(userInterfaceImpl)
        saveLocalUserTimeFormatUseCase.execute(timeFormat)
    }

    override fun getTimeFormat(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserTimeFormatUseCase: GetLocalUserTimeFormatUseCase =
            GetLocalUserTimeFormatUseCase(userInterfaceImpl)
        return getLocalUserTimeFormatUseCase.execute()
    }

    override fun saveStartOfWeek(vararg user: User?,db: SQLiteDatabase?,startOfWeek: String?)
    {
        val saveLocalUserStartOfWeekUseCase: SaveLocalUserStartOfWeekUseCase =
            SaveLocalUserStartOfWeekUseCase(userInterfaceImpl)
        saveLocalUserStartOfWeekUseCase.execute(startOfWeek)
    }

    override fun getStartOfWeek(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserStartOfWeekUseCase: GetLocalUserStartOfWeekUseCase =
            GetLocalUserStartOfWeekUseCase(userInterfaceImpl)
        return getLocalUserStartOfWeekUseCase.execute()
    }

    override fun saveExpandSubtask(vararg user: User?,db: SQLiteDatabase?,expandSubtask: String?)
    {
        val saveLocalUserExpandSubtaskUseCase: SaveLocalUserExpandSubtaskUseCase =
            SaveLocalUserExpandSubtaskUseCase(userInterfaceImpl)
        saveLocalUserExpandSubtaskUseCase.execute(expandSubtask)
    }

    override fun getExpandSubtask(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserExpandSubtaskUseCase: GetLocalUserExpandSubtaskUseCase =
            GetLocalUserExpandSubtaskUseCase(userInterfaceImpl)
        return getLocalUserExpandSubtaskUseCase.execute()
    }

    override fun saveNewTask(vararg user: User?,db: SQLiteDatabase?,newTask: String?)
    {
        val saveLocalUserNewTaskUseCase: SaveLocalUserNewTaskUseCase =
            SaveLocalUserNewTaskUseCase(userInterfaceImpl)
        saveLocalUserNewTaskUseCase.execute(newTask)
    }

    override fun getNewTask(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserNewTaskUseCase: GetLocalUserNewTaskUseCase =
            GetLocalUserNewTaskUseCase(userInterfaceImpl)
        return getLocalUserNewTaskUseCase.execute()
    }


    //IRRELEVANT

    override fun saveShortcutInbox(vararg user: User?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getShortcutInbox(vararg user: User?)
    {
        TODO("Not yet implemented")
    }

    override fun saveId(vararg user: User?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getId(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserIdUseCase: GetLocalUserIdUseCase = GetLocalUserIdUseCase(userInterfaceImpl)
        return getLocalUserIdUseCase.execute()
    }

    override fun saveShowSidebar(vararg user: User?,db: SQLiteDatabase?,sidebar: String?)
    {
        val saveLocalUserSidebarUseCase: SaveLocalUserShowSidebarUseCase =
            SaveLocalUserShowSidebarUseCase(userInterfaceImpl)
        saveLocalUserSidebarUseCase.execute(sidebar)
    }

    override fun getShowSidebar(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserShowSidebarUseCase: GetLocalUserShowSidebarUseCase = GetLocalUserShowSidebarUseCase(userInterfaceImpl)
        return getLocalUserShowSidebarUseCase.execute()
    }

    override fun saveDiskSpace(vararg user: User?,db: SQLiteDatabase?,diskSpace: String?)
    {
        val saveLocalUserDiskSpaceUseCase: SaveLocalUserDiskSpaceUseCase =
            SaveLocalUserDiskSpaceUseCase(userInterfaceImpl)
        saveLocalUserDiskSpaceUseCase.execute(diskSpace)
    }

    override fun getDiskSpace(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val getLocalUserDiskSpaceUseCase: GetLocalUserDiskSpaceUseCase = GetLocalUserDiskSpaceUseCase(userInterfaceImpl)
        return getLocalUserDiskSpaceUseCase.execute()
    }
}