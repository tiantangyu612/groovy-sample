package me.flyness.groovy.overview.closuer

/**
 * Created by lizhitao on 2018/4/23.
 * 计算模拟器
 */
class Equipment {
    def calculator

    Equipment(calc) {
        calculator = calc
    }

    def sumulate() {
        println 'Running sumulate'
        calculator()
    }
}

def eq1 = new Equipment({ println 'Calculator 1' })
def aCalculator = { println "Calculator 2" }
def eq2 = new Equipment(aCalculator)
def eq3 = new Equipment(aCalculator)

eq1.sumulate()
eq2.sumulate()
eq3.sumulate()