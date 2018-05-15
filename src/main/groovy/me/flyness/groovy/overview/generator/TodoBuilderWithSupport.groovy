package me.flyness.groovy.overview.generator

/**
 * Created by lizhitao on 2018/5/15.
 */
class TodoBuilderWithSupport extends BuilderSupport {
    int level = 0
    def result = new StringWriter()

    @Override
    protected void setParent(Object parent, Object child) {}

    @Override
    protected Object createNode(Object name) {
        if (name == 'build') {
            result << "To-Do:\n"
            'buildnode'
        } else {
            handle(name, [:])
        }
    }

    @Override
    protected Object createNode(Object name, Object value) {
        throw new Exception("Invalid format")
    }

    @Override
    protected Object createNode(Object name, Map attributes) {
        handle(name, attributes)
    }

    @Override
    protected Object createNode(Object name, Map attributes, Object value) {
        throw new Exception("Invalid format")
    }

    def propertyMissing(String name) {
        handle(name, [:])
        level--
    }

    void nodeCompleted(parent, node) {
        level--
        if (node == 'buildnode') {
            println result
        }
    }

    def handle(String name, args) {
        level++
        level.times { result << " " }
        result << placeXifStatusDone(args)
        result << name.replaceAll("_", " ")
        result << printParameters(args)
        result << "\n"

        name
    }

    def placeXifStatusDone(args) {
        args['status'] == 'done' ? 'X ' : '- '
    }

    def printParameters(args) {
        def values = ''
        if (args.size() > 0) {
            values += " ["
            def count = 0
            args.each { key, value ->
                if (key == 'status')
                    return

                count++
                values += (count > 1 ? " " : "")
                values += "$key: $value"
            }
            values += "]"
        }
        values
    }
}
