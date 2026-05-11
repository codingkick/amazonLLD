package questions.filter2;

public class SizeFilter implements FileFilter {
    private long minSize;
    private long maxSize;
    SizeFilter(long minSize, long maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }
    public boolean matches(FileEntry file) {
        return file.getSize() >= minSize && file.getSize() <= maxSize;
    }
}
