package club.justwrite.android.router.compiler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/5/9 3:12 PM
 **/
public class PathMapping {

    public List<PathMappingItem> mappings = new ArrayList<>();

    public static class PathMappingItem {
        public String path;
        public String targetClass;
        public boolean needLogin;
        public String description;
    }
}
