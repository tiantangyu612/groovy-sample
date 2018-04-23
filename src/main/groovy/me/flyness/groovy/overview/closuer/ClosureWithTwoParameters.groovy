package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 闭包传递多个参数
 */
def tellFortune(closure) {
    closure new Date("04/23/2018"), "Your day is filled with ceremony"
}

tellFortune() {
    date, fortune ->
        println "Fortune for ${date} is ${fortune}"
}