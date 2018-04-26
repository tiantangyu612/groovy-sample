package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/26.
 * 尾递归
 */
def factorial(int factorialFor) {
    def tailFactorial
    tailFactorial = {
        int number, BigInteger theFactorial = 1 ->
            number == 1 ? theFactorial : tailFactorial.trampoline(number - 1, number * theFactorial)
    }.trampoline()
    tailFactorial(factorialFor)
}

println "factorial of 5 is ${factorial(5)}"
println "Number of bits in the result is ${factorial(5000).bitCount()}"