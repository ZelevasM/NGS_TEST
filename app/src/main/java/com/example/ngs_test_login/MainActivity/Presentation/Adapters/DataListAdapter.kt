package com.example.ngs_test_login.MainActivity.Presentation.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.R

class DataListAdapter(private val lists: ArrayList<DataList?>?): RecyclerView.Adapter<DataListAdapter.ListViewHolder>()
{
    private lateinit var clickListener: onItemClickListener
    interface onItemClickListener
    {
        fun onItemClicked(position: Int,id: String?)
        {

        }
    }

    fun setOnItemClickListener(listener: onItemClickListener)
    {
        clickListener = listener
    }

    class ListViewHolder(itemView: View,listener: onItemClickListener,lists: ArrayList<DataList?>?): RecyclerView.ViewHolder(itemView)
    {
        init
        {
            itemView.setOnClickListener {
                listener.onItemClicked(adapterPosition, lists?.get(adapterPosition)?.id)
            }
        }
        val iconTextView: TextView = itemView.findViewById(R.id.list_item_cardView_mainIcon_textView)
        val titleTextView: TextView = itemView.findViewById(R.id.list_item_cardView_title_textView)
        val tasksTextView: TextView = itemView.findViewById(R.id.list_item_cardView_tasks_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ListViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.main_lists_item, parent, false)
        return ListViewHolder(itemView, clickListener, lists)
    }

    override fun onBindViewHolder(holder: ListViewHolder,position: Int)
    {
        val currentList = lists?.get(position)
        //holder.iconTextView.setText(currentList.)
        holder.titleTextView.text = currentList?.name
        holder.tasksTextView.text = currentList?.tasks?.size.toString()
    }

    override fun getItemCount(): Int
    {
        return lists!!.size
    }
}