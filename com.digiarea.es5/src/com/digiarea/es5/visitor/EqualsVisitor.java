package com.digiarea.es5.visitor;

import com.digiarea.es5.Node;
import com.digiarea.es5.visitor.GenericVisitor;
import java.util.List;
import com.digiarea.es5.AllocationExpression;
import com.digiarea.es5.ArrayAccessExpression;
import com.digiarea.es5.ArrayLiteral;
import com.digiarea.es5.AssignmentExpression;
import com.digiarea.es5.AssignmentExpression.AssignOperator;
import com.digiarea.es5.BinaryExpression;
import com.digiarea.es5.BinaryExpression.BinaryOperator;
import com.digiarea.es5.Block;
import com.digiarea.es5.BlockComment;
import com.digiarea.es5.BooleanLiteral;
import com.digiarea.es5.BreakStatement;
import com.digiarea.es5.CallExpression;
import com.digiarea.es5.CaseBlock;
import com.digiarea.es5.CaseClause;
import com.digiarea.es5.CatchClause;
import com.digiarea.es5.CompilationUnit;
import com.digiarea.es5.ConditionalExpression;
import com.digiarea.es5.ConstantStatement;
import com.digiarea.es5.ContinueStatement;
import com.digiarea.es5.DebuggerStatement;
import com.digiarea.es5.DecimalLiteral;
import com.digiarea.es5.DefaultClause;
import com.digiarea.es5.DoWhileStatement;
import com.digiarea.es5.EmptyLiteral;
import com.digiarea.es5.EmptyStatement;
import com.digiarea.es5.EnclosedExpression;
import com.digiarea.es5.ExpressionStatement;
import com.digiarea.es5.FieldAccessExpression;
import com.digiarea.es5.FloatLiteral;
import com.digiarea.es5.ForeachStatement;
import com.digiarea.es5.ForStatement;
import com.digiarea.es5.FunctionDeclaration;
import com.digiarea.es5.FunctionExpression;
import com.digiarea.es5.GetAssignment;
import com.digiarea.es5.HexIntegerLiteral;
import com.digiarea.es5.IdentifierName;
import com.digiarea.es5.IfStatement;
import com.digiarea.es5.ImportStatement;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.LabelledStatement;
import com.digiarea.es5.LetDefinition;
import com.digiarea.es5.LetExpression;
import com.digiarea.es5.LetStatement;
import com.digiarea.es5.LineComment;
import com.digiarea.es5.NewExpression;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.NullLiteral;
import com.digiarea.es5.ObjectLiteral;
import com.digiarea.es5.OctalLiteral;
import com.digiarea.es5.Parameter;
import com.digiarea.es5.Project;
import com.digiarea.es5.PutAssignment;
import com.digiarea.es5.RegexpLiteral;
import com.digiarea.es5.ReturnStatement;
import com.digiarea.es5.SequenceExpression;
import com.digiarea.es5.SetAssignment;
import com.digiarea.es5.StringLiteralDouble;
import com.digiarea.es5.StringLiteralSingle;
import com.digiarea.es5.SuperExpression;
import com.digiarea.es5.SwitchStatement;
import com.digiarea.es5.ThisExpression;
import com.digiarea.es5.ThrowStatement;
import com.digiarea.es5.TryStatement;
import com.digiarea.es5.UnaryExpression;
import com.digiarea.es5.UnaryExpression.UnaryOperator;
import com.digiarea.es5.VariableDeclaration;
import com.digiarea.es5.VariableExpression;
import com.digiarea.es5.VariableStatement;
import com.digiarea.es5.WhileStatement;
import com.digiarea.es5.WithStatement;

@SuppressWarnings("unchecked")
public class EqualsVisitor implements GenericVisitor<Boolean, Node> {

    private static final EqualsVisitor SINGLETON = new EqualsVisitor();

    public static boolean equals(Node n1, Node n2) throws Exception {
        return SINGLETON.nodeEquals(n1, n2);
    }

    protected <T extends Node> boolean nodeEquals(T n1, T n2) throws Exception {
        if (n1 == n2) {
            return true;
        }
        if (n1 == null) {
            if (n2 == null) {
                return true;
            }
            return false;
        } else if (n2 == null) {
            return false;
        }
        if (n1.getClass() != n2.getClass()) {
            return false;
        }
        return n1.accept(this, n2).booleanValue();
    }

