package com.example.multipledatabasesdemo.domain.service.secondary

import com.example.multipledatabasesdemo.domain.model.secondary.ExternalUserInfo
import com.example.multipledatabasesdemo.domain.repository.secondary.ExternalUserInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExternalUserInfoService @Autowired constructor(private val externalUserInfoRepository: ExternalUserInfoRepository) {

  fun findById(id: Int): ExternalUserInfo {
    return externalUserInfoRepository.findOne(id)
  }
}