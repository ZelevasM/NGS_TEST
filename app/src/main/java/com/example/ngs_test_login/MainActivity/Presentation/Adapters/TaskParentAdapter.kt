package com.example.ngs_test_login.MainActivity.Presentation.Adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.Models.TaskChildItem
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.Models.TaskParentItem
import com.example.ngs_test_login.R

class TaskParentAdapter(private var parentTasks: ArrayList<TaskParentItem?>?):
    RecyclerView.Adapter<TaskParentAdapter.TaskParentViewHolder>()
{
    private var childTasks: ArrayList<TaskChildItem?>? = ArrayList()

    class TaskParentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val expandableLayout: RelativeLayout = itemView.findViewById(R.id.parent_task_item_container)
        val groupRecView: RecyclerView = itemView.findViewById(R.id.parent_task_item_nested_recView)
        @SuppressLint("NotifyDataSetChanged")
        fun bind(parentTask: TaskParentItem?)
        {
            itemView.findViewById<TextView>(R.id.parent_task_item_textView).text = parentTask?.name
            if(parentTask?.isExpanded == true) {
                itemView.findViewById<RelativeLayout>(R.id.parent_task_item_expandableLayout).visibility = View.VISIBLE
                itemView.findViewById<ImageView>(R.id.parent_task_item_arrow).setImageResource(R.drawable.ic_arrow_down)
            }
            else {
                itemView.findViewById<RelativeLayout>(R.id.parent_task_item_expandableLayout).visibility = View.GONE
                itemView.findViewById<ImageView>(R.id.parent_task_item_arrow).setImageResource(R.drawable.ic_arrow_right)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): TaskParentAdapter.TaskParentViewHolder
    {
        val itemView: View = LayoutInflater.from(parent.context).
        inflate(R.layout.task_parent_item, parent, false)
        return TaskParentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskParentAdapter.TaskParentViewHolder,position: Int)
    {
        val currentParentTask: TaskParentItem? = parentTasks?.get(position)
        if(currentParentTask != null)
        {
            holder.bind(currentParentTask)
            val childTaskAdapter: TaskChildAdapter = TaskChildAdapter(currentParentTask.childTasks)
            holder.groupRecView.layoutManager = LinearLayoutManager(holder.itemView.context)
            holder.groupRecView.adapter = childTaskAdapter
            //holder.groupRecView.setOnDragListener(groupRecViewDragListener)

            holder.expandableLayout.setOnClickListener {
                Log.d("klog", "Pressed")
                currentParentTask.isExpanded = !currentParentTask.isExpanded!!
                childTasks = currentParentTask.childTasks
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int
    {
        var output: Int = 0
        if(parentTasks != null)
            output = parentTasks!!.size
        return output
    }


}