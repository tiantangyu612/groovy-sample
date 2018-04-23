package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 动态闭包
 */
def doSomeThing(closure) {
    if (closure) {
        closure()
    } else {
        println 'Using default implementation'
    }
}

doSomeThing() { println 'Use specialized implementation' }
doSomeThing()