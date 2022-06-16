package com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels

data class Folder(
    var id: String? = null,

    var name: String? = null,

    var order: String? = null,

    var lists: ArrayList<String?>? = ArrayList())
{}