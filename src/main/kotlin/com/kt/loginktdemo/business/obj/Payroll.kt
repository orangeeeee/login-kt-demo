package com.kt.loginktdemo.business.obj

import com.kt.loginktdemo.business.User

object Payroll {
    val allEmployees = arrayListOf<User>()

    fun calculateSalary() {
        for (employee in allEmployees) {
            println("Salary for ${employee.nickname}: ${employee.email}")
        }
    }
}