    protected <T extends Node> boolean nodesEquals(List<T> nodes1, List<T> nodes2) throws Exception {
        if (nodes1 == null) {
            if (nodes2 == null) {
                return true;
            }
            return false;
        } else if (nodes2 == null) {
            return false;
        }
        if (nodes1.size() != nodes2.size()) {
            return false;
        }
        for (int i = 0; i < nodes1.size(); i++) {
            if (!nodeEquals(nodes1.get(i), nodes2.get(i))) {
                return false;
            }
        }
        return true;
    }

    protected boolean objEquals(Object n1, Object n2) {
        if (n1 == n2) {
            return true;
        }
        if (n1 == null) {
            if (n2 == null) {
                return true;
            }
            return false;
        } else if (n2 == null) {
            return false;
        }
        return n1.equals(n2);
    }

    @Override
    public Boolean visit(AllocationExpression n, Node ctx) throws Exception {
        AllocationExpression x = (AllocationExpression) ctx;
        if (!nodeEquals(n.getBody(), x.getBody())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ArrayAccessExpression n, Node ctx) throws Exception {
        ArrayAccessExpression x = (ArrayAccessExpression) ctx;
        if (!nodeEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getIndex(), x.getIndex())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ArrayLiteral n, Node ctx) throws Exception {
        ArrayLiteral x = (ArrayLiteral) ctx;
        if (!nodeEquals(n.getExpressions(), x.getExpressions())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(AssignmentExpression n, Node ctx) throws Exception {
        AssignmentExpression x = (AssignmentExpression) ctx;
        if (!nodeEquals(n.getTarget(), x.getTarget())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        if (n.getAssignOperator() != x.getAssignOperator()) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(AssignOperator n, Node ctx) throws Exception {
        return java.lang.Boolean.FALSE;
    }

    @Override
    public Boolean visit(BinaryExpression n, Node ctx) throws Exception {
        BinaryExpression x = (BinaryExpression) ctx;
        if (!nodeEquals(n.getLeft(), x.getLeft())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getRight(), x.getRight())) {
            return java.lang.Boolean.FALSE;
        }
        if (n.getBinaryOperator() != x.getBinaryOperator()) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(BinaryOperator n, Node ctx) throws Exception {
        return java.lang.Boolean.FALSE;
    }

    @Override
    public Boolean visit(Block n, Node ctx) throws Exception {
        Block x = (Block) ctx;
        if (!nodeEquals(n.getStatements(), x.getStatements())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(BlockComment n, Node ctx) throws Exception {
        BlockComment x = (BlockComment) ctx;
        if (!objEquals(n.getContent(), x.getContent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(BooleanLiteral n, Node ctx) throws Exception {
        BooleanLiteral x = (BooleanLiteral) ctx;
        if (n.isValue() != x.isValue()) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(BreakStatement n, Node ctx) throws Exception {
        BreakStatement x = (BreakStatement) ctx;
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(CallExpression n, Node ctx) throws Exception {
        CallExpression x = (CallExpression) ctx;
        if (!nodeEquals(n.getScope(), x.getScope())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getArgs(), x.getArgs())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(CaseBlock n, Node ctx) throws Exception {
        CaseBlock x = (CaseBlock) ctx;
        if (!nodeEquals(n.getDefaultClause(), x.getDefaultClause())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getCaseClauses(), x.getCaseClauses())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(CaseClause n, Node ctx) throws Exception {
        CaseClause x = (CaseClause) ctx;
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getStatements(), x.getStatements())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(CatchClause n, Node ctx) throws Exception {
        CatchClause x = (CatchClause) ctx;
        if (!objEquals(n.getString(), x.getString())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getBlock(), x.getBlock())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(CompilationUnit n, Node ctx) throws Exception {
        CompilationUnit x = (CompilationUnit) ctx;
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ConditionalExpression n, Node ctx) throws Exception {
        ConditionalExpression x = (ConditionalExpression) ctx;
        if (!nodeEquals(n.getCondition(), x.getCondition())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getThenExpr(), x.getThenExpr())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getElseExpr(), x.getElseExpr())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ConstantStatement n, Node ctx) throws Exception {
        ConstantStatement x = (ConstantStatement) ctx;
        if (!nodeEquals(n.getVariableDeclarations(), x.getVariableDeclarations())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ContinueStatement n, Node ctx) throws Exception {
        ContinueStatement x = (ContinueStatement) ctx;
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(DebuggerStatement n, Node ctx) throws Exception {
        return ctx instanceof DebuggerStatement;
    }

    @Override
    public Boolean visit(DecimalLiteral n, Node ctx) throws Exception {
        DecimalLiteral x = (DecimalLiteral) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(DefaultClause n, Node ctx) throws Exception {
        DefaultClause x = (DefaultClause) ctx;
        if (!nodeEquals(n.getStatements(), x.getStatements())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(DoWhileStatement n, Node ctx) throws Exception {
        DoWhileStatement x = (DoWhileStatement) ctx;
        if (!nodeEquals(n.getCondition(), x.getCondition())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getBody(), x.getBody())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(EmptyLiteral n, Node ctx) throws Exception {
        return ctx instanceof EmptyLiteral;
    }

    @Override
    public Boolean visit(EmptyStatement n, Node ctx) throws Exception {
        return ctx instanceof EmptyStatement;
    }

    @Override
    public Boolean visit(EnclosedExpression n, Node ctx) throws Exception {
        EnclosedExpression x = (EnclosedExpression) ctx;
        if (!nodeEquals(n.getInner(), x.getInner())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ExpressionStatement n, Node ctx) throws Exception {
        ExpressionStatement x = (ExpressionStatement) ctx;
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(FieldAccessExpression n, Node ctx) throws Exception {
        FieldAccessExpression x = (FieldAccessExpression) ctx;
        if (!nodeEquals(n.getScope(), x.getScope())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getField(), x.getField())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(FloatLiteral n, Node ctx) throws Exception {
        FloatLiteral x = (FloatLiteral) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ForeachStatement n, Node ctx) throws Exception {
        ForeachStatement x = (ForeachStatement) ctx;
        if (!nodeEquals(n.getVariable(), x.getVariable())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getBody(), x.getBody())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ForStatement n, Node ctx) throws Exception {
        ForStatement x = (ForStatement) ctx;
        if (!nodeEquals(n.getVariable(), x.getVariable())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getCondition(), x.getCondition())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getExpr(), x.getExpr())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getBody(), x.getBody())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(FunctionDeclaration n, Node ctx) throws Exception {
        FunctionDeclaration x = (FunctionDeclaration) ctx;
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParameters(), x.getParameters())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getBody(), x.getBody())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(FunctionExpression n, Node ctx) throws Exception {
        FunctionExpression x = (FunctionExpression) ctx;
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParameters(), x.getParameters())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getBody(), x.getBody())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(GetAssignment n, Node ctx) throws Exception {
        GetAssignment x = (GetAssignment) ctx;
        if (!nodeEquals(n.getBlock(), x.getBlock())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getPropertyName(), x.getPropertyName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getComment(), x.getComment())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(HexIntegerLiteral n, Node ctx) throws Exception {
        HexIntegerLiteral x = (HexIntegerLiteral) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(IdentifierName n, Node ctx) throws Exception {
        IdentifierName x = (IdentifierName) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(IfStatement n, Node ctx) throws Exception {
        IfStatement x = (IfStatement) ctx;
        if (!nodeEquals(n.getCondition(), x.getCondition())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getThenStatement(), x.getThenStatement())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getElseStatement(), x.getElseStatement())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ImportStatement n, Node ctx) throws Exception {
        ImportStatement x = (ImportStatement) ctx;
        if (!nodeEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(JSDocComment n, Node ctx) throws Exception {
        JSDocComment x = (JSDocComment) ctx;
        if (!objEquals(n.getContent(), x.getContent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(LabelledStatement n, Node ctx) throws Exception {
        LabelledStatement x = (LabelledStatement) ctx;
        if (!objEquals(n.getLabel(), x.getLabel())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getStatement(), x.getStatement())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(LetDefinition n, Node ctx) throws Exception {
        LetDefinition x = (LetDefinition) ctx;
        if (!nodeEquals(n.getVariableDeclarations(), x.getVariableDeclarations())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(LetExpression n, Node ctx) throws Exception {
        LetExpression x = (LetExpression) ctx;
        if (!nodeEquals(n.getVariableDeclarations(), x.getVariableDeclarations())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(LetStatement n, Node ctx) throws Exception {
        LetStatement x = (LetStatement) ctx;
        if (!nodeEquals(n.getVariableDeclarations(), x.getVariableDeclarations())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getStatement(), x.getStatement())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(LineComment n, Node ctx) throws Exception {
        LineComment x = (LineComment) ctx;
        if (!objEquals(n.getContent(), x.getContent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(NewExpression n, Node ctx) throws Exception {
        NewExpression x = (NewExpression) ctx;
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getInitializer(), x.getInitializer())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public <E extends Node> Boolean visit(NodeList<E> n, Node ctx) throws Exception {
        NodeList<E> x = (NodeList<E>) ctx;
        if (!nodesEquals(n.getNodes(), x.getNodes())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(NullLiteral n, Node ctx) throws Exception {
        return ctx instanceof NullLiteral;
    }

    @Override
    public Boolean visit(ObjectLiteral n, Node ctx) throws Exception {
        ObjectLiteral x = (ObjectLiteral) ctx;
        if (!nodeEquals(n.getPropertyAssignments(), x.getPropertyAssignments())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(OctalLiteral n, Node ctx) throws Exception {
        OctalLiteral x = (OctalLiteral) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(Parameter n, Node ctx) throws Exception {
        Parameter x = (Parameter) ctx;
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(Project n, Node ctx) throws Exception {
        Project x = (Project) ctx;
        if (!nodeEquals(n.getCompilationUnits(), x.getCompilationUnits())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(PutAssignment n, Node ctx) throws Exception {
        PutAssignment x = (PutAssignment) ctx;
        if (!nodeEquals(n.getPropertyValue(), x.getPropertyValue())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getPropertyName(), x.getPropertyName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getComment(), x.getComment())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(RegexpLiteral n, Node ctx) throws Exception {
        RegexpLiteral x = (RegexpLiteral) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ReturnStatement n, Node ctx) throws Exception {
        ReturnStatement x = (ReturnStatement) ctx;
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(SequenceExpression n, Node ctx) throws Exception {
        SequenceExpression x = (SequenceExpression) ctx;
        if (!nodeEquals(n.getExpressions(), x.getExpressions())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(SetAssignment n, Node ctx) throws Exception {
        SetAssignment x = (SetAssignment) ctx;
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getBlock(), x.getBlock())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getPropertyName(), x.getPropertyName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getComment(), x.getComment())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(StringLiteralDouble n, Node ctx) throws Exception {
        StringLiteralDouble x = (StringLiteralDouble) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(StringLiteralSingle n, Node ctx) throws Exception {
        StringLiteralSingle x = (StringLiteralSingle) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(SuperExpression n, Node ctx) throws Exception {
        return ctx instanceof SuperExpression;
    }

    @Override
    public Boolean visit(SwitchStatement n, Node ctx) throws Exception {
        SwitchStatement x = (SwitchStatement) ctx;
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getBlock(), x.getBlock())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ThisExpression n, Node ctx) throws Exception {
        return ctx instanceof ThisExpression;
    }

    @Override
    public Boolean visit(ThrowStatement n, Node ctx) throws Exception {
        ThrowStatement x = (ThrowStatement) ctx;
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(TryStatement n, Node ctx) throws Exception {
        TryStatement x = (TryStatement) ctx;
        if (!nodeEquals(n.getTryBlock(), x.getTryBlock())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getCatchClause(), x.getCatchClause())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getFinallyBlock(), x.getFinallyBlock())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(UnaryExpression n, Node ctx) throws Exception {
        UnaryExpression x = (UnaryExpression) ctx;
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        if (n.getUnaryOperator() != x.getUnaryOperator()) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(UnaryOperator n, Node ctx) throws Exception {
        return java.lang.Boolean.FALSE;
    }

    @Override
    public Boolean visit(VariableDeclaration n, Node ctx) throws Exception {
        VariableDeclaration x = (VariableDeclaration) ctx;
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(VariableExpression n, Node ctx) throws Exception {
        VariableExpression x = (VariableExpression) ctx;
        if (!nodeEquals(n.getVariableDeclarations(), x.getVariableDeclarations())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(VariableStatement n, Node ctx) throws Exception {
        VariableStatement x = (VariableStatement) ctx;
        if (!nodeEquals(n.getVariableDeclarations(), x.getVariableDeclarations())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(WhileStatement n, Node ctx) throws Exception {
        WhileStatement x = (WhileStatement) ctx;
        if (!nodeEquals(n.getCondition(), x.getCondition())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getBody(), x.getBody())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(WithStatement n, Node ctx) throws Exception {
        WithStatement x = (WithStatement) ctx;
        if (!nodeEquals(n.getExpression(), x.getExpression())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getStatement(), x.getStatement())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    public EqualsVisitor() {
        super();
    }

}
