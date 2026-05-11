package questions.filter2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DirectoryScanner {
    public List<FileEntry> scan(Path path, FileFilter filter) {
        try{
            return Files.walk(path).filter(Files::isRegularFile).map((p)-> {
                try {
                    return new FileEntry(p.getFileName().toString(), Files.size(p));
                } catch (Exception e) {
                    return null;
                }
            }).filter(filter::matches).toList();
        } catch (Exception e) {
            throw new RuntimeException("Error scanning directory: " + path, e);
        }
    }
}
