package hello;

/**
 * The {@link FileAttributes} class is used by the {@link Recurse} class to create an object containing all the file attributes of interest of the visited file
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

public class FileAttributes {
    private final String path;
    private final String creationTime;
    private final String lastAccessTime;
    private final String lastModifiedTime;
    private final Boolean isSymbolicLink;
    private final Boolean isDirectory;
    private final long size;

    public FileAttributes(String path, String creationTime, String lastAccessTime, String lastModifiedTime, Boolean isSymbolicLink, Boolean isDirectory, long size) {
        this.path = path;
        this.creationTime = creationTime;
        this.lastAccessTime = lastAccessTime;
        this.lastModifiedTime = lastModifiedTime;
        this.isSymbolicLink = isSymbolicLink;
        this.isDirectory = isDirectory;
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public Boolean getSymbolicLink() {
        return isSymbolicLink;
    }

    public Boolean getDirectory() {
        return isDirectory;
    }

    public long getSize() {
        return size;
    }
}
