package com.minturl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MinturlApplication

fun main(args: Array<String>) {
	runApplication<MinturlApplication>(*args)
}
