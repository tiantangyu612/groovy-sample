package me.flyness.groovy.overview.mop.summary

/**
 * Created by lizhitao on 2018/5/3.
 */
data = new File('car.dat').readLines()

props = data[0].split(', ')
data -= data[0]

def averageMilesDrivenPerYear = { miles.toLong() / (2008 - year.toLong()) }

cars = data.collect {
    car = new Expando()
    it.split(', ').eachWithIndex { String value, int index ->
        car[props[index]] = value
    }

    car.ampy = averageMilesDrivenPerYear

    car
}

props.each { name -> print "$name " }
println " Avg. MPY"

ampyMethod = 'ampy'
cars.each { car ->
    for (String property : props) {
        print "${car[property]}"
    }
    println car."$ampyMethod"()
}

car = cars[0]
println "$car.miles $car.year $car.make ${car.ampy()}"