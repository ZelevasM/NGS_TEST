package com.example.ngs_test_login.MainActivity.Presentation.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.Models.TaskChildItem
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.Models.TaskParentItem
import com.example.ngs_test_login.R

class TaskChildAdapter(private var childTasks: ArrayList<TaskChildItem?>?): RecyclerView.Adapter<TaskChildAdapter.TaskChildViewHolder>()
{
    class TaskChildViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        fun bind(child: TaskChildItem?, position: Int)
        {
            itemView.findViewById<TextView>(R.id.child_task_item_textView).text = child?.name
            itemView.findViewById<RelativeLayout>(R.id.child_task_item_container).tag = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): TaskChildViewHolder
    {
        val itemView: View = LayoutInflater.from(parent.context).
        inflate(R.layout.task_child_item, parent, false)
        return TaskChildViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskChildViewHolder,position: Int)
    {
        val currentChild: TaskChildItem? = childTasks?.get(position)
        if(currentChild != null)
            holder.bind(currentChild, position)
    }

    override fun getItemCount(): Int
    {
        var output: Int = 0
        if(childTasks != null)
            output = childTasks!!.size
        return output
    }
}