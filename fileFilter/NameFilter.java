package questions.filter2;



public class NameFilter implements FileFilter {
    private String pattern;
    private String type;
    NameFilter(String pattern, String type) {
        this.pattern = pattern;
        this.type = type;
    }

    public boolean matches(FileEntry file) {
        switch(type){
            case "prefix":
                return file.getName().startsWith(pattern);
                case "suffix":
                    return file.getName().endsWith(pattern);
                case "contains":
                    return file.getName().contains(pattern);
                case "regex":
                    return file.getName().matches(pattern);
                default:
                    return false;
        }
    }
}
