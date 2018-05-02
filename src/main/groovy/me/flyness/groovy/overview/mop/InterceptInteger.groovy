package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
Integer.metaClass.invokeMethod = { String name, args ->
    System.out.println("Call to $name intercepted on $delegate...")

    def validMethod = Integer.metaClass.getMetaMethod(name, args)
    if (null == validMethod) {
        Integer.metaClass.invokeMissingMethod(delegate, name, args)
    } else {
        System.out.println "running pre-filter..."
        result = validMethod.invoke(delegate, args)
        System.out.println "running post-filter..."
        result
    }
}

println 5.floatValue()
println 5.intValue()
try {
    println 5.empty()
} catch (Exception e) {
    println e
}

println Integer.metaClass.getClass().name