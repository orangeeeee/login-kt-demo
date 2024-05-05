package com.kt.loginktdemo.delegate

import kotlin.properties.Delegates

class HistoryUser {
    var name: String by Delegates.observable("no name") {//Delegateのobservableを利用して、変更を監視する
            prop, old, new ->
        println("$old -> $new")
    }
}