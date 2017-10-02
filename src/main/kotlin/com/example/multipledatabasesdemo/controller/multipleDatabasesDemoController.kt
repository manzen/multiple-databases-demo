package com.example.multipledatabasesdemo.controller

import com.example.multipledatabasesdemo.domain.model.primary.User
import com.example.multipledatabasesdemo.domain.model.secondary.ExternalUserInfo
import com.example.multipledatabasesdemo.domain.service.primary.UserService
import com.example.multipledatabasesdemo.domain.service.secondary.ExternalUserInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class multipleDatabasesDemoController {

  @Autowired
  lateinit var userService: UserService

  @Autowired
  lateinit var externalUserInfoService: ExternalUserInfoService

  @GetMapping("/user")
  fun getUser(@RequestParam(value = "id") id: Int): User = userService.findById(id)

  @GetMapping("/external-user-info")
  fun getExternalUserInfo(@RequestParam(value = "id") id: Int): ExternalUserInfo = externalUserInfoService.findById(id)
}