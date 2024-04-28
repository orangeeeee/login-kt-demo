package com.kt.loginktdemo

//Collectionを継承しているけれども、継承目Methodを記載しなくてよい状態になっている
class DelegateCollection<T>(innerList: Collection<T> = ArrayList<T>())//
    : Collection<T> by innerList {


}