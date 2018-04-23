package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 动态确定闭包期望的参数的数目和类型
 */
def completeOrder(amount, taxComputer) {
    tax = 0
    if (taxComputer.maximumNumberOfParameters == 2) {// 期望传入税率
        tax = taxComputer(amount, 6.05)
    } else {// 使用默认税率
        tax = taxComputer(amount)
    }

    println "Sales tax is ${tax}"
}

completeOrder(100) { it * 0.0825 }
completeOrder(100) { amount, rate -> amount * (rate / 100) }