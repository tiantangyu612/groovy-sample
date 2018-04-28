package me.flyness.groovy.overview.gdk

/**
 * Created by lizhitao on 2018/4/28.
 * 简介访问属性
 */
class Car {
    int miles, fuelLevel
}

car = new Car(fuelLevel: 20, miles: 25)

properties = ['miles', 'fuelLevel']
properties.each { name ->
    println "$name = ${car[name]}"
}
car[properties[1]] = 100
println "fuelLevel now is ${car[properties[1]]}"