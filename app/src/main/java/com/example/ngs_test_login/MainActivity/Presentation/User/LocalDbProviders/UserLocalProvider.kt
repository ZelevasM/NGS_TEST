package com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders

import android.database.sqlite.SQLiteDatabase
import com.example.ngs_test_login.MainActivity.Data.User.UserInterfaceImpl
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb
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
    override fun saveName(vararg userWeb: UserWeb?,db: SQLiteDatabase?,name: String?)
    {
        val saveLocalUserNameUseCase: SaveLocalUserNameUseCase = SaveLocalUserNameUseCase(userInterfaceImpl)
        saveLocalUserNameUseCase.execute(name)
    }

    override fun getName(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserNameUseCase: GetLocalUserNameUseCase = GetLocalUserNameUseCase(userInterfaceImpl)
        return getLocalUserNameUseCase.execute()
    }

    override fun saveEmail(vararg userWeb: UserWeb?,db: SQLiteDatabase?,email: String?)
    {
        val saveLocalUserEmailUseCase: SaveLocalUserEmailUseCase = SaveLocalUserEmailUseCase(userInterfaceImpl)
        saveLocalUserEmailUseCase.execute(email)
    }

    override fun getEmail(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserEmailUseCase: GetLocalUserEmailUseCase = GetLocalUserEmailUseCase(userInterfaceImpl)
        return getLocalUserEmailUseCase.execute()
    }

    //USER GENERAL SETTINGS

    override fun saveLanguage(vararg userWeb: UserWeb?,db: SQLiteDatabase?,language: String?)
    {
        val saveLocalUserLanguageUseCase: SaveLocalUserLanguageUseCase =
            SaveLocalUserLanguageUseCase(userInterfaceImpl)
        saveLocalUserLanguageUseCase.execute(language)
    }

    override fun getLanguage(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserLanguageUseCase: GetLocalUserLanguageUseCase = GetLocalUserLanguageUseCase(userInterfaceImpl)
        return getLocalUserLanguageUseCase.execute()
    }

    override fun saveHomepage(vararg userWeb: UserWeb?,db: SQLiteDatabase?,homepage: String?)
    {
        val saveLocalUserHomepageUseCase: SaveLocalUserHomepageUseCase =
            SaveLocalUserHomepageUseCase(userInterfaceImpl)
        saveLocalUserHomepageUseCase.execute(homepage)
    }

    override fun getHomepage(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserHomepageUseCase: GetLocalUserHomepageUseCase =
            GetLocalUserHomepageUseCase(userInterfaceImpl)
        return getLocalUserHomepageUseCase.execute()
    }

    override fun saveDateFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?,dateFormat: String?)
    {
        val saveLocalUserDateFormatUseCase: SaveLocalUserDateFormatUseCase =
            SaveLocalUserDateFormatUseCase(userInterfaceImpl)
        saveLocalUserDateFormatUseCase.execute(dateFormat)
    }

    override fun getDateFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserDateFormatUseCase: GetLocalUserDateFormatUseCase =
            GetLocalUserDateFormatUseCase(userInterfaceImpl)
        return getLocalUserDateFormatUseCase.execute()
    }

    override fun saveTimeFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?,timeFormat: String?)
    {
        val saveLocalUserTimeFormatUseCase: SaveLocalUserTimeFormatUseCase =
            SaveLocalUserTimeFormatUseCase(userInterfaceImpl)
        saveLocalUserTimeFormatUseCase.execute(timeFormat)
    }

    override fun getTimeFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserTimeFormatUseCase: GetLocalUserTimeFormatUseCase =
            GetLocalUserTimeFormatUseCase(userInterfaceImpl)
        return getLocalUserTimeFormatUseCase.execute()
    }

    override fun saveStartOfWeek(vararg userWeb: UserWeb?,db: SQLiteDatabase?,startOfWeek: String?)
    {
        val saveLocalUserStartOfWeekUseCase: SaveLocalUserStartOfWeekUseCase =
            SaveLocalUserStartOfWeekUseCase(userInterfaceImpl)
        saveLocalUserStartOfWeekUseCase.execute(startOfWeek)
    }

    override fun getStartOfWeek(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserStartOfWeekUseCase: GetLocalUserStartOfWeekUseCase =
            GetLocalUserStartOfWeekUseCase(userInterfaceImpl)
        return getLocalUserStartOfWeekUseCase.execute()
    }

    override fun saveExpandSubtask(vararg userWeb: UserWeb?,db: SQLiteDatabase?,expandSubtask: String?)
    {
        val saveLocalUserExpandSubtaskUseCase: SaveLocalUserExpandSubtaskUseCase =
            SaveLocalUserExpandSubtaskUseCase(userInterfaceImpl)
        saveLocalUserExpandSubtaskUseCase.execute(expandSubtask)
    }

    override fun getExpandSubtask(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserExpandSubtaskUseCase: GetLocalUserExpandSubtaskUseCase =
            GetLocalUserExpandSubtaskUseCase(userInterfaceImpl)
        return getLocalUserExpandSubtaskUseCase.execute()
    }

    override fun saveNewTask(vararg userWeb: UserWeb?,db: SQLiteDatabase?,newTask: String?)
    {
        val saveLocalUserNewTaskUseCase: SaveLocalUserNewTaskUseCase =
            SaveLocalUserNewTaskUseCase(userInterfaceImpl)
        saveLocalUserNewTaskUseCase.execute(newTask)
    }

    override fun getNewTask(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserNewTaskUseCase: GetLocalUserNewTaskUseCase =
            GetLocalUserNewTaskUseCase(userInterfaceImpl)
        return getLocalUserNewTaskUseCase.execute()
    }

    //IRRELEVANT

    override fun saveShortcutInbox(vararg userWeb: UserWeb?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getShortcutInbox(vararg userWeb: UserWeb?)
    {
        TODO("Not yet implemented")
    }

    override fun saveId(vararg userWeb: UserWeb?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getId(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserIdUseCase: GetLocalUserIdUseCase = GetLocalUserIdUseCase(userInterfaceImpl)
        return getLocalUserIdUseCase.execute()
    }

    override fun saveShowSidebar(vararg userWeb: UserWeb?,db: SQLiteDatabase?,sidebar: String?)
    {
        val saveLocalUserSidebarUseCase: SaveLocalUserShowSidebarUseCase =
            SaveLocalUserShowSidebarUseCase(userInterfaceImpl)
        saveLocalUserSidebarUseCase.execute(sidebar)
    }

    override fun getShowSidebar(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserShowSidebarUseCase: GetLocalUserShowSidebarUseCase = GetLocalUserShowSidebarUseCase(userInterfaceImpl)
        return getLocalUserShowSidebarUseCase.execute()
    }

    override fun saveDiskSpace(vararg userWeb: UserWeb?,db: SQLiteDatabase?,diskSpace: String?)
    {
        val saveLocalUserDiskSpaceUseCase: SaveLocalUserDiskSpaceUseCase =
            SaveLocalUserDiskSpaceUseCase(userInterfaceImpl)
        saveLocalUserDiskSpaceUseCase.execute(diskSpace)
    }

    override fun getDiskSpace(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val getLocalUserDiskSpaceUseCase: GetLocalUserDiskSpaceUseCase = GetLocalUserDiskSpaceUseCase(userInterfaceImpl)
        return getLocalUserDiskSpaceUseCase.execute()
    }
}