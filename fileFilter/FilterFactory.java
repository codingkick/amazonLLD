package questions.filter2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FilterFactory {
    public static FileFilter createFilter(String filterType, String... params) {
        switch (filterType.toLowerCase()) {
            case "name":
                if (params.length != 2) throw new IllegalArgumentException("NameFilter requires 2 parameters: pattern and type");
                return new NameFilter(params[0], params[1]);
            case "size":
                if (params.length != 2) throw new IllegalArgumentException("SizeFilter requires 2 parameters: minSize and maxSize");
                long minSize = Long.parseLong(params[0]);
                long maxSize = Long.parseLong(params[1]);
                return new SizeFilter(minSize, maxSize);
            default:
                throw new IllegalArgumentException("Unknown filter type: " + filterType);
        }
    }
}
