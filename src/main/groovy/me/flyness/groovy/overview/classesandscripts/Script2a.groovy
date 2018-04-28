package me.flyness.groovy.overview.classesandscripts

/**
 * Created by lizhitao on 2018/4/28.
 */
println "In Script2a"
name = "Venkat"
shell = new GroovyShell(binding)
result = shell.evaluate(new File("Script1a.groovy"))
println "Script1a returned: $result"
println "Hello $name"