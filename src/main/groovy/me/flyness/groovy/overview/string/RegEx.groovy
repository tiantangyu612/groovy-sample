package me.flyness.groovy.overview.string

/**
 * Created by lizhitao on 2018/4/27.
 */
obj = ~"hello"
println obj.getClass().name

pattern = ~"(G|g)roovy"
text = 'Groovy is Hip'
if (text =~ pattern)
    println 'match'
else
    println 'no match'

if (text ==~ pattern)
    println 'match'
else
    println 'no match'

matcher = 'Groovy is groovy' =~ /(G|g)roovy/
print "Size of matcher is ${matcher.size()} "
println "with elements ${matcher[0]} and ${matcher[1]}"

str = 'Groovy is groovy, really groovy'
println str
result = (str =~ /groovy/).replaceAll('hip')
println result