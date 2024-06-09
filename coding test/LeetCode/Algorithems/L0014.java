class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.longestCommonPrefix(new String[] {"flower", "flow", "flight"})); // "fl"
        System.out.println(solver.longestCommonPrefix(new String[] {"dog", "racecar", "car"})); // ""
        System.out.println(solver.longestCommonPrefix(new String[] {"interspecies", "interstellar", "interstate"})); // "inters"
        System.out.println(solver.longestCommonPrefix(new String[] {"throne", "throne"})); // "throne"
        System.out.println(solver.longestCommonPrefix(new String[] {"throne", ""})); // ""
    }
}
