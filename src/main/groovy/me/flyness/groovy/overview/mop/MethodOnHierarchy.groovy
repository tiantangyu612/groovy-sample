package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
daysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, (int) delegate)
    today.time
}
Integer.metaClass.daysFromNow = daysFromNow
Long.metaClass.daysFromNow = daysFromNow

println 5.daysFromNow()
println 5L.daysFromNow()

Number.metaClass.someMethod = { ->
    println 'someMethod called'
}
2.someMethod()
2L.someMethod()