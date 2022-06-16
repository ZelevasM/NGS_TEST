package com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders

import com.example.ngs_test_login.MainActivity.Data.User.UserRepositoryImpl
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.DateFormatRepository
import com.example.ngs_test_login.MainActivity.Domain.User.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases.*
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserLocalProviderRepository

class User(private val userInterfaceImpl: UserRepositoryImpl):
    UserLocalProviderRepository,DateFormatRepository
{
    /*DELETE ?*/
    fun saveAll()
    {}

    fun getAll()
    {}
    /*        */

    /// NO NEED?

    //USER SETTINGS
    override fun saveName(vararg userWeb: Any?,name: String?)
    {
        val saveLocalUserNameUseCase: SaveLocalUserNameUseCase = SaveLocalUserNameUseCase(userInterfaceImpl)
        saveLocalUserNameUseCase.execute(name)
    }

    override fun getName(vararg userWeb: Any?): String?
    {
        val getLocalUserNameUseCase: GetLocalUserNameUseCase = GetLocalUserNameUseCase(userInterfaceImpl)
        return getLocalUserNameUseCase.execute()
    }

    override fun saveEmail(vararg userWeb: Any?,email: String?)
    {
        val saveLocalUserEmailUseCase: SaveLocalUserEmailUseCase = SaveLocalUserEmailUseCase(userInterfaceImpl)
        saveLocalUserEmailUseCase.execute(email)
    }

    override fun getEmail(vararg userWeb: Any?): String?
    {
        val getLocalUserEmailUseCase: GetLocalUserEmailUseCase = GetLocalUserEmailUseCase(userInterfaceImpl)
        return getLocalUserEmailUseCase.execute()
    }

    //USER GENERAL SETTINGS

    override fun saveLanguage(vararg userWeb: Any?,language: String?)
    {
        val saveLocalUserLanguageUseCase: SaveLocalUserLanguageUseCase =
            SaveLocalUserLanguageUseCase(userInterfaceImpl)
        saveLocalUserLanguageUseCase.execute(language)
    }

    override fun getLanguage(vararg userWeb: Any?): String?
    {
        val getLocalUserLanguageUseCase: GetLocalUserLanguageUseCase = GetLocalUserLanguageUseCase(userInterfaceImpl)
        return getLocalUserLanguageUseCase.execute()
    }

    override fun saveHomepage(vararg userWeb: Any?,homepage: String?)
    {
        val saveLocalUserHomepageUseCase: SaveLocalUserHomepageUseCase =
            SaveLocalUserHomepageUseCase(userInterfaceImpl)
        saveLocalUserHomepageUseCase.execute(homepage)
    }

    override fun getHomepage(vararg userWeb: Any?): String?
    {
        val getLocalUserHomepageUseCase: GetLocalUserHomepageUseCase =
            GetLocalUserHomepageUseCase(userInterfaceImpl)
        return getLocalUserHomepageUseCase.execute()
    }

    override fun saveDateFormat(vararg user: User?,dateFormat: String?)
    {
        val saveLocalUserDateFormatUseCase: SaveLocalUserDateFormatUseCase =
            SaveLocalUserDateFormatUseCase(userInterfaceImpl)
        saveLocalUserDateFormatUseCase.execute(dateFormat)
    }

    override fun getDateFormat(vararg user: User?): String?
    {
        val getLocalUserDateFormatUseCase: GetLocalUserDateFormatUseCase =
            GetLocalUserDateFormatUseCase(userInterfaceImpl)
        return getLocalUserDateFormatUseCase.execute()
    }

    override fun saveTimeFormat(vararg user: User?,timeFormat: String?)
    {
        val saveLocalUserTimeFormatUseCase: SaveLocalUserTimeFormatUseCase =
            SaveLocalUserTimeFormatUseCase(userInterfaceImpl)
        saveLocalUserTimeFormatUseCase.execute(timeFormat)
    }

    override fun getTimeFormat(vararg user: User?): String?
    {
        val getLocalUserTimeFormatUseCase: GetLocalUserTimeFormatUseCase =
            GetLocalUserTimeFormatUseCase(userInterfaceImpl)
        return getLocalUserTimeFormatUseCase.execute()
    }

    override fun saveStartOfWeek(vararg user: User?,startOfWeek: String?)
    {
        val saveLocalUserStartOfWeekUseCase: SaveLocalUserStartOfWeekUseCase =
            SaveLocalUserStartOfWeekUseCase(userInterfaceImpl)
        saveLocalUserStartOfWeekUseCase.execute(startOfWeek)
    }

    override fun getStartOfWeek(vararg user: User?): String?
    {
        val getLocalUserStartOfWeekUseCase: GetLocalUserStartOfWeekUseCase =
            GetLocalUserStartOfWeekUseCase(userInterfaceImpl)
        return getLocalUserStartOfWeekUseCase.execute()
    }

    override fun saveExpandSubtask(vararg userWeb: Any?,expandSubtask: String?)
    {
        val saveLocalUserExpandSubtaskUseCase: SaveLocalUserExpandSubtaskUseCase =
            SaveLocalUserExpandSubtaskUseCase(userInterfaceImpl)
        saveLocalUserExpandSubtaskUseCase.execute(expandSubtask)
    }

    override fun getExpandSubtask(vararg userWeb: Any?): String?
    {
        val getLocalUserExpandSubtaskUseCase: GetLocalUserExpandSubtaskUseCase =
            GetLocalUserExpandSubtaskUseCase(userInterfaceImpl)
        return getLocalUserExpandSubtaskUseCase.execute()
    }

    override fun saveNewTask(vararg userWeb: Any?,newTask: String?)
    {
        val saveLocalUserNewTaskUseCase: SaveLocalUserNewTaskUseCase =
            SaveLocalUserNewTaskUseCase(userInterfaceImpl)
        saveLocalUserNewTaskUseCase.execute(newTask)
    }

    override fun getNewTask(vararg userWeb: Any?): String?
    {
        val getLocalUserNewTaskUseCase: GetLocalUserNewTaskUseCase =
            GetLocalUserNewTaskUseCase(userInterfaceImpl)
        return getLocalUserNewTaskUseCase.execute()
    }

    //IRRELEVANT

    override fun saveShortcutInbox(vararg userWeb: Any?)
    {
        TODO("Not yet implemented")
    }

    override fun getShortcutInbox(vararg userWeb: Any?)
    {
        TODO("Not yet implemented")
    }

    override fun saveId(vararg userWeb: Any?)
    {
        TODO("Not yet implemented")
    }

    override fun getId(vararg userWeb: Any?): String?
    {
        val getLocalUserIdUseCase: GetLocalUserIdUseCase = GetLocalUserIdUseCase(userInterfaceImpl)
        return getLocalUserIdUseCase.execute()
    }

    override fun saveShowSidebar(vararg userWeb: Any?,sidebar: String?)
    {
        val saveLocalUserSidebarUseCase: SaveLocalUserShowSidebarUseCase =
            SaveLocalUserShowSidebarUseCase(userInterfaceImpl)
        saveLocalUserSidebarUseCase.execute(sidebar)
    }

    override fun getShowSidebar(vararg userWeb: Any?): String?
    {
        val getLocalUserShowSidebarUseCase: GetLocalUserShowSidebarUseCase = GetLocalUserShowSidebarUseCase(userInterfaceImpl)
        return getLocalUserShowSidebarUseCase.execute()
    }

    override fun saveDiskSpace(vararg userWeb: Any?,diskSpace: String?)
    {
        val saveLocalUserDiskSpaceUseCase: SaveLocalUserDiskSpaceUseCase =
            SaveLocalUserDiskSpaceUseCase(userInterfaceImpl)
        saveLocalUserDiskSpaceUseCase.execute(diskSpace)
    }

    override fun getDiskSpace(vararg userWeb: Any?): String?
    {
        val getLocalUserDiskSpaceUseCase: GetLocalUserDiskSpaceUseCase = GetLocalUserDiskSpaceUseCase(userInterfaceImpl)
        return getLocalUserDiskSpaceUseCase.execute()
    }
}