package hello;
import org.apache.log4j.Logger;

import java.nio.file.*;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@link Recurse} class dictates how the {@link DirectoryTraverser} walks over the file tree
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * The getFileAttributesFromPath is used to create a unique {@link FileAttributes} object for each file in the file path.
 *
 */


class Recurse implements FileVisitor<Path>{

    final static Logger logger = Logger.getLogger(DirectoryTraverserController.class);
    private long filesCount;
    private List<FileAttributes> list = new ArrayList<FileAttributes>();

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // when a file is visited increment the filesCount and add a new FileAttributes to the list
        filesCount++;
        list.add(getFileAttributesFromPath(file));

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public long getFilesCount() {
        // used to count total files in the directory
        return filesCount;
    }

    public List<FileAttributes> getFileAttributesList() {
        // getter for the List<FileAttributes> list
        return list;
    }

    private static FileAttributes getFileAttributesFromPath(Path file) {
        // Creates a new FileAttributes object for each file in the file path
        try {
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

            return new FileAttributes(
                    file.toString(),
                    attr.creationTime().toString(),
                    attr.lastAccessTime().toString(),
                    attr.lastModifiedTime().toString(),
                    attr.isSymbolicLink(),
                    attr.isDirectory(),
                    attr.size());
        } catch (IOException e) {
            logger.info("Something went wrong whiles creating FileAttributes object");
            throw new RuntimeException();
        }
    }



}


