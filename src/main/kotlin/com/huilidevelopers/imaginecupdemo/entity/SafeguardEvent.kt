package com.huilidevelopers.imaginecupdemo.entity

import java.util.*

data class SafeguardEvent(
    var studentId:Long,
    var eventDescription:String,
    var eventTime: Date,
    var eventLevel:Int
)
