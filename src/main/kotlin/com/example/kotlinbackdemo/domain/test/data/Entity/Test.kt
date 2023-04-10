package com.example.kotlinbackdemo.domain.test.data.Entity

import com.example.kotlinbackdemo.global.Base.BaseEntity
import com.example.kotlinbackdemo.global.Base.BaseTimeEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Test(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id : Long? = null,

    private var contents : String? = null,

    private var text : String? = null
) : BaseTimeEntity(), BaseEntity<Test>
