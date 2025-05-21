import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> ans = new HashMap<>();
        for (String domain : cpdomains) {
            String[] parts = domain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String[] frags = parts[1].split("\\.");
            for (int i = 0; i < frags.length; i++) {
                String subdomain = String.join(".", Arrays.copyOfRange(frags, i, frags.length));
                ans.put(subdomain, ans.getOrDefault(subdomain, 0) + count);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ans.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}