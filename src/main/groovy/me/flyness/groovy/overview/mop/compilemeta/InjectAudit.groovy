package me.flyness.groovy.overview.mop.compilemeta

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.codehaus.groovy.ast.stmt.ExpressionStatement

/**
 * Created by lizhitao on 2018/5/7.
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class InjectAudit implements ASTTransformation {
    @Override
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        def checkingAccountClassNode = astNodes[0].class.find { it.name == 'CheckingAccount' }
        injectAuditMethod(checkingAccountClassNode)
    }

    static void injectAuditMethod(checkingAccountClassNode) {
        def nonAuditMethods = checkingAccountClassNode?.methods.findAll { it.name != 'audit' }
        nonAuditMethods?.each { injectMethodWithAudit(it) }
    }

    static void injectMethodWithAudit(methodNode) {
        def callToAudit = new ExpressionStatement(
                new MethodCallExpression(
                        new VariableExpression(this),
                        'audit',
                        new ArgumentListExpression(methodNode.parameters)
                )
        )

        methodNode.code.statements.add(0, callToAudit)
    }
}