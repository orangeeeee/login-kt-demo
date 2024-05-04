package com.kt.loginktdemo.`object`

import com.kt.loginktdemo.domain.Person

object PersonManager {
    private val personList = mutableListOf<Person>()

    fun addPerson(person: Person) {
        personList.add(person)
    }

    fun removePerson(person: Person) {
        personList.remove(person)
    }

    fun getAllPersons(): List<Person> {
        return personList.toList()
    }
}