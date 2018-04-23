package me.flyness.groovy.overview

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
