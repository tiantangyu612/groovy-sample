package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
Integer.metaClass {
    daysFromNow = { ->
        Calendar today = Calendar.instance
        today.add(Calendar.DAY_OF_MONTH, delegate)
        today.time
    }

    getDaysFromNow = { ->
        Calendar today = Calendar.instance
        today.add(Calendar.DAY_OF_MONTH, delegate)
        today.time
    }

    'static' {
        isEven = { val -> val % 2 == 0 }
    }

    constructor = { Calendar calendar ->
        new Integer(calendar.get(Calendar.DAY_OF_YEAR))
    }

    constructor = { int val ->
        println "Intercepting constructor call"
        constructor = Integer.class.getConstructor(Integer.TYPE)
        constructor.newInstance(val)
    }
}

println 5.daysFromNow