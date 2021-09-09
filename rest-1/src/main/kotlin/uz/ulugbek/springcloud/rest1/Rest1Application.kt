package uz.ulugbek.springcloud.rest1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class Rest1Application {

    @Bean
    fun restTemplate() = RestTemplate();
}

fun main(args: Array<String>) {
    runApplication<Rest1Application>(*args)
}

@RestController
class MyRestController(val restTemplate: RestTemplate) {

    @GetMapping
    fun hello() : String {
        return "Hello from demo 1 " + restTemplate.getForObject("http://localhost:8082", String::class.java)
    }

}