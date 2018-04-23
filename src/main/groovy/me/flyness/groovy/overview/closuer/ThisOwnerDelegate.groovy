package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 闭包委托
 */
def examiningClosure(closure) {
    closure()
}

examiningClosure() {
    println "In First Closure:"
    println "class is " + getClass().name
    println "this is " + this + ", super: " + this.getClass().superclass.name
    println "owner is " + owner + ", super: " + owner.getClass().superclass.name
    println "delegate is " + delegate + ", super: " + delegate.getClass().superclass.name

    examiningClosure() {
        println "In Closure within the First Closure:"
        println "class is " + getClass().name
        println "this is " + this + ", super: " + this.getClass().superclass.name
        println "owner is " + owner + ", super: " + owner.getClass().superclass.name
        println "delegate is " + delegate + ", super: " + delegate.getClass().superclass.name
    }
}