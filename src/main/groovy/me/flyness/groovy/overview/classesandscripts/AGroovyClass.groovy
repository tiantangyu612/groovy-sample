package me.flyness.groovy.overview.classesandscripts

/**
 * Created by lizhitao on 2018/4/28.
 */
class AGroovyClass {
    def useClosure(closure) {
        println "Calling closure"
        closure()
    }

    def passToClosure(int value, closure) {
        println "Simply passing $value to the given closure"
        closure(value)
    }
}
