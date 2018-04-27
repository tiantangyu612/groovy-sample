package me.flyness.groovy.overview.collection

/**
 * Created by lizhitao on 2018/4/27.
 */
lst = [4, 1, 4, 3, 2, 6, 7, 8, 9, 2]
println lst.find { it == 6 }
println lst.find { it > 4 }
println lst.findAll { it == 2 }
println lst.findIndexOf { it == 2 }
println lst.findAll { it > 4 }