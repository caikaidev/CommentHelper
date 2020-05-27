package com.kcode.commenthelper.binder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.kcode.commenthelper.Comment
import com.kcode.commenthelper.CommentCount
import com.kcode.commenthelper.R

class CommentCountViewBinder : ItemViewBinder<CommentCount, CommentCountViewBinder.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvContent = itemView.findViewById<TextView>(R.id.tv_content)!!
    }

    override fun onBindViewHolder(holder: ViewHolder, item: CommentCount) {
        holder.tvContent.text = "共${item.count}条评论"
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_comment_count, parent, false))
    }
}