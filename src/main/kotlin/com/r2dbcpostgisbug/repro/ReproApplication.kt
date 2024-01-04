package com.r2dbcpostgisbug.repro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReproApplication

fun main(args: Array<String>) {
	runApplication<ReproApplication>(*args)
}
