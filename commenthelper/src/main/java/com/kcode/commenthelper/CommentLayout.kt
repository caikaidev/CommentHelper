package com.kcode.commenthelper

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.MultiTypeAdapter
import com.kcode.commenthelper.binder.CommentCountViewBinder
import com.kcode.commenthelper.binder.CommentInputViewBinder
import com.kcode.commenthelper.binder.CommentViewBinder

class CommentLayout(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    RecyclerView(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?):this(context, attrs,0)
    private val items = ArrayList<Any>()

    var limit = 3//默认展示三条最新的数据
    private var commentCount = 0

    private val adapter = MultiTypeAdapter().apply {
        register(Comment::class.java, CommentViewBinder())
        register(CommentCount::class.java, CommentCountViewBinder())
        register(CommentInput::class.java, CommentInputViewBinder())
    }

    init {
        val padding = resources.getDimension(R.dimen.comment_padding).toInt()
        setPadding(padding, 0, padding, 0)
        layoutManager = LinearLayoutManager(context)
        adapter.items = items
        setAdapter(adapter)

    }

    fun setComments(comments: List<Comment>) {
        if (comments.isEmpty()) return
        items.clear()
        commentCount = comments.size
        for ((index, comment) in comments.withIndex()) {
            if (index >= limit) break
            items.add(comment)
        }

        if (comments.size > limit) {
            items.add(CommentCount(comments.size))
        }

        items.add(CommentInput("说点什么..."))
        adapter.notifyDataSetChanged()
    }

    fun addComments(comments: List<Comment>) {

        if (items.isEmpty()) {
            setComments(comments)
            return
        }
        var last = items.last()
        if (last is CommentInput) {
            items.removeAt(items.size - 1)
        }

        if (items.isEmpty()) {
            setComments(comments)
            return
        }

        last = items.last()
        if (last is CommentCount) {
            items.removeAt(items.size - 1)
        }

        if (items.isEmpty()) {
            setComments(comments)
            return
        }

        commentCount += comments.size
        items.addAll(0, comments)

        if (items.size >= limit) {
            var temp = ArrayList<Comment>()
            temp = temp.subList(0, 3) as ArrayList<Comment>;
            items.clear()
            items.addAll(temp)
        }

        if (commentCount >= limit) {
            items.add(CommentCount(commentCount))
        }

        items.add(CommentInput("说点什么..."))
        adapter.notifyDataSetChanged()

    }

    fun addComment(comment: Comment) {
        addComments(ArrayList<Comment>().apply {
            add(comment)
        })
    }

    fun removeComment(position: Int) {
        commentCount--

    }

    fun removeComment(comment: Comment) {
        var ind = -1
        for ((index, c) in items.withIndex()) {
            if (c is Comment && c.id == comment.id) {
                ind = index
                break
            }
        }

        if (ind != -1) {
            removeComment(ind)
        }
    }

    fun removeAll() {
        items.clear()
        adapter.notifyDataSetChanged()
    }

}