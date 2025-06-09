import java.util.*;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentToFilePaths = new HashMap<>();
        
        for (String path : paths) {
            String[] parts = path.split(" ");
            String root = parts[0];
            
            for (int i = 1; i < parts.length; i++) {
                String[] fileParts = parts[i].split("\\(");
                String fileName = fileParts[0];
                String content = fileParts[1].substring(0, fileParts[1].length() - 1);
                
                String filePath = root + "/" + fileName;
                contentToFilePaths.computeIfAbsent(content, k -> new ArrayList<>()).add(filePath);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> filePaths : contentToFilePaths.values()) {
            if (filePaths.size() > 1) {
                result.add(filePaths);
            }
        }
        
        return result;
    }
}