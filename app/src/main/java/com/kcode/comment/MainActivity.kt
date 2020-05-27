package com.kcode.comment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kcode.commenthelper.Comment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = ArrayList<Comment>()
        for (i in 0 until 5){
            data.add(Comment(i.toLong(),"评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容$i",12L,"姓名","",System.currentTimeMillis(),
            0, i % 2== 0
            ))
        }
        commentLayout.setComments(data)
    }
}
