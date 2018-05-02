package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
str = 'hello'
methodName = 'toUpperCase'
methodOfInterest = str.metaClass.getMetaMethod(methodName)
println methodOfInterest.invoke(str)

println 'Does String respond to toUpperCase()? '
println String.metaClass.respondsTo(str, 'toUpperCase') ? 'yes' : 'no'

println 'oes String respond to compareTo(String)? '
println String.metaClass.respondsTo(str, 'compareTo', 'test') ? 'yes' : 'no'

println 'Does String respond to toUpperCase(int)? '
println String.metaClass.respondsTo(str, 'toUpperCase', 1) ? 'yes' : 'no'