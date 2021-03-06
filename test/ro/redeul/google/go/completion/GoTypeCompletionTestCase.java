package ro.redeul.google.go.completion;

import org.junit.Ignore;

import java.io.IOException;

public class GoTypeCompletionTestCase extends GoCompletionTestCase {
    protected String getTestDataRelativePath() {
        return super.getTestDataRelativePath() + "types";
    }

    public void testListTypesOnly() throws IOException {
        _testVariants();
    }

    public void testAlsoListImportedPackages() throws IOException {
        addPackage("fmt", "fmt/fmt.go");
        _testVariants();
    }

    @Ignore("to be fixed")
    public void testMethodReceiver() throws IOException {
        _testVariants();
    }

    public void testFromImportedPackages() throws IOException {
        addPackage("test", "test/type1.go", "test/type2.go");
        _testVariants();
    }
    public void testFromDotImportedPackages() throws IOException {
        addPackage("test", "test/type1.go", "test/type2.go");
        _testVariants();
    }
}
