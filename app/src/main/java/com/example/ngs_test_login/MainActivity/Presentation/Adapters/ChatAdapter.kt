package com.example.ngs_test_login.MainActivity.Presentation.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
import com.example.ngs_test_login.R

class ChatAdapter(private val chats: ArrayList<Chat?>?): RecyclerView.Adapter<ChatAdapter.ChatViewHolder>()
{
    class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val iconTextView: TextView = itemView.findViewById(R.id.chat_item_cardView_mainIcon_textView)
        val titleTextView: TextView = itemView.findViewById(R.id.chat_item_cardView_title_textView)
        val senderTextView: TextView = itemView.findViewById(R.id.chat_item_cardView_sender_textView)
        val messageTextView: TextView = itemView.findViewById(R.id.chat_item_cardView_message_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ChatViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.main_chats_item, parent, false)
        return ChatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatViewHolder,position: Int)
    {
        val chats = chats?.get(position)
        holder.titleTextView.text = chats?.name
        holder.senderTextView.text = chats?.messages?.lastOrNull()?.id
        holder.messageTextView.text = chats?.messages?.lastOrNull()?.message
    }

    override fun getItemCount(): Int
    {
        return chats!!.size
    }
}