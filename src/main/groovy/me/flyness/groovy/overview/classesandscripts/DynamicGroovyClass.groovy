package me.flyness.groovy.overview.classesandscripts

/**
 * Created by lizhitao on 2018/4/28.
 */
class DynamicGroovyClass {
    def methodMissing(String name, args) {
        println "You called $name with ${args.join(', ')}"
        args.size()
    }
}
