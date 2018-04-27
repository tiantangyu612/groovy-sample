package me.flyness.groovy.overview.string

/**
 * Created by lizhitao on 2018/4/27.
 */
langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']

content = ''
langs.each { language, author ->
    fragment = """
        <language name="${language}">
            <author>${author}</author>
        </language>
    """

    content += fragment
}
xml = "<languages>${content}</languages>"
println xml