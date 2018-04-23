package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 闭包
 */
def pickEven(n, block) {
    for (i = 2; i <= n; i += 2) {
        block(i)
    }
}

pickEven(10, { println it })
pickEven(10) { println it }

total = 0
pickEven(10) { total += it }
println "Sum of even numbers from 1 to 10 is ${total}"
