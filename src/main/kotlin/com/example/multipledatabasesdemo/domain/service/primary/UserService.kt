package com.example.multipledatabasesdemo.domain.service.primary

import com.example.multipledatabasesdemo.domain.model.primary.User
import com.example.multipledatabasesdemo.domain.repository.primary.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

  fun findById(id: Int): User {
    return userRepository.findOne(id)
  }
}