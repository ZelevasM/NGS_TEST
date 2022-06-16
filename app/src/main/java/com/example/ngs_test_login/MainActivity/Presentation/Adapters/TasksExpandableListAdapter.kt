package com.example.ngs_test_login.MainActivity.Presentation.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.ngs_test_login.R

class TasksExpandableListAdapter(private val context: Context,
                                 private val groups: ArrayList<String>,
                                 private val children: HashMap<String, ArrayList<String>>): BaseExpandableListAdapter()
{
    override fun getGroupCount(): Int
    {
        return groups.size
    }

    override fun getChildrenCount(groupPosition: Int): Int
    {
        //TODO HashMap Question #1
        return children.get(groups.get(groupPosition))?.size!!
    }

    override fun getGroup(groupPosition: Int): Any
    {
        return groups.get(groupPosition)
    }

    override fun getChild(groupPosition: Int,childPosition: Int): Any?
    {
        //TODO HashMap Question #2
        return children.get(groups.get(groupPosition))?.get(childPosition)
    }

    //TODO What's the use of this method #1?
    override fun getGroupId(groupPosition: Int): Long
    {
        return 0
    }

    //TODO What's the use of this method #2?
    override fun getChildId(groupPosition: Int,childPosition: Int): Long
    {
        return 0
    }

    //TODO What's the use of this method #2?
    override fun hasStableIds(): Boolean
    {
        return false
    }

    override fun getGroupView(groupPosition: Int,
                              isExpanded: Boolean,
                              convertView: View?,
                              parent: ViewGroup?): View
    {
        var view = convertView
        view = LayoutInflater.from(parent?.context).inflate(R.layout.lists_task_item, parent, false)
        val groupTitleTextView: TextView = view.findViewById(R.id.lists_task_item_textView)
        val groupTitle: String = getGroup(groupPosition).toString()
        groupTitleTextView.text = groupTitle
        groupTitleTextView.textSize = 24f
        return view
    }

    override fun getChildView(groupPosition: Int,
                              childPosition: Int,
                              isLastChild: Boolean,
                              convertView: View?,
                              parent: ViewGroup?): View
    {
        var view = convertView
        view = LayoutInflater.from(parent?.context).inflate(R.layout.lists_subtask_item, parent, false)
        val childTitleTextView: TextView = view.findViewById(R.id.lists_subtask_item_textView)
        val childTitle: String = getChild(groupPosition, childPosition).toString()
        childTitleTextView.text = childTitle
        return view
    }

    override fun isChildSelectable(groupPosition: Int,childPosition: Int): Boolean
    {
        return false
    }
}