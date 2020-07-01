package leetcode_49_groupAnagrams;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

import java.util.*;


// @lc code=start
class Solution {
    /** 
     * 解决思路：
     *      思路1. 排序数组进行分组，通过一个<String,List<String>>数据结构来解决
     *      
     *      思路2. 当且仅当每个字么出现的次数一样的时候才是一组
     *      
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        groupAnagramsbySortedArray(strs);

        // groupAnagramsbySortedArray(strs);

        return groupAnagramsbySortedArray(strs);
    }

    /** 
     * Accepted
     * 101/101 cases passed (13 ms)
     * Your runtime beats 46.49 % of java submissions
     * Your memory usage beats 20.59 % of java submissions (44.2 MB)
    */
    public List<List<String>> groupAnagramsbySortedArray(String[] strs){
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        Map<String,List<String>> map = new HashMap<>();
        
        for (String string : strs) {
            char[] cts = string.toCharArray();
            Arrays.sort(cts);
            String newString = new String(cts);
            if(map.get(newString) != null){
                List<String> stringList = map.get(newString);
                stringList.add(string);
                // map.put(newString, stringList);

            }else{
                List<String> stringList= new ArrayList<>();
                stringList.add(string);
                map.put(newString,stringList);
            }
        }

        List<List<String>> ret = new ArrayList<>();
        
        for (String key : map.keySet()) {
            ret.add(map.get(key));
        }

        return ret;
    }

    public List<List<String>> groupAnagramsbyCount(String[] strs){
        return null;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> out = solution.groupAnagrams(strs);

        System.out.println(out.size()); 

        return;
    }
}
// @lc code=end

