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
class MyRestController(val demo2Service: Demo2Service) {

    @GetMapping
    fun hello() : String {
        return "Hello from demo 1 ${demo2Service.hello()}"
    }

    @GetMapping("message")
    fun message(id: Long): MessageDto {
        val responseMessageRest2Dto = demo2Service.message(id)
        return MessageDto(responseMessageRest2Dto!!.id, responseMessageRest2Dto!!.message, Date().time)
    }
}