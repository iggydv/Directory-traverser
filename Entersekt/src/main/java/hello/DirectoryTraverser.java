package hello;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.List;

/**
 * The {@link DirectoryTraverser} receives two input parameters:
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * String directory: the starting directory for the DirectoryTraverser object
 * int maxValue: the Maximum depth that the DirectoryTraverser object is allowed to traverse
 *
 * The {@link DirectoryTraverser} uses the {@link Recurse} that is used to walk the file tree.
 * The {@link Recurse} class sets visitation rules for the traverser and effectively builds the {@link List} of {@link FileAttributes} objects
 *
 * The {@link DepthValidator} class is used to validate incoming 'maxValue' parameters.
 */

public class DirectoryTraverser {

    private List<FileAttributes> output = null;

    public List<FileAttributes> traverseDirectory(String directory, int maxValue) throws IOException {

        Path path = Paths.get(directory);
        try{
            if (Files.exists(path)) {
                System.out.print(path);
                Recurse r = new Recurse();
                Files.walkFileTree(path, EnumSet.noneOf(FileVisitOption.class), maxValue, r);
                output = r.getFileAttributesList();

                DepthValidator validator = new DepthValidator();
                // check if the input is an integer and whether it is a positive integer

                if (!validator.supports(maxValue))
                {
                    System.out.print("Supports: "+validator.supports(maxValue));
                    throw new IllegalArgumentException();
                }
                else if (!validator.positive(maxValue)){
                    System.out.print("Positive: "+validator.positive(maxValue));
                    throw new IllegalArgumentException();
                }

            }
            else {
                throw new FileNotFoundException();
            }
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        catch (IOException e) {
            throw new IOException();

        }

        return output;
    }
}