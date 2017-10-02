package com.example.multipledatabasesdemo.domain.model.secondary

import javax.persistence.*

@Entity(name = "external_user_info")
class ExternalUserInfo (
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column
  var id: Int = 0,
  @Column
  var status: String = ""
)