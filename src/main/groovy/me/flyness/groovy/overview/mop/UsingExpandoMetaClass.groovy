package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
Integer.metaClass.daysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, delegate)
    today.time
}
println 5.daysFromNow()

Integer.metaClass.getDaysFormNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, delegate)
    today.time
}
println 5.daysFormNow

Integer.metaClass.'static'.isEven = { val -> val % 2 == 0 }
println "Is 2 even? " + Integer.isEven(2)
println "Is 3 even? " + Integer.isEven(3)

Integer.metaClass.constructor << { Calendar calendar ->
    new Integer(calendar.get(Calendar.DAY_OF_YEAR))
}
println new Integer(Calendar.instance)

Integer.metaClass.constructor = { int val ->
    println "Intercepting constructor call"
    constructor = Integer.class.getConstructor(Integer.TYPE)
    constructor.newInstance(val)
}
println new Integer(4)
println new Integer(Calendar.instance)