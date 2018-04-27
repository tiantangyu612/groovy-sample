package me.flyness.groovy.overview.collection

/**
 * Created by lizhitao on 2018/4/27.
 */
lst = [1, 3, 5, 6, 7, 8]
println lst
println lst.getClass().name
println lst[2]
println lst[lst.size() - 1]
println lst[-1]
println lst[-2]
println lst[2..5]
println lst[-1..-3]

subList = lst[3..5]
println subList.dump()
subList[0] = 55
println "After subList[0] = 55, lst = $lst"