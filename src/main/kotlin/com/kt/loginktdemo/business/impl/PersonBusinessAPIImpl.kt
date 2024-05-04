package com.kt.loginktdemo.business.impl

import com.kt.loginktdemo.business.PersonBusinessAPI
import com.kt.loginktdemo.domain.Person
import com.kt.loginktdemo.`object`.PersonManager
import org.springframework.stereotype.Component

@Component
class PersonBusinessAPIImpl() : PersonBusinessAPI {
    override fun add() {
        PersonManager.addPerson(Person("John", "", "080123141231"))
    }
}