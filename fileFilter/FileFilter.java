package questions.filter2;

public interface FileFilter {
    boolean matches(FileEntry file);

    default FileFilter add(FileFilter other) {
        return file -> this.matches(file) && other.matches(file);
    }

    default FileFilter or(FileFilter other) {
        return file -> this.matches(file) || other.matches(file);
    }
}
