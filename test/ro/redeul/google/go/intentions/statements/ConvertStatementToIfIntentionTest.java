package ro.redeul.google.go.intentions.statements;

import org.junit.Ignore;
import ro.redeul.google.go.intentions.GoIntentionTestCase;

//This Test Covers The ConvertStatementToForWhileIntention too, since the only thing that changes is the first string from "if " to "for "
public class ConvertStatementToIfIntentionTest extends GoIntentionTestCase {
    public void testSimpleExpression() throws Exception {
        doTest();
    }

    public void testLogicalExpression() throws Exception {
        doTest();
    }

    @Ignore("broken by the new resolver")
    public void testCallExpression() throws Exception {
        doTest();
    }

    public void testVarExpression() throws Exception {
        doTest();
    }

    public void testIssue394() throws Exception {
        doTest();
    }

}
