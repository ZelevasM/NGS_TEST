package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import androidx.core.content.contentValuesOf
import com.example.ngs_test_login.MainActivity.Data.Main.Local.ConvertStringToBoolean
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersTable
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UserLocalProviderInterface

class UsersTableManager(): UserLocalProviderInterface
{
    fun write(user: User?, db: SQLiteDatabase?)
    {
        val values: ContentValues = ContentValues().apply {
            put(UsersTable.COLUMN_NAME_NAME, user?.name)
            put(UsersTable.COLUMN_NAME_ID, user?.id)
            put(UsersTable.COLUMN_NAME_EMAIL, user?.email)
            put(UsersTable.COLUMN_NAME_LANGUAGE, user?.language)
            put(UsersTable.COLUMN_NAME_SIDEBAR, user?.showSidebar)
            put(UsersTable.COLUMN_NAME_DISK_SPACE, user?.diskSpace)
            put(UsersTable.COLUMN_NAME_EXPAND_SUBTASK, user?.expandSubtask)
            put(UsersTable.COLUMN_NAME_NEW_TASK, user?.newTask)
            put(UsersTable.COLUMN_NAME_SHORTCUT_INBOX, user?.shortcutInbox)
        }
        db?.insert(UsersTable.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun read(db: SQLiteDatabase?): User?
    {
        val cursor: Cursor? = db?.query(UsersTable.TABLE_NAME, null, null, null,
            null, null, null)
        var name: String? = null
        var id: String? = null
        var email: String? = null
        var language: String? = null
        var sidebar: String? = null
        var diskSpace: String? = null
        var expandSubtask: String? = null
        var newTask: String? = null
        var shortInbox: String? = null
        while(cursor?.moveToNext() == true)
        {
            //TODO TOKEN VALIDATION
            name = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_NAME))
            id = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_ID))
            email = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_EMAIL))
            language = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_LANGUAGE))
            sidebar = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_SIDEBAR))
            diskSpace = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_DISK_SPACE))
            expandSubtask = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_EXPAND_SUBTASK))
            newTask = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_NEW_TASK))
            shortInbox = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_SHORTCUT_INBOX))
            Log.d("LocalDb", "${UsersTable.TABLE_NAME} NAME : $name")
            Log.d("LocalDb", "${UsersTable.TABLE_NAME} ID : $id")
            Log.d("LocalDb", "${UsersTable.TABLE_NAME} EMAIL : $email")
            Log.d("LocalDb", "${UsersTable.TABLE_NAME} LANGUAGE : $language")
            Log.d("LocalDb", "${UsersTable.TABLE_NAME} SIDEBAR : $sidebar")
            Log.d("LocalDb", "${UsersTable.TABLE_NAME} DISK SPACE : $diskSpace")
            Log.d("LocalDb", "${UsersTable.TABLE_NAME} EXPAND SUBTASK : $expandSubtask")
            Log.d("LocalDb", "${UsersTable.TABLE_NAME} NEW TASK : $newTask")
            Log.d("LocalDb", "${UsersTable.TABLE_NAME} SHORT INBOX : $shortInbox\n=")
        }
        cursor?.close()

        val user: User? = User(name = name, id = id, email = email, language = language,
            showSidebar = ConvertStringToBoolean(sidebar.toString()).convert(),
            diskSpace = diskSpace, expandSubtask = ConvertStringToBoolean(expandSubtask.toString()).convert(),
            newTask = ConvertStringToBoolean(newTask.toString()).convert(), shortcutInbox = shortInbox)
        return user
    }


    //USER SETTINGS
    override fun saveName(vararg user: User?,db: SQLiteDatabase?,name: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersTable.TABLE_NAME, contentValuesOf(UsersTable.COLUMN_NAME_NAME to name),
        "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getName(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id
        val cursor: Cursor? = db?.query(UsersTable.TABLE_NAME,
            arrayOf(UsersTable.COLUMN_NAME_NAME),"${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id),
        null, null, null)
        Log.d("LocalDb", "cursor: $id")
        cursor?.moveToFirst()
        val name: String? = cursor?.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_NAME))
        Log.d("LocalDb", "NAAAAAME : $name")
        cursor?.close()

        return name
    }

    override fun saveEmail(vararg user: User?,db: SQLiteDatabase?,email: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersTable.TABLE_NAME, contentValuesOf(UsersTable.COLUMN_NAME_EMAIL to email),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getEmail(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id

        val cursor: Cursor? = db?.query(UsersTable.TABLE_NAME,
            arrayOf(UsersTable.COLUMN_NAME_EMAIL),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        val email: String? = cursor?.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_EMAIL))
        Log.d("LocalDb", "EMMMAAAIL: $email")
        cursor?.close()

        return email
    }

    //USER GENERAL SETTINGS

    override fun saveLanguage(vararg user: User?,db: SQLiteDatabase?,language: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersTable.TABLE_NAME, contentValuesOf(UsersTable.COLUMN_NAME_LANGUAGE to language),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getLanguage(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id

        val cursor: Cursor? = db?.query(UsersTable.TABLE_NAME,
            arrayOf(UsersTable.COLUMN_NAME_LANGUAGE),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        val language: String? = cursor?.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_LANGUAGE))
        Log.d("LocalDb", "LANGUAAGE: $language")
        cursor?.close()

        return language
    }

    override fun saveHomepage(vararg user: User?,db: SQLiteDatabase?,homepage: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersTable.TABLE_NAME, contentValuesOf(UsersTable.COLUMN_NAME_HOMEPAGE_ID to homepage),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getHomepage(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id

        val cursor: Cursor? = db?.query(UsersTable.TABLE_NAME,
            arrayOf(UsersTable.COLUMN_NAME_HOMEPAGE_ID),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        val homepage: String? = cursor?.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_HOMEPAGE_ID))
        Log.d("LocalDb", "HOOMEPAGE: $homepage")
        cursor?.close()

        return homepage
    }

    override fun saveExpandSubtask(vararg user: User?,db: SQLiteDatabase?,expandSubtask: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersTable.TABLE_NAME, contentValuesOf(UsersTable.COLUMN_NAME_EXPAND_SUBTASK
                to expandSubtask),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getExpandSubtask(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id

        val cursor: Cursor? = db?.query(UsersTable.TABLE_NAME,
            arrayOf(UsersTable.COLUMN_NAME_EXPAND_SUBTASK),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        val expandSubtask: String? = cursor?.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_EXPAND_SUBTASK))
        Log.d("LocalDb", "EXPAAND SUBTASK: $expandSubtask")
        cursor?.close()

        return expandSubtask
    }

    override fun saveNewTask(vararg user: User?,db: SQLiteDatabase?,newTask: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersTable.TABLE_NAME, contentValuesOf(UsersTable.COLUMN_NAME_NEW_TASK to newTask),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getNewTask(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id

        val cursor: Cursor? = db?.query(UsersTable.TABLE_NAME,
            arrayOf(UsersTable.COLUMN_NAME_NEW_TASK),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        val newTask: String? = cursor?.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_NEW_TASK))
        Log.d("LocalDb", "NEEW TAASK: $newTask")
        cursor?.close()

        return newTask
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

    @SuppressLint("Range")
    override fun getId(vararg user: User?,db: SQLiteDatabase?): String?
    {
        var id: String? = user[0]?.id

        val cursor: Cursor? = db?.query(UsersTable.TABLE_NAME,
            arrayOf(UsersTable.COLUMN_NAME_ID),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        id = cursor?.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_ID))
        Log.d("LocalDb", "IIIID : $id")
        cursor?.close()

        return id
    }

    override fun saveShowSidebar(vararg user: User?,db: SQLiteDatabase?,sidebar: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersTable.TABLE_NAME, contentValuesOf(UsersTable.COLUMN_NAME_SIDEBAR to sidebar),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getShowSidebar(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id

        val cursor: Cursor? = db?.query(UsersTable.TABLE_NAME,
            arrayOf(UsersTable.COLUMN_NAME_SIDEBAR),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        val sidebar: String? = cursor?.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_SIDEBAR))
        Log.d("LocalDb", "SHOW SIDEEEBAR: $sidebar")
        cursor?.close()

        return sidebar
    }

    override fun saveDiskSpace(vararg user: User?,db: SQLiteDatabase?,diskSpace: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersTable.TABLE_NAME, contentValuesOf(UsersTable.COLUMN_NAME_DISK_SPACE to diskSpace),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getDiskSpace(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id

        val cursor: Cursor? = db?.query(UsersTable.TABLE_NAME,
            arrayOf(UsersTable.COLUMN_NAME_DISK_SPACE),
            "${UsersTable.COLUMN_NAME_ID} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        val diskSpace: String? = cursor?.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_DISK_SPACE))
        Log.d("LocalDb", "DIIISK SPAACE: $diskSpace")
        cursor?.close()

        return diskSpace
    }
}