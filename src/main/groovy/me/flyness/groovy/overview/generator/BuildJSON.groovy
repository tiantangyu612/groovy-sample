package me.flyness.groovy.overview.generator

import groovy.json.JsonBuilder

/**
 * Created by lizhitao on 2018/5/7.
 */
class Person {
    String first
    String last
    def sigs
    def tools
}

john = new Person(first: 'John', last: 'Smith', sigs: ['Java', 'Groovy'], tools: ['script': 'Groovy', test: 'Spock'])
bldr = new JsonBuilder(john)
writer = new StringWriter()
bldr.writeTo(writer)
println writer