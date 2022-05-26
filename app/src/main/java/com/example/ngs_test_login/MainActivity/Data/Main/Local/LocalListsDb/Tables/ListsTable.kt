package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables

object ListsTable
{
    //LIST BASIC TABLE ->
    const val LISTS_TABLE_NAME: String = "Lists"
    const val LISTS_COLUMN_NAME_NAME: String = "Name"
    const val LISTS_COLUMN_NAME_ID: String = "Id"
    const val LISTS_COLUMN_NAME_AUTHOR: String = "Author"
    const val LISTS_COLUMN_NAME_DATE: String = "Date"
    const val LISTS_COLUMN_NAME_ORDER: String = "Order"
    //<- LIST BASIC TABLE

    //LIST BASIC TABLE OPERATIONS ->
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $LISTS_TABLE_NAME" +
            "($LISTS_COLUMN_NAME_NAME TEXT,$LISTS_COLUMN_NAME_ID TEXT,$LISTS_COLUMN_NAME_AUTHOR TEXT," +
            "$LISTS_COLUMN_NAME_DATE TEXT,$LISTS_COLUMN_NAME_ORDER INTEGER)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $LISTS_TABLE_NAME"
    //<- LIST'S BASIC TABLE OPERATIONS

    //Add insert/update/delete for each parameter
}