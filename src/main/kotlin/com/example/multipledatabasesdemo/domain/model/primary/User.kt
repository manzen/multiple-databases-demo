package com.example.multipledatabasesdemo.domain.model.primary

import javax.persistence.*

@Entity
class User (
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column
  var id: Int = 0,
  @Column
  var name: String = ""
)