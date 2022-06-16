package com.gabo.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    start()
}

fun takeX(): Int? {
    println("შეიყვანეთ X ცვლადის მნიშვნელობა")
    val x = readLine()?.toIntOrNull()
    if (x == null) {
        errorX()
    }
    return x
}

fun takeY(x: Int?): Int? {
    println("შეიყვანეთ Y ცვლადის მნიშვნელობა")
    val y = readLine()?.toIntOrNull()
    if (y == null) {
        errorY(x)
    }
    return y
}

fun sum(x: Int?, y: Int?) {
    if (x is Int && y is Int) {
        val sum = x + y
        println("X და Y - ის ჯამი არის $sum")
        println("გსურთ პროგრამის ხელახლა დაწყება? \n <Y/N>?")
        when (readLine()) {
            "y" -> start()
            "Y" -> start()
            "n" -> println("დასასრული")
            "N" -> println("დასასრული")
            else -> error()
        }
    } else {
        error()
    }
}

fun start() {
    val x = takeX()
    val y = takeY(x)
    sum(x, y)
}

fun error() {
    println(
        "თქვენს ჩანაწერში დაფიქსირდა შეცდომა,გთხოვთ მიუთითოთ Yes ან No \n გსურთ პროგრამის ხელახლა დაწყება? \n" +
                " <Y/N>?"
    )
    when (readLine()) {
        "y" -> start()
        "Y" -> start()
        "n" -> println("დასასრული")
        "N" -> println("დასასრული")
        else -> error()
    }
}

fun errorX() {
    println(
        "თქვენს ჩანაწერში დაფიქსირდა შეცდომა, გთხოვთ შეიყვანოთ რიცხვები \n გსურთ პროგრამის ხელახლა დაწყება?\n <Y/N>?"
    )
    when (readLine()) {
        "y" -> start()
        "Y" -> start()
        "n" -> println("დასასრული")
        "N" -> println("დასასრული")
        else -> errorX()
    }
}

fun errorY(x: Int?) {
    println("თქვენს ჩანაწერში დაფიქსირდა შეცდომა, გთხოვთ შეიყვანოთ რიცხვები \n გსურთ სცადოთ ახლიდან? \n <Y/N>?")
    when (readLine()) {
        "y" -> {
            val y = takeY(x)
            sum(x, y)
        }
        "Y" -> {
            val y = takeY(x)
            sum(x, y)
        }
        "n" -> println("დასასრული")
        "N" -> println("დასასრული")
        else -> errorY(x)
    }
}
