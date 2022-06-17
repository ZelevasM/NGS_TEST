package com.example.ngs_test_login.MainActivity.Presentation.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.Models.TaskChildItem
import com.example.ngs_test_login.R

class SimpleTaskAdapter(): RecyclerView.Adapter<SimpleTaskAdapter.SimpleTaskViewHolder>()
{
    var tasks: ArrayList<Task?>? = ArrayList()
        @SuppressLint("NotifyDataSetChanged") set(value)
        {
            field = value
            notifyDataSetChanged()
        }
    private lateinit var clickListener: onItemClickListener
    interface onItemClickListener
    {
        fun onItemClicked(position: Int,id: String?, name: String?){}
    }

    fun setOnItemClickListener(listener: onItemClickListener)
    {
        clickListener = listener
    }

    class SimpleTaskViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView)
    {
        private val mListener = listener

        fun bind(task: Task?)
        {
            itemView.findViewById<TextView>(R.id.task_simple_item_textView).text = task?.name
            itemView.findViewById<RelativeLayout>(R.id.task_simple_item_container).setOnClickListener {
                mListener.onItemClicked(adapterPosition, id = task?.id, name = task?.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): SimpleTaskViewHolder
    {
        val itemView: View = LayoutInflater.from(parent.context).
        inflate(R.layout.task_simple_item, parent, false)
        return SimpleTaskAdapter.SimpleTaskViewHolder(itemView, clickListener)
    }

    override fun onBindViewHolder(holder: SimpleTaskViewHolder,position: Int)
    {
        val currentTask: Task? = tasks?.get(position)
        if(currentTask != null)
            holder.bind(currentTask)
    }

    override fun getItemCount(): Int
    {
        var output: Int = 0
        if(tasks != null)
            output = tasks!!.size
        return output
    }
}