package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class ListUser(
    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("muted")
    val muted: Boolean? = null,

    @field:SerializedName("order")
    val order: String? = null,

    @field:SerializedName("note_size")
    val noteSize: String? = null,

    @field:SerializedName("unread_message")
    val unreadMessage: Int? = null,

    @field:SerializedName("read")
    val read: Boolean? = null,

    @field:SerializedName("last_seen")
    val lastSeen: String? = null,

    @field:SerializedName("user_id")
    val userId: String? = null,

    @field:SerializedName("read_last_message")
    val readLastMessage: String? = null,

    @field:SerializedName("unread_number")
    val unreadNumber: String? = null)
{

}