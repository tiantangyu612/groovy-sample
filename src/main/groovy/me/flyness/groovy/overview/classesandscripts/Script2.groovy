package me.flyness.groovy.overview.classesandscripts

/**
 * Created by lizhitao on 2018/4/28.
 */
println "In Script2"
shell = new GroovyShell()
shell.evaluate(new File('Script1.groovy'))
evaluate(new File('Script1.groovy'))