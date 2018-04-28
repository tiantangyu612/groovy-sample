package me.flyness.groovy.overview.gdk

/**
 * Created by lizhitao on 2018/4/28.
 */
file = '/etc/profile'
println new File(file).text

new File(file).eachLine { line ->
    println line
}

println new File(file).filterLine { it =~ /#/ }