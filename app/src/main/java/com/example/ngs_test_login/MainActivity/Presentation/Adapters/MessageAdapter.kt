package com.example.ngs_test_login.MainActivity.Presentation.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.R

class MessageAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    val userId = "62a1a832c7c8e80568614d36"

    var messages: ArrayList<TaskMessage?>? = ArrayList()
        @SuppressLint("NotifyDataSetChanged")
        set(value)
        {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var clickListener: onItemClickListenerMessage
    interface onItemClickListenerMessage
    {
        fun onItemClicked(position: Int,id: String?, userId: String?, message: String?){}
    }

    fun setOnItemClickListener(listener: onItemClickListenerMessage)
    {
        clickListener = listener
    }

    class LocalViewHolder(itemView: View, listener: onItemClickListenerMessage): RecyclerView.ViewHolder(itemView)
    {
        private val mListener = listener
        fun bind(taskMessage: TaskMessage?)
        {
            itemView.findViewById<TextView>(R.id.message_simple_item_text).text = taskMessage?.message
            mListener.onItemClicked(adapterPosition, id = taskMessage?.id, userId = taskMessage?.userId, message = taskMessage?.message)
        }
    }

    class AlienViewHolder(itemView: View, listener: onItemClickListenerMessage): RecyclerView.ViewHolder(itemView)
    {
        private val mListener = listener
        fun bind(taskMessage: TaskMessage?)
        {
            itemView.findViewById<TextView>(R.id.message_simple_item_second_text).text = taskMessage?.message
            itemView.findViewById<TextView>(R.id.message_simple_item_second_userName_text).text = taskMessage?.userId
            itemView.findViewById<RelativeLayout>(R.id.message_simple_item_container).setOnClickListener {
                mListener.onItemClicked(adapterPosition, id = taskMessage?.id, userId = taskMessage?.userId, message = taskMessage?.message)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        var item: Int = 0
        when(messages?.get(position)?.userId)
        {
            userId ->{item = R.layout.message_simple_item}
            null ->throw Exception("unknown")
            else -> {item = R.layout.message_simple_item_second}
        }
        return item
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RecyclerView.ViewHolder {
        return when(viewType)
        {
            R.layout.message_simple_item -> {LocalViewHolder(LayoutInflater.from(parent.context).
            inflate(R.layout.message_simple_item, parent, false), clickListener)}

            R.layout.message_simple_item_second -> {AlienViewHolder(LayoutInflater.from(parent.context).
            inflate(R.layout.message_simple_item_second, parent, false), clickListener)}

            else -> throw Exception("unknown type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder)
        {
            is LocalViewHolder -> holder.bind(messages?.get(position))
            is AlienViewHolder -> holder.bind(messages?.get(position))
        }
    }

    override fun getItemCount(): Int = messages?.size!!
}