package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
class StringUtil {
    static toSSN(self) {
        if (self.size() == 9) {
            "${self[0..2]}-${self[3..4]}-${self[5..8]}"
        }
    }
}

use(StringUtil) {
    println "123456789".toSSN()
    println new StringBuilder("987654321").toSSN()
}

try {
    println "123456789".toSSN()
} catch (Exception e) {
    println e
}

@Category(String)
class StringUtilAnnotated {
    def toSSN() {
        if (size() == 9) {
            "${this[0..2]}-${this[3..4]}-${this[5..8]}"
        }
    }
}

use(StringUtilAnnotated) {
    println "123456789".toSSN()
}

class FindUtil {
    static extractOnly(String self, closure) {
        def result = ''
        self.each {
            if (closure(it)) {
                result += it
            }
        }
        result
    }
}

use(FindUtil) {
    println "121254123".extractOnly { it == '4' || it == '5' }
}

use(StringUtil, FindUtil) {
    str = '123487651'
    println str.toSSN()
    println str.extractOnly { it == '8' || it == '1' }
}

class Helper {
    static toString(String self) {
        def method = self.metaClass.metaMethods.find { it.name == 'toString' }
        '!!' + method.invoke(self, null) + '!!'
    }
}

use(Helper) {
    println 'hello'.toString()
}