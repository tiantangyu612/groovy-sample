package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 协程
 */
def iterate(n, closure) {
    1.upto(n) {
        println "In iterate with value $it"
        closure(it)
    }
}

println "Calling iterate"
total = 0
iterate(4) {
    total += it
    println "In closure total so far is ${total}"
}

println "Done"