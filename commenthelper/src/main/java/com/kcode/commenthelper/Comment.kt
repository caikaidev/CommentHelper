package com.kcode.commenthelper

/**
 *
 * @param id 评论id
 * @param comment 评论内容
 * @param userId 评论者ID
 * @param userName 评论者姓名
 * @param replyTo 回复谁
 * @param time  评论时间
 * @param level 评论层级
 * @param isAuthor 是否是作者
 */
data class Comment(
    val id: Long,
    val comment: String,
    val userId:Long,
    val userName:String,
    val replyTo: String,
    val time: Long,
    val level: Int,
    val isAuthor: Boolean = false
)