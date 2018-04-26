package me.flyness.groovy.overview.string

/**
 * Created by lizhitao on 2018/4/26.
 * 表达式
 */
value = 12
println "He paid \$${value} for that."

what = new StringBuffer('fence')
text = "The cow jumped over the $what"
println text

what.replace(0, 5, "moon")
println text

def printClassInfo(obj) {
    println "class: ${obj.getClass().name}"
    println "superclass: ${obj.getClass().superclass.name}"
}

val = 125
printClassInfo("The Stock closed at ${val}")
printClassInfo(/The Stock closed at ${val}/)
printClassInfo("This is a simple String")