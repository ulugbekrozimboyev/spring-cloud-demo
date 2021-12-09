package uz.ulugbek.springcloud.rest1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.util.*

@EnableEurekaClient
@SpringBootApplication
class Rest1Application {

    @Bean
    @LoadBalanced
    fun restTemplate() = RestTemplate();
}

fun main(args: Array<String>) {
    runApplication<Rest1Application>(*args)
}

@RestController
class MyRestController(val restTemplate: RestTemplate) {

    @GetMapping
    fun hello() : String {
        return "Hello from demo 1 ${restTemplate.getForObject("http://rest2", String::class.java)}"
    }

    @GetMapping("message")
    fun message(id: Long): MessageDto {
        val responseFromRest2 = restTemplate.postForObject("http://rest2/message/${id}", null, MessageRest2Dto::class.java)
        return MessageDto(responseFromRest2!!.id, responseFromRest2!!.message, Date().time)
    }
}