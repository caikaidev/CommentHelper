package com.kcode.commenthelper.binder

import android.content.Context
import android.graphics.Color
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.kcode.commenthelper.Comment
import com.kcode.commenthelper.R
import com.kcode.commenthelper.span.CustomBackgroundSpan
import com.kcode.commenthelper.span.Spanny
import kotlin.math.ceil

class CommentViewBinder : ItemViewBinder<Comment, CommentViewBinder.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvContent = itemView.findViewById<TextView>(R.id.tv_content)!!
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Comment) {

        val spanny = Spanny()

        spanny.append(
            item.userName, ForegroundColorSpan(
                holder.itemView.context
                    .resources.getColor(R.color.comment_author_text)
            )
        )

        if (item.isAuthor) {
            spanny.append("作者", CustomBackgroundSpan(Color.LTGRAY, dp(holder.tvContent.context, 4)))
        }

        if (item.replyTo.isNotEmpty()) {
            spanny.append("回复")
                .append(
                    item.replyTo, ForegroundColorSpan(
                        holder.itemView.context
                            .resources.getColor(R.color.comment_author_text)
                    )
                )
        }

        spanny.append(
            "     :", ForegroundColorSpan(
                holder.itemView.context
                    .resources.getColor(R.color.comment_author_text)
            )
        )


        spanny.append(item.comment)

        holder.tvContent.text = spanny
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_comment, parent, false))
    }

    private fun dp(context: Context, value: Int): Int {
        return ceil(context.resources.displayMetrics.density * value.toDouble()).toInt()
    }
}