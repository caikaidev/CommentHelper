package com.kcode.commenthelper.binder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.kcode.commenthelper.Comment
import com.kcode.commenthelper.CommentCount
import com.kcode.commenthelper.CommentInput
import com.kcode.commenthelper.R

class CommentInputViewBinder : ItemViewBinder<CommentInput, CommentInputViewBinder.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvContent = itemView.findViewById<TextView>(R.id.tv_content) !!
    }

    override fun onBindViewHolder(holder: ViewHolder, item: CommentInput) {
        holder.tvContent.text = item.input
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_comment_input, parent, false))
    }
}