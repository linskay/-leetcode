import java.util.*;

public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String parent = "";
        
        for (String path : folder) {
            if (parent.isEmpty() || !path.startsWith(parent + "/")) {
                parent = path;
                result.add(path);
            }
        }
        
        return result;
    }
}