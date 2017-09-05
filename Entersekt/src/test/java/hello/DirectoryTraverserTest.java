package hello;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DirectoryTraverserTest {
    DirectoryTraverser traverser = new DirectoryTraverser();
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testDirectoryTraverserThrowsFileNotFoundExceptionWithInvalidPathName() throws IOException {
        // assert Statements
        exception.expect(FileNotFoundException.class);
        traverser.traverseDirectory("InvalidPath", 10);
    }

    @Test
    public void testDirectoryTraverserThrowsIllegalArgumentExceptionWithInvalidDepth() throws IOException {
        // assert Statements
        exception.expect(IllegalArgumentException.class);
        traverser.traverseDirectory(".", -1);
    }
}
