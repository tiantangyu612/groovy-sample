package me.flyness.groovy.overview.mop.compilemeta

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.ConstructorNode
import org.codehaus.groovy.ast.FieldNode
import org.codehaus.groovy.ast.GroovyClassVisitor
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.PropertyNode
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.syntax.SyntaxException
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

/**
 * Created by lizhitao on 2018/5/3.
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class CodeCheck implements ASTTransformation {

    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        source.ast.classes.each { classNode ->
            classNode.visitContents(new OurClassVisitor(source))
        }
    }
}

class OurClassVisitor implements GroovyClassVisitor {
    SourceUnit sourceUnit

    OurClassVisitor(source) {
        sourceUnit = source
    }

    private void reportError(message, lineNumber, columnNumber) {
        sourceUnit.addError(new SyntaxException(message, lineNumber, columnNumber))
    }

    @Override
    void visitMethod(MethodNode node) {
        if (node.name.size() == 1)
            reportError "Make method name descriptive, avoid single letter name",
                    node.lineNumber, node.columnNumber

        node.parameters.each { parameter ->
            if (parameter.name.size() == 1)
                reportError "Single letter parameters are morally wrong!",
                        parameter.lineNumber, parameter.columnNumber
        }
    }

    @Override
    void visitClass(ClassNode node) {}

    @Override
    void visitConstructor(ConstructorNode node) {}

    @Override
    void visitField(FieldNode node) {}

    @Override
    void visitProperty(PropertyNode node) {}
}