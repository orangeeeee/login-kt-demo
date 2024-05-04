package com.kt.loginktdemo.business.impl

import com.kt.loginktdemo.business.PersonBusinessAPI
import com.kt.loginktdemo.business.SampleBusinessAPI
import com.kt.loginktdemo.business.SampleBusinessAPI.Expr
import com.kt.loginktdemo.business.enums.RbgColor
import com.kt.loginktdemo.business.enums.RbgColor.*
import com.kt.loginktdemo.business.obj.Payroll
import com.kt.loginktdemo.domain.Person
import com.kt.loginktdemo.`object`.PersonManager
import com.kt.loginktdemo.type.PurchaseNumber
import org.springframework.stereotype.Component
import strings.lastChar
import strings.orElseEmpty
import kotlin.reflect.KAnnotatedElement

@Component
class SampleBusinessAPIImpl(val personBusinessAPI: PersonBusinessAPI)//
    : SampleBusinessAPI {

    private fun <E> List<E>.forEach(action: Unit) {

    }

    override fun find(): String {

        PersonManager.addPerson(Person("ken", "x", "0901231"))
        PersonManager.addPerson(Person("joo", "z", ""))

        personBusinessAPI.add()

        // すべてのクラスの処理で追加されたPersonを取得できる。
        println(PersonManager.getAllPersons())

        mumeiFunc()

        val contracts = listOf(
            Person("Alice", "Smith", "123-4567"), Person("Bob", "Johnson", null)
        )
        contracts.forEach(myInlineFun { writeFile() })

        val contactListFilters = Person.ContractListFilters()
        with(contactListFilters) {
            prefix = "A"
            onlyWithPhoneNumber = true
        }
        println(contracts.filter(contactListFilters.getPredicate()))

        getThreeTimes(PersonN("Alice", 29, Company("abc", Address("Elsenheimerstrasse 47", 80687, "Muenchen"))))
        getThreeTimes(PersonN("Alice", 29, Company("abc", null)))
        getThreeTimes(PersonN("Alice", 29, null))

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

    fun reflectSp() {
        val person = Person("Alice", "Smith", "123-4567")
        val kClass = person.javaClass.kotlin
        kClass.simpleName
        //Person
        kClass.members.forEach { println(it.name) }

    }

    // Higher order function example: Calculator
    fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
        return operation(x, y)
    }

    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun subtract(x: Int, y: Int): Int {
        return x - y
    }

    fun multiply(x: Int, y: Int): Int {
        return x * y
    }

    fun writeFile(): Unit {
        val result1 = calculate(10, 5, ::add)
        println("Addition: $result1") // Output: Addition: 15
        val result2 = calculate(10, 5, ::subtract)
        println("Subtraction: $result2") // Output: Subtraction: 5
        val result3 = calculate(10, 5, ::multiply)
        println("Multiplication: $result3") // Output: Multiplication: 50
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
    class PersonN(val name: String, val age: Int, val company: Company?)


    fun getThreeTimes(person: PersonN) {

        myInlineFun { myInlineFun { println("in myInlineFun") } }
        // TODO これはNG なければ落ちるし、、
//        val zipCode0 = person.company!!.address!!.zipCode
        // TODO letで書き換え
        val zipCodeOpt1 = person.company?.let { company -> company.address }?.let { address -> address.zipCode }

        // TODO あれ？IDEに従うとこうなるな。。。
        val zipCodeOpt2 = person.company?.address?.zipCode

        println("xxx")
    }

    class SiteVisit(val path: String, val duration: Double, val os: String)


    private inline fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
        filter(predicate).map(SiteVisit::duration).average()

    @Override
    private inline fun myInlineFun(block: () -> Unit) {
        print("Hello, ")
        block()
    }

    private fun executeMyInlineFun() {
        val contracts = listOf(
            Person("Alice", "Smith", "123-4567"), Person("Bob", "Johnson", null)
        )
        contracts.forEach(myInlineFun { writeFile() })

    }


    fun interface MathOperation {
        fun operation(a: Int, b: Int): Int
    }

    fun sampleLGFunc(ints: List<Int>) {

        ints.filter(fun(item) = item > 0)

        ints.forEach(fun(value) {
            println("")
        })
    }
}


fun createPersonList(): List<Person> = listOf(
    Person("Alice", "Smith", "123-4567"), Person("Bob", "Johnson", null)
)

fun mumeiFunc() {
    supplerArgs(::createPersonList)
    supplerArgs { createPersonList() }

    val xxx: String = supplyWithTiming { SuppliedType() }.toString()

    /**  無名関数呼び出し（引数あり、戻り値あり）*/
    stringArgs(fun(xxx) = createPersonList())
    /**  無名関数呼び出し（引数なし、戻り値あり）*/
    supplerArgs(fun() = createPersonList())
    supplerReturnStringArgs(fun() = "returnString")
    supplerReturnStringArgs(fun() = "returnString" + "returnString2")
}

fun supplerReturnStringArgs(kFunction0: () -> String) {

    print("supplerArgs")
}

fun supplerArgs(kFunction0: () -> List<Person>) {

    print("supplerArgs")
}

fun stringArgs(sp: (String) -> List<Person>) {
    print(sp("stringArgs"))
}


class SuppliedType {

}
// TODO TypeAliasを使うとコールバックに型名を付ける事が出来るので、型安全かつ可読性が向上する
typealias MySpecialSupplier = () -> SuppliedType

fun supplyWithTiming(supplier: MySpecialSupplier): SuppliedType {
    val start = System.currentTimeMillis()
    val result = supplier()
    println("Time taken: ${System.currentTimeMillis() - start} ms")
    return result
}

// TODO ailiasでこれがエラーになるならいらんじゃん。。
/**
 * typealias は長いものを別名で書くだけ
 **/
fun findBy(purchaseNumber: PurchaseNumber) {
}
//
//// TODO ailiasでこれがエラーになるならいらんじゃん。。
//fun findBy(blukNumber: BlkNumber) {
//
//}

// TODO これはエラーになる
fun <T> copyData(source: MutableList<out T>, destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}

inline fun <reified T> KAnnotatedElement.findAnnotation(): T? {
    return annotations.filterIsInstance<T>().firstOrNull()
}