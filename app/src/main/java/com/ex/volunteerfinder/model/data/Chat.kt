package com.ex.volunteerfinder.model.data

/**
 * To be quite frank, I suspect this class might be redundant.
 * We can make the message selection activity utilize
 * the user and message classes to generate a better list.
 * It's just more reusable that way.
 */

data class Chat(
    val users: List<User>,
    var messages: MutableList<Message>
)