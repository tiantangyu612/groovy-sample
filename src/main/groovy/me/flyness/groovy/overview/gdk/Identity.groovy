package me.flyness.groovy.overview.gdk

/**
 * Created by lizhitao on 2018/4/27.
 */
lst = [1, 2]
lst.with {
    add(3)
    add(4)
    println size()
    println contains(2)
}

lst.with {
    println "this is $this"
    println "owner is $owner"
    println "delegate is $delegate"
}