package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/26.
 */
def factorial

factorial = {
    int number, BigInteger theFactorial ->
        number == 1 ? theFactorial :
                factorial.trampoline(number - 1, number * theFactorial)
}.trampoline()

println "factorial of 5 is ${factorial(5, 1)}"
println "Number of bits in the result is ${factorial(5000, 1).bitCount()}"