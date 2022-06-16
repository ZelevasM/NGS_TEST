package com.example.ngs_test_login.MainActivity.Presentation.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.ShortcutWeb
import com.example.ngs_test_login.R

class ShortcutAdapter(private val shortcutWebs: ArrayList<ShortcutWeb?>?): RecyclerView.Adapter<ShortcutAdapter.ShortcutViewHolder>()
{
    class ShortcutViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val iconTextView: TextView = itemView.findViewById(R.id.short_item_cardView_mainIcon_textView)
        val iconTextViewBackColor: RelativeLayout = itemView.findViewById(R.id.short_item_cardView_mainIcon_layout)
        val titleTextView: TextView = itemView.findViewById(R.id.short_item_cardView_title_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ShortcutViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.main_shortcuts_item, parent, false)
        return ShortcutAdapter.ShortcutViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShortcutViewHolder,position: Int)
    {
        val currentShortcut = shortcutWebs?.get(position)
        val color: Int = Color.parseColor(currentShortcut?.color)
        holder.iconTextViewBackColor.setBackgroundColor(color)
        holder.titleTextView.text = currentShortcut?.type
    }

    override fun getItemCount(): Int
    {
        return shortcutWebs!!.size
    }
}