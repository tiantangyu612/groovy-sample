package me.flyness.groovy.overview.gdk

/**
 * Created by lizhitao on 2018/4/28.
 */
String[] command = ['groovy', '-e', '"print \'Groovy\'"']
println "Calling ${command.join(' ')}"
println command.execute().text