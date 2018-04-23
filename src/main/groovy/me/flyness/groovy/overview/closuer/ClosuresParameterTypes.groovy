package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 获取参数的类型
 */
def examine(closure) {
    println "$closure.maximumNumberOfParameters paramater(s) given:"
    for (aParameter in closure.parameterTypes) {
        println aParameter.name
    }

    println "--"
}

examine() {}
examine() { it }
examine() { -> }
examine() { val1 -> }
examine() { Date val1 -> }
examine() { Date val1, val2 -> }
examine() { Date val1, String val2 -> }