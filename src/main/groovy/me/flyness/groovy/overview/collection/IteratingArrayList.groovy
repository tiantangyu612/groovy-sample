package me.flyness.groovy.overview.collection

/**
 * Created by lizhitao on 2018/4/27.
 */
lst = [1, 2, 3, 4, 5, 6, 7, 8, 9]
lst.each { print "$it " }

println ""
lst.reverseEach { print "$it " }

println ""
lst.eachWithIndex { int entry, int i -> print "lst[$entry]=$i " }

println ""
total = 0
lst.each { total += it }
println "total is $total"

println ""
doubled = []
lst.each { doubled << it * 2 }
println doubled

println lst.collect { it * 2 }