package com.example.myapplication


class Student(name : String, surname : String, pn : String, profpic : String, mail : String) {
    var Name : String = name
    var Surname : String = surname
    var PersonalNumber : String = pn
    var profilePic : String = profpic
    var Email : String = mail

    init {
        println("Object $Name initialized")}
}