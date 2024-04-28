package com.kt.loginktdemo.business.impl

import com.kt.loginktdemo.business.SampleBusinessAPI
import com.kt.loginktdemo.business.SampleBusinessAPI.Expr
import com.kt.loginktdemo.business.enums.RbgColor
import com.kt.loginktdemo.business.enums.RbgColor.*
import com.kt.loginktdemo.business.obj.Payroll
import org.springframework.stereotype.Component
import strings.lastChar
import strings.orElseEmpty

@Component
class SampleBusinessAPIImpl : SampleBusinessAPI {
    override fun find(): String {
        getThreeTimes(Person("Alice", 29, Company("abc", Address("Elsenheimerstrasse 47", 80687, "Muenchen"))))
        getThreeTimes(Person("Alice", 29, Company("abc", null)))
        getThreeTimes(Person("Alice", 29, null))

        val superUser = SuperUser("abc.biz@gmail.com", 123, "abc")

        println(superUser.nickname)
        val message = NormalUser("Alice")
        message.address = "Elsenheimerstrasse 47, 80687 Muenchen"


        Payroll.allEmployees.add(superUser)
        Payroll.calculateSalary()


        val sum = { x: Int, y: Int -> x + y }
        sum(1, 2)


        val retStr = "abc"
        return retStr
    }

    fun foo(s: String?) {
        // TODO これってどうなの？
        val t: String = s ?: ""
        // TODO 拡張関数を作ってみた
        val tt = s.orElseEmpty()
        val ttt = s.orEmpty()
    }


    fun toInt(): (String) -> Int {

        val product = "apple"
        val result3 = "product".lastChar()
        return { it.toInt() }
    }

    fun deriveColor(color: RbgColor) = when (color) {
        RED -> "abc"
        BLUE -> "xta"
        YELLOW, GREEN -> "ere"
        BLACK -> "dark"
    }

    fun mix(c1: RbgColor, c2: RbgColor) = when (setOf(c1, c2)) {
        setOf(RED, BLUE) -> BLACK
        setOf(GREEN, BLUE) -> GREEN
        else -> throw Exception("Dirty color")
    }

    class Num(val value: Int) : Expr
    class Sum(val left: Expr, val right: Expr) : Expr


    fun evalIf(e: Expr): Int {

        if (e is Num) {
            return e.value
        }
        if (e is Sum) {
            return evalIf(e.left) + evalIf(e.right)
        }
        throw IllegalArgumentException("Unknown expression");
    }

    fun varOrgTest(vararg values: Int) {

        val sum = values.sum()

        for ((v, idx) in values.toList().withIndex()) {
            println("value: $v, index: $idx")
        }

    }

    infix fun Int.add(x: Int): Pair<Int, Int> {
        return Pair(1, 2);
    }

    class Address(val streetAddress: String, val zipCode: Int, val city: String)
    class Company(val name: String, val address: Address?)
    class Person(val name: String, val age: Int, val company: Company?)


    fun getThreeTimes(person: Person) {
        // TODO これはNG なければ落ちるし、、
//        val zipCode0 = person.company!!.address!!.zipCode
        // TODO letで書き換え
        val zipCodeOpt1 = person.company?.let { company -> company.address }?.let { address -> address.zipCode }

        // TODO あれ？IDEに従うとこうなるな。。。
        val zipCodeOpt2 = person.company?.address?.zipCode

        println("xxx")
    }
}