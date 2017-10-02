package com.example.multipledatabasesdemo.domain.repository.primary

import com.example.multipledatabasesdemo.domain.model.primary.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Int>