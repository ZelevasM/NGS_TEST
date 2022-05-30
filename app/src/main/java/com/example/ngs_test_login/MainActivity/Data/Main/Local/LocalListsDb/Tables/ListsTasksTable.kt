package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables

object ListsTasksTable
{
    //LISTS' TASKS' TABLE ->
    const val TABLE_NAME: String = "Lists_Tasks"
    const val COLUMN_NAME_KEY: String = "Key"
    const val COLUMN_NAME_ID: String = "Id"
    const val COLUMN_NAME_NOTES: String = "Notes"
    const val COLUMN_NAME_NAME: String = "Name"
    const val COLUMN_NAME_AUTHOR: String = "Author"
    const val COLUMN_NAME_PARENT: String = "Parent"
    const val COLUMN_NAME_DATE: String = "Date"
    const val COLUMN_NAME_SECTION: String = "Section"
    const val COLUMN_NAME_PRIORITY: String = "Priority"
    //INT
    const val COLUMN_NAME_ORDER: String = "Lists_Tasks_Order"
    //BOOLEAN
    const val COLUMN_NAME_DONE: String = "Done"
    //<- LISTS' TASKS' TABLE

    //LISTS' TASKS' TABLE OPERATIONS ->
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME" +
            "($COLUMN_NAME_KEY TEXT,$COLUMN_NAME_DONE TEXT," +
            "$COLUMN_NAME_NOTES TEXT,$COLUMN_NAME_ID TEXT," +
            "$COLUMN_NAME_NAME TEST, $COLUMN_NAME_ORDER INTEGER," +
            "$COLUMN_NAME_AUTHOR TEXT, $COLUMN_NAME_PARENT TEXT," +
            "$COLUMN_NAME_DATE TEXT, $COLUMN_NAME_SECTION TEXT," +
            "$COLUMN_NAME_PRIORITY TEXT)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    //<- LISTS' TASKS' TABLE OPERATIONS
}