package uz.ulugbek.springcloud.rest1

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*

interface Demo2Service {
    fun hello(): String
    fun message(id: Long): MessageRest2Dto
}

@Service
class Demo2ServiceImpl(private val restTemplate: RestTemplate): Demo2Service {
    override fun hello(): String {
        return restTemplate.getForObject("http://rest2", String::class.java)!!
    }

    override fun message(id: Long): MessageRest2Dto {
        return restTemplate.postForObject("http://rest2/message/${id}", null, MessageRest2Dto::class.java)!!
    }

}