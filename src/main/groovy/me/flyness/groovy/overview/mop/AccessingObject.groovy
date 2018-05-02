package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
def printInfo(obj) {
    usrRequestedProperty = 'bytes'
    usrRequestedMethod = 'toUpperCase'

    println obj[usrRequestedProperty]
    println obj."$usrRequestedProperty"

    println obj."$usrRequestedMethod"()
    println obj.invokeMethod(usrRequestedMethod, null)
}

printInfo('hello')

println "Properties of 'hello' are: "
'hello'.properties.each { println it }