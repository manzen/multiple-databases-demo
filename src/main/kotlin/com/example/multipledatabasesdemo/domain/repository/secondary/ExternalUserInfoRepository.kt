package com.example.multipledatabasesdemo.domain.repository.secondary

import com.example.multipledatabasesdemo.domain.model.secondary.ExternalUserInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExternalUserInfoRepository: JpaRepository<ExternalUserInfo, Int>