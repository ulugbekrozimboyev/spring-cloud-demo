package uz.ulugbek.springcloud.rest2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Rest2Application

fun main(args: Array<String>) {
    runApplication<Rest2Application>(*args)
}

@RestController
class MyRestController {

    @GetMapping
    fun hello() = "Hello from demo 2"
}