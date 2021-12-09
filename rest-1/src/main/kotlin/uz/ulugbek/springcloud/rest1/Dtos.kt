package uz.ulugbek.springcloud.rest1

data class MessageDto(val id: Long, val message: String, val createdDate: Long)
data class MessageRest2Dto(val id: Long, val message: String)