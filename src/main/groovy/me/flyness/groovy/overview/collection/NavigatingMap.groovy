package me.flyness.groovy.overview.collection

/**
 * Created by lizhitao on 2018/4/27.
 */
langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']

langs.each { entry ->
    println "Language $entry.key was authored by $entry.value"
}

langs.each { language, author ->
    println "Language $language was authored by $author"
}

println langs.collect { language, author ->
    language.replaceAll("[+]", "P")
}

println "Looking for the first language with name greater than 3 characters"
entry = langs.find { language, author ->
    language.size() > 3
}
println "Found $entry.key written by $entry.value"


println "Looking for the all language with name greater than 3 characters"
selected = langs.findAll { language, author ->
    language.size() > 3
}
selected.each { key, value ->
    println "Found $key written by $value"
}

println "Does any language name have a nonalphabetic character?"
println langs.any { language, author ->
    language =~ "[^A-Za-z]"
}

println "Does all language name have a nonalphabetic character?"
println langs.every { language, author ->
    language =~ "[^A-Za-z]"
}

friends = [briang: 'Brian Goetz', brians: 'Brian Sletten',
           david : 'David Bock', davidg: 'David Geary',
           Scottd: 'Scott Davis'
]
groupByFirstName = friends.groupBy { it.value.split(' ')[0] }
groupByFirstName.each { firstName, buddies ->
    println "$firstName: ${buddies.collect { key, fullName -> fullName }.join(', ')}"
